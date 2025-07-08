package com.example.todoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TodoListPage(viewModel: TodoViewModel){



    val todolist by viewModel.todoList.observeAsState()
    var inputText by remember { mutableStateOf("") }

    Image(painter= painterResource(id= R.drawable.login_blur),
        contentDescription="background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)

    Column (modifier = Modifier.fillMaxHeight().padding(8.dp)){
        Spacer(modifier = Modifier.height(40.dp))
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            OutlinedTextField(value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp)).weight(1f), // Border color, width, and shape
                placeholder = { Text("Enter task...") },
                shape = RoundedCornerShape(16.dp) )
            IconButton(onClick = {
                viewModel.addTodo(inputText)
                inputText=""
            },) {
                Icon(painterResource(id=R.drawable.baseline_add_circle_24), contentDescription = "add",tint= Color.White)

            }
        }
        todolist?.let{
            LazyColumn (
                content = {
                    itemsIndexed(it){index: Int, item: Todo ->
                        todoitem(item=item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                }
            )
        }?: Text(
            modifier= Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text="No items yet",
            color= Color.White,
            fontSize = 16.sp)

    }
}

@Composable
fun todoitem(item:Todo,onDelete:()-> Unit){
    val brush= Brush.linearGradient(
        listOf(
            Color(0xFF238CDD),
            Color(0XFF255DCC)
        )
    )
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp).clip(RoundedCornerShape(16.dp)).background(brush, CircleShape).padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text= SimpleDateFormat("HH:mm:aa, dd//mm", Locale.ENGLISH).format(item.Added),
                fontSize = 12f.sp,
                color = Color.White)
            Text(text= item.Title,
                fontSize = 20.sp,
                color= Color.White)
        }
        IconButton(onClick = onDelete) {
            Icon(painter= painterResource(id=R.drawable.baseline_delete_24),
                contentDescription = "delete",
                tint= Color.White)
        }
    }
}