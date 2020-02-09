package ai.arturxdroid.lifehacktest.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    public const val BASE_URL = "http://megakohz.bget.ru/test_task/"

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)

    }

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val nutritionApi = retrofit().create(LifehackAPI::class.java)
}