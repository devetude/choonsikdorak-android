package net.devetude.choonsikdorak.data.remote.eligaspace.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import net.devetude.choonsikdorak.data.remote.eligaspace.gson.EligaSpaceGsonConverterFactoryCreator
import net.devetude.choonsikdorak.data.remote.eligaspace.okhttp.EligaSpaceHttpLoggingInterceptorCreator
import net.devetude.choonsikdorak.data.remote.eligaspace.okhttp.EligaSpaceOkHttpClientCreator
import net.devetude.choonsikdorak.data.remote.eligaspace.retrofit.EligaSpaceRetrofitCreator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object EligaSpaceModule {
    @Provides
    @Singleton
    @EligaSpaceComponent
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        EligaSpaceHttpLoggingInterceptorCreator().create()

    @Provides
    @Singleton
    @EligaSpaceComponent
    fun provideOkHttpClient(
        @EligaSpaceComponent httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = EligaSpaceOkHttpClientCreator(httpLoggingInterceptor).create()

    @Provides
    @Singleton
    @EligaSpaceComponent
    fun provideGsonConverterFactory(): GsonConverterFactory =
        EligaSpaceGsonConverterFactoryCreator().create()

    @Provides
    @Singleton
    @EligaSpaceComponent
    fun provideRetrofit(
        @EligaSpaceComponent okHttpClient: OkHttpClient,
        @EligaSpaceComponent gsonConverterFactory: GsonConverterFactory
    ): Retrofit = EligaSpaceRetrofitCreator(okHttpClient, gsonConverterFactory).create()
}
