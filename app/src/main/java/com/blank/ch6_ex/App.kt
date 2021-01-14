package com.blank.ch6_ex

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.blank.ch6_ex.data.db.AppDb

class App : Application() {
    companion object {
        var context: Context? = null
        var appDb: AppDb? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        appDb = Room
            .databaseBuilder(
                applicationContext,
                AppDb::class.java,
                "MyDb"
            ).build()
    }
}