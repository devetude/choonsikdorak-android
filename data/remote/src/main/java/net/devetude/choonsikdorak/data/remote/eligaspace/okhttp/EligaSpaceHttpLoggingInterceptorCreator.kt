package net.devetude.choonsikdorak.data.remote.eligaspace.okhttp

import net.devetude.choonsikdorak.data.remote.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level

internal class EligaSpaceHttpLoggingInterceptorCreator {
    fun create(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(LEVEL)

    companion object {
        private val LEVEL: Level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
    }
}
