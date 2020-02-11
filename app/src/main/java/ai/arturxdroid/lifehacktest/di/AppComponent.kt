package ai.arturxdroid.lifehacktest.di

import ai.arturxdroid.lifehacktest.ui.CompanyViewModel
import ai.arturxdroid.lifehacktest.ui.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])

@Singleton
interface AppComponent {

    fun inject(viewModel: CompanyViewModel)
    fun inject(viewModel: MainViewModel)

}