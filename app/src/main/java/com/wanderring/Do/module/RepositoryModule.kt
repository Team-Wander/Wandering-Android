package com.wanderring.Do.module

import com.wanderring.data.common.address.AddressRepositoryImpl
import com.wanderring.data.common.school.SchoolDataSourceImpl
import com.wanderring.data.common.school.SchoolRepositoryImpl
import com.wanderring.data.common.tokenData.UserDataRepositoryImpl
import com.wanderring.domain.repository.UserDataRepository
import com.wanderring.domain.repository.AddressRepository
import com.wanderring.domain.repository.SchoolRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl,
    ): UserDataRepository

    @Binds
    abstract fun provideAddressRepository(
        addressRepositoryImpl: AddressRepositoryImpl,
    ): AddressRepository

    @Binds
    abstract fun provideSchoolRepository(
        schoolRepositoryImpl: SchoolRepositoryImpl,
    ): SchoolRepository
}