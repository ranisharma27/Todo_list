package com.example.todoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp.Todo

@Database(entities = [Todo::class], version=1)
@TypeConverters(Converter::class)
abstract class TodoDatabase:RoomDatabase() {

    companion object{
        const val NAME= "todo_db"
    }

    abstract fun getTodoDao(): TodoDao
}