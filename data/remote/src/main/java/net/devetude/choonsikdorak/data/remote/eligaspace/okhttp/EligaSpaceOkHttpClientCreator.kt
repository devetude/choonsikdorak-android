package net.devetude.choonsikdorak.data.remote.eligaspace.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal class EligaSpaceOkHttpClientCreator(
    private val httpLoggingInterceptor: HttpLoggingInterceptor
) {
    fun create(): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(httpLoggingInterceptor)
        .build()
}
