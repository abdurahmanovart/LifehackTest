package ai.arturxdroid.lifehacktest.ui

import ai.arturxdroid.lifehacktest.data.CompanyShortInfo
import ai.arturxdroid.lifehacktest.network.LifehackRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(val repository: LifehackRepository) : ViewModel() {

    private val _companies = MutableLiveData<List<CompanyShortInfo>>()

    val companies: LiveData<List<CompanyShortInfo>> = _companies

    fun fetchCompanies() {
        viewModelScope.launch {
            _companies.value = repository.getCompanies()
        }
    }
}