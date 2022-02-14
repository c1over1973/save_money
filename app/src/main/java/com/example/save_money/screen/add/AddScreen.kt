package com.example.save_money.screen.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.save_money.data.Goals
import com.example.save_money.navigation.Screen

@Composable
fun AddScreen(
    navController: NavHostController,
    addViewModel: AddViewModel = hiltViewModel()
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }

        var amount by remember {
            mutableStateOf(0)
        }

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = if (it.isNotEmpty()) {
                    it
                } else {
                    ""
                }
            },
            label = {
                Text(text = "目標:")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        OutlinedTextField(
            value = amount.toString(),
            onValueChange = {
                amount = if (it.isNotEmpty()) {
                    it.toInt()
                } else {
                   0
                }
            },
            label = {
                Text(text = "金額:")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        val goal = Goals(text, amount, 0)
        Button(onClick = {
            addViewModel.addGoals(goal)
            navController.navigate(Screen.Home.route)
        }){}

    }
}