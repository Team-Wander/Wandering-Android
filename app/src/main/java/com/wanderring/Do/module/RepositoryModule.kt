package com.wanderring.Do.module

import com.wanderring.data.dataSource.repositoryImpl.UserDataRepositoryImpl
import com.wanderring.domain.model.repository.UserDataRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    abstract fun provideUserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl
    ): UserDataRepository
}