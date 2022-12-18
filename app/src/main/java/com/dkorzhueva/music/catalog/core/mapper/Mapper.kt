package com.dkorzhueva.music.catalog.core.mapper

interface Mapper<T, R> {
    fun mapToEntity(data: R): T
}