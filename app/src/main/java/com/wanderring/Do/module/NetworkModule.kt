package com.wanderring.Do.module

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wanderring.Do.BuildConfig
import com.wanderring.Do.module.util.AddressRetrofit
import com.wanderring.Do.module.util.DefaultRetrofit
import com.wanderring.data.common.address.AddressApi
import com.wanderring.data.utill.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("HTTP", message) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        tokenInterceptor: TokenInterceptor
    ) = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(tokenInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideMoshiInstance(): Moshi =
        Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideMoshiJsonAdapterInstance(moshi: Moshi): JsonAdapter<String> =
        moshi.adapter(String::class.java)


    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @DefaultRetrofit
    @Provides
    @Singleton
    fun provideDefaultRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

    @AddressRetrofit
    @Provides
    @Singleton
    fun provideAddressRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.ADDRESS_URL)
        .client(okHttpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

    @Provides
    @Singleton
    fun provideRankAPI(
        @AddressRetrofit retrofit: Retrofit
    ): AddressApi {
        return retrofit.create(AddressApi::class.java)
    }
}