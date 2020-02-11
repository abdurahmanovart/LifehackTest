package ai.arturxdroid.lifehacktest.ui

import ai.arturxdroid.lifehacktest.LifehackApp
import ai.arturxdroid.lifehacktest.data.CompanyShortInfo
import ai.arturxdroid.lifehacktest.network.LifehackRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel : ViewModel() {

    private val _companies = MutableLiveData<List<CompanyShortInfo>>()

    val companies: LiveData<List<CompanyShortInfo>> = _companies

    @Inject
    lateinit var repository: LifehackRepository

    init {
        LifehackApp.appComponent.inject(viewModel = this)
    }

    fun fetchCompanies() {
        viewModelScope.launch {
            _companies.value = repository.getCompanies()
        }
    }
}