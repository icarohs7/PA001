package io.icarotemponi.pa001

import android.app.Application
import com.airbnb.mvrx.Mavericks

class AppModule : Application() {
    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}