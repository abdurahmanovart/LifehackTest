package ai.arturxdroid.lifehacktest.data

data class CompaniesResponse(val list: List<CompanyShortInfo>)

data class CompanyShortInfo(val id: String, val name: String, val img: String)

data class CompanyFullInfo(
    val id: String,
    val name: String,
    val img: String,
    val description: String,
    val lat: Double,
    val lon: Double,
    val www: String,
    val phone: String
)