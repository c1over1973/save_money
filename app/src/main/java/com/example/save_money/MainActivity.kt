package com.example.save_money

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.save_money.navigation.SetupNavGraph
import com.example.save_money.ui.theme.Save_moneyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Save_moneyTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

