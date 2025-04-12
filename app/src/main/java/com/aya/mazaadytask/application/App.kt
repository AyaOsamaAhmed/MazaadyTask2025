package com.aya.mazaadytask.application

import android.app.Application
import androidx.room.Room
import com.aya.data.database.AppDatabase
import com.aya.data.utils.Constant.DATABASE_NAME
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

}