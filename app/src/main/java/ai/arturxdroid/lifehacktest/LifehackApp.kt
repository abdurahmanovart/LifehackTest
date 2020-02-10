package ai.arturxdroid.lifehacktest

import ai.arturxdroid.lifehacktest.network.ApiFactory
import ai.arturxdroid.lifehacktest.network.LifehackRepository
import ai.arturxdroid.lifehacktest.ui.CompanyViewModel
import ai.arturxdroid.lifehacktest.ui.MainViewModel
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class LifehackApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val appModule: Module = module {
            viewModel { MainViewModel(get()) }
            viewModel { CompanyViewModel(get()) }
            single { LifehackRepository(ApiFactory.lifehackApi) }
        }
        startKoin {
            androidContext(this@LifehackApp)
            modules(listOf(appModule))
        }

    }
}
