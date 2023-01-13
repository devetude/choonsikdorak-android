package net.devetude.choonsikdorak.data.remote.eligaspace.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class EligaSpaceRetrofitCreator(
    private val okHttpClient: OkHttpClient,
    private val gsonConverterFactory: GsonConverterFactory
) {
    fun create(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    companion object {
        private const val BASE_URL: String = "https://faas.eligaspace.com/store/order-app/"
    }
}
