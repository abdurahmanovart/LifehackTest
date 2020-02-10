package ai.arturxdroid.lifehacktest.network

import ai.arturxdroid.lifehacktest.data.CompanyFullInfo
import ai.arturxdroid.lifehacktest.data.CompanyShortInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LifehackAPI {

    @GET("test.php")
    suspend fun getCompanies(): Response<List<CompanyShortInfo>>

    @GET("test.php")
    suspend fun getCompany(@Query("id") id: String): Response<List<CompanyFullInfo>>
}