package ai.arturxdroid.lifehacktest.network

import ai.arturxdroid.lifehacktest.data.CompanyFullInfo
import ai.arturxdroid.lifehacktest.data.CompanyShortInfo

class LifehackRepository(private val api: LifehackAPI) : BaseRepository() {

    suspend fun getCompanies(): List<CompanyShortInfo>? {
        return safeApiCall(
            call = { api.getCompanies() },
            errorMessage = "Error fetching companies list"
        )
    }

    suspend fun getCompanyInfo(id: String): List<CompanyFullInfo>? {
        return safeApiCall(
            call = { api.getCompany(id) },
            errorMessage = "Error fetching company info"
        )
    }
}