package ai.arturxdroid.lifehacktest.network

import ai.arturxdroid.lifehacktest.data.CompaniesResponse
import ai.arturxdroid.lifehacktest.data.CompanyFullInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LifehackAPI {

    @GET("test.php")
    fun getCompanies(): Response<CompaniesResponse>

    @GET("test.php")
    fun getCompany(@Query("id") id: String): Response<CompanyFullInfo>
}