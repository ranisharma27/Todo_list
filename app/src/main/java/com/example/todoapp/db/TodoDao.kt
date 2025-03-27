package com.example.todoapp.db
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM TODO")
    fun getallTodo():LiveData<List<Todo>>

    @Insert
    fun addTodo(todo:Todo)

    @Query("DELETE FROM TODO WHERE id= :id")
    fun deleteTodo(id:Int)
}