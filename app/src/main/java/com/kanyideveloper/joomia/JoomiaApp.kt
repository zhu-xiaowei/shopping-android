package com.kanyideveloper.joomia

import android.app.Application
import com.amplifyframework.AmplifyException
import dagger.hilt.android.HiltAndroidApp
import software.aws.solution.clickstream.ClickstreamAnalytics
import timber.log.Timber

@HiltAndroidApp
class JoomiaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        try {
            ClickstreamAnalytics.init(applicationContext)
            ClickstreamAnalytics.getClickStreamConfiguration()
                .withLogEvents(true)
            Timber.i("MyApp", "Initialized ClickstreamAnalytics")
        } catch (error: AmplifyException) {
            Timber.e("MyApp", "Could not initialize ClickstreamAnalytics", error)
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}