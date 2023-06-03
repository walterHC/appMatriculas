package com.app_matriculas.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app_matriculas.entities.BookEntity
import com.app_matriculas.entities.StudentEntity
import com.app_matriculas.entities.UnitEntity
import com.app_matriculas.entities.UnitStudentCrossRef
import com.app_matriculas.model.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ScreenRoomSample(
    repository: Repository,
    onNavigateUnit: () -> Unit,
    ) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val TAG: String = "RoomDatabase"
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val fillDataOnClick = {
                fillTables(repository, scope)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = fillDataOnClick) {
                Text(text = "Fill student & unit tables")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = onNavigateUnit) {
                Text(text = "Open Interface Unit")
            }

        }
    }
}

fun fillTables(rep: Repository, scope: CoroutineScope) {

    //LLENADO DE STUDENTS
    val students = ArrayList<StudentEntity>()

    for (i in 100..120) {
        val studentEntity = StudentEntity(i, fullname = "Student " + i.toString())
        students.add(studentEntity)
    }

    scope.launch {
        rep.insertStudents(students)
    }


    //LLENADO DE UNITS
    val units = ArrayList<UnitEntity>()

    for (i in 1..7) {
        val credit = Random.nextInt(2, 4)
        val unitEntity = UnitEntity(unitId = i, name = "Unit " + i.toString(), credit = credit)
        units.add(unitEntity)
    }

    scope.launch {
        rep.insertUnits(units)
    }

    //LLENADO DE UNITS WITH STUDENTS
    for (i in 0..40) {
        val studentId = Random.nextInt(100, 120)
        val unitId = Random.nextInt(1, 7)
        val unitStudent = UnitStudentCrossRef(unitId = unitId, studentId = studentId)
        scope.launch {
            rep.insertUnitStudents(unitStudent)
        }
    }
}