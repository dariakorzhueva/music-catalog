package com.dkorzhueva.music.catalog.core.usecase

interface UseCase<T, R> {
    suspend fun process(input: T): R
}