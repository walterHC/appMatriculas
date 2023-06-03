package com.app_matriculas.navigation

sealed class Screen(val route: String) {
    object RoomSample : Screen("roomsample")
    object Unit : Screen("units")
}
