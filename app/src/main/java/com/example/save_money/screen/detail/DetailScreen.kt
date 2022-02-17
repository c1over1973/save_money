package com.example.save_money.screen.detail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.save_money.screen.Navigationbar

@Composable
fun DetailScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            Navigationbar(navController = navController)
        },
        content = {

        }
    )
}