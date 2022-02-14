package com.example.save_money.screen.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTextField() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember {
            mutableStateOf("")
        }

        var amount by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.isNotEmpty()) {
                    it
                } else {
                    ""
                }
            },
            label = {
                Text(text = "備註:")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        OutlinedTextField(
            value = amount.toString(),
            onValueChange = {
                if (it.isNotEmpty()) {
                    it.toInt()
                } else {
                    ""
                }
            },
            label = {
                Text(text = "金額:")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ))
    }
}

@Composable
@Preview
fun CustomTextFiewldPreview() {
    CustomTextField()
}