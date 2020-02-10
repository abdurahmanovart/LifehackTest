package ai.arturxdroid.lifehacktest.ui

import ai.arturxdroid.lifehacktest.data.CompanyFullInfo
import ai.arturxdroid.lifehacktest.network.LifehackRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CompanyViewModel(private val lifehackRepository: LifehackRepository) : ViewModel() {

    private val _company = MutableLiveData<CompanyFullInfo>()
    val company: LiveData<CompanyFullInfo> = _company

    private val _error = MutableLiveData<Boolean>(false)
    val error: LiveData<Boolean> = _error

    fun fetchCompany(id: String) {

        viewModelScope.launch {
            try {
                _company.value = lifehackRepository.getCompanyInfo(id)!![0]
            } catch (e: Exception) {
                _error.value = true
            }
        }
    }
}