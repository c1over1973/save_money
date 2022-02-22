package com.example.save_money.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.save_money.screen.add.AddScreen
import com.example.save_money.screen.detail.DetailScreen
import com.example.save_money.screen.home.HomeScreen
import com.example.save_money.screen.home.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val getgoals = homeViewModel.readAllGoals.observeAsState(listOf()).value

    NavHost(
        navController = navController,
        startDestination =
        if (getgoals.isEmpty()){
            Screen.Add.route
        } else{
            Screen.Home.route
        }

    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        
        composable(route = Screen.Add.route){
            AddScreen(navController = navController)
        }

        composable(route = Screen.Detail.route){
            DetailScreen(navController = navController)
        }
    }
}