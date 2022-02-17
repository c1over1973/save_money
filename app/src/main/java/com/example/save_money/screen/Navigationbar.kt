package com.example.save_money.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.save_money.navigation.Screen

@Composable
fun Navigationbar(navController: NavHostController) {
    TopAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(),
                onClick = { navController.navigate(Screen.Home.route) }
            ) {
                Box() {
                    Text(text = "home")
                }
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
                onClick = { navController.navigate(Screen.Detail.route) }
            ) {
                Box() {
                    Text(text = "detail")
                }
            }
        }
    }
}

//@Composable
//@Preview
//fun NavigationbarPreview() {
//    Navigationbar()
//}