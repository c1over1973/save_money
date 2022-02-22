package com.example.save_money.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.save_money.navigation.Screen
import com.example.save_money.ui.theme.black

@Composable
fun Navigationbar(navController: NavHostController) {
    TopAppBar(backgroundColor = black) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = black
                ),
                onClick = { navController.navigate(Screen.Home.route) }
            ) {
                Box() {
                    Text(
                        text = "home",
                        color = Color.White
                    )
                }
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = black
                ),
                onClick = { navController.navigate(Screen.Detail.route) }
            ) {
                Box() {
                    Text(
                        text = "detail",
                        color = Color.White
                    )
                }
            }
        }
    }
}
