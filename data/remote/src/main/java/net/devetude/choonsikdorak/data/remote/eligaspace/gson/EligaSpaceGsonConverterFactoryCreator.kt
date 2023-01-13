package net.devetude.choonsikdorak.data.remote.eligaspace.gson

import retrofit2.converter.gson.GsonConverterFactory

internal class EligaSpaceGsonConverterFactoryCreator {
    fun create(): GsonConverterFactory = GsonConverterFactory.create()
}
