package com.example.save_money.screen.add

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.save_money.model.Goals
import com.example.save_money.navigation.Screen

@Composable
fun AddScreen(
    navController: NavHostController,
    addViewModel: AddViewModel = hiltViewModel()
) {

    val context = LocalContext.current

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

        Text(
            modifier = Modifier.padding(bottom = 12.dp),
            text = "新目標",
            fontSize = MaterialTheme.typography.h3.fontSize
        )

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

            if (amount != 0) {
                addViewModel.addGoals(goal)
                navController.navigate(Screen.Home.route)
            } else {
                Toast.makeText(context, "目標金額不能為0!", Toast.LENGTH_SHORT).show()
            }
        }
        ) {
            Box() {
                Text(text = "ADD!")
            }
        }

    }
}