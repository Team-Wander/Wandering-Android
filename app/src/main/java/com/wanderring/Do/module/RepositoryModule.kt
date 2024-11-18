package com.wanderring.Do.module

import com.wanderring.data.common.address.AddressRepositoryImpl
import com.wanderring.data.common.tokenData.UserDataRepositoryImpl
import com.wanderring.domain.model.repository.userData.UserDataRepository
import com.wanderring.domain.model.repository.address.AddressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl
    ): UserDataRepository

    @Binds
    abstract fun provideAddressRepository(
        addressRepositoryImpl: AddressRepositoryImpl
    ): AddressRepository
}