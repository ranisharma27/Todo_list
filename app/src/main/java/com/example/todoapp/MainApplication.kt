package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.db.TodoDatabase

class MainApplication:Application() {
    companion object{
        lateinit var tododatabse: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        tododatabse=Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            TodoDatabase.NAME
        ).build()
    }
}