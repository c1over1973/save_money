package com.example.save_money.navigation


sealed class Screen(val route: String){

    object Home: Screen("home_screen")
    object Add: Screen("add_screen")
    object Detail: Screen("detail_screen")
}