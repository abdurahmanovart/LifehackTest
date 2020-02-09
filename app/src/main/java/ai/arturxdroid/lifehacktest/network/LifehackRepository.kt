package ai.arturxdroid.lifehacktest.network

import ai.arturxdroid.lifehacktest.data.CompaniesResponse
import ai.arturxdroid.lifehacktest.data.CompanyFullInfo

class LifehackRepository(private val api: LifehackAPI) : BaseRepository() {

    suspend fun getCompanies(): CompaniesResponse? {
        return safeApiCall(
            call = { api.getCompanies() },
            errorMessage = "Error fetching companies list"
        )
    }

    suspend fun getCompanyInfo(id: String): CompanyFullInfo? {
        return safeApiCall(
            call = { api.getCompany(id) },
            errorMessage = "Error fetching company info"
        )
    }
}