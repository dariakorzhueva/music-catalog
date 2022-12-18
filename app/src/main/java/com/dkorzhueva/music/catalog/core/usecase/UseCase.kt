package com.dkorzhueva.music.catalog.core.usecase

import kotlinx.coroutines.*

abstract class UseCase<T, R>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(dispatcher + job)

    abstract suspend fun process(input: T): Result<R>

    suspend fun execute(
        input: T,
        onSuccess: () -> Unit,
        onError: (error: Throwable?) -> Unit
    ) {
        val job = coroutineScope {
            async(dispatcher) {
                process(input)
            }
        }
        scope.launch {
            try {
                val result = job.await()
                if (result.isSuccess) {
                    onSuccess()
                } else {
                    onError(result.exceptionOrNull())
                }
            } catch (e: Exception) {
                onError(e)
            }
        }

    }
}