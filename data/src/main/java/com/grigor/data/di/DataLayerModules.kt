package com.grigor.data.di

import com.grigor.data.BuildConfig
import com.grigor.data.network.apiHelpers.WellsApiHelper
import com.grigor.data.network.apiServices.WellsApiService
import com.grigor.data.network.interceptors.NetworkInterceptor
import com.grigor.data.repository_impl.WellsListRepositoryImpl
import com.grigor.domain.repository.WellsListRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataLayerModules = module {

    single {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).client(get()).build()
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(NetworkInterceptor(androidContext()))
            .build()
    }

    factory<WellsApiService> { get<Retrofit>().create(WellsApiService::class.java) }
    factory { WellsApiHelper(get()) }
    factory<WellsListRepository> { WellsListRepositoryImpl(get()) }
}