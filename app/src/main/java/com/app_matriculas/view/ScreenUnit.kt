package com.app_matriculas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app_matriculas.entities.StudentEntity
import com.app_matriculas.entities.UnitWithStudents
import com.app_matriculas.model.Repository
import kotlinx.coroutines.launch

@Composable
fun ScreenUnit(
    repository: Repository,
    onNavigateStudent: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val unitStudentsList = remember { mutableStateListOf<UnitWithStudents>() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val unitWithStudentsOnClick: () -> Unit = {
            scope.launch {
                repository.getUnitWithStudents() .forEach {
                    unitStudentsList.add(it)
                }
            }
        }
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = unitWithStudentsOnClick) {
                Text(text = "Show Unit With Student")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(unitStudentsList) { unitStudent ->
                    TablaComposable(titulo = unitStudent.unitEntity.name, elementos = unitStudent.studentEntities)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}


@Composable
fun TablaComposable(titulo: String, elementos: List<StudentEntity>) {
    Column {
        Text(text = titulo, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))
        if (elementos.isNotEmpty()) {
            // Encabezado de la tabla
            Row(modifier = Modifier.background(Color.LightGray)) {
                Text(modifier = Modifier.weight(1f), text = "Elemento", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
            // Filas de la tabla
            elementos.forEach { elemento ->
                Row(modifier = Modifier.background(Color.White)) {
                    Text(modifier = Modifier.weight(1f), text = elemento.fullname, textAlign = TextAlign.Center)
                }
            }
        } else {
            // Mensaje de lista vacía
            Text(text = "No hay elementos para mostrar")
        }
    }
}