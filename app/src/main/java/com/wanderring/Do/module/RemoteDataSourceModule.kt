package com.wanderring.Do.module

import com.wanderring.data.common.address.AddressDataSource
import com.wanderring.data.common.address.AddressDataSourceImpl
import com.wanderring.data.common.auth.AuthDataSource
import com.wanderring.data.common.auth.AuthDataSourceImpl
import com.wanderring.data.common.school.SchoolDataSource
import com.wanderring.data.common.school.SchoolDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideAddressDataSource(
        addressDataSourceImpl: AddressDataSourceImpl
    ): AddressDataSource

    @Binds
    abstract fun provideSchoolDataSource(
        schoolDataSourceImpl: SchoolDataSourceImpl,
    ): SchoolDataSource

    @Binds
    abstract fun provideAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource
}