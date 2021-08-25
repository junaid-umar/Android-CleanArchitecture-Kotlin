package com.coinranking.domain.util

interface DomainMapper<T, DomainModel> {
    fun toDomainModel(model: T): DomainModel
    fun fromDomainModel(domainModel: DomainModel): T
}