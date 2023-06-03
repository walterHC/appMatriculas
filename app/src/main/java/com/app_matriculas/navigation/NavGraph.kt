package com.app_matriculas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app_matriculas.model.Repository
import com.app_matriculas.view.ScreenRoomSample
import com.app_matriculas.view.ScreenUnit

@Composable
fun NavGraph(
    repository: Repository
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.RoomSample.route) {
        composable(Screen.RoomSample.route) {
            ScreenRoomSample(repository = repository) {
                navController.navigate(Screen.Unit.route)
            }
        }
        composable(Screen.Unit.route) {
            ScreenUnit(repository = repository) {
                navController.popBackStack()
            }
        }
    }
}
