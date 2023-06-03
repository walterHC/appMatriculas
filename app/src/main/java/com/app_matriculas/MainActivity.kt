package com.app_matriculas

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.app_matriculas.entities.BookEntity
import com.app_matriculas.entities.StudentEntity
import com.app_matriculas.entities.UnitEntity
import com.app_matriculas.entities.UnitStudentCrossRef
import com.app_matriculas.model.AppDatabase
import com.app_matriculas.model.Repository
import com.app_matriculas.navigation.NavGraph
import com.app_matriculas.ui.theme.AppMatriculasTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMatriculasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    val repository = Repository(AppDatabase.getInstance(context.applicationContext))

                    NavGraph(repository)
                }
            }
        }
    }
}