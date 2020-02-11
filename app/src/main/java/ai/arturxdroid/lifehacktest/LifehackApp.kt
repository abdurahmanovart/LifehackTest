package ai.arturxdroid.lifehacktest

import ai.arturxdroid.lifehacktest.di.AppComponent
import ai.arturxdroid.lifehacktest.di.DaggerAppComponent
import ai.arturxdroid.lifehacktest.di.NetworkModule
import android.app.Application

class LifehackApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }
}
