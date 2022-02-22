package com.example.save_money.screen.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.save_money.ui.theme.black

@Composable
fun UpdateDialog(
    open: MutableState<Boolean>,
    text: MutableState<String>,
    amount: MutableState<Int>,
    updatefun: () -> Unit,
    deletefun: () -> Unit
) {

    if (open.value) {
        Dialog(onDismissRequest = { open.value = false }) {
            Card(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                        .padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(
                        text = "Update",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    OutlinedTextField(
                        value = amount.value.toString(),
                        onValueChange = {
                            amount.value = if (it.isNotEmpty()) {
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


                    OutlinedTextField(
                        value = text.value,
                        onValueChange = {
                            text.value = if (it.isNotEmpty()) {
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
                        ),
                        maxLines = 10
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = updatefun,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = black
                            )
                        ) {
                                Box() {
                                    Text(
                                        text = "Update!",
                                        color = Color.White
                                    )
                                }
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Button(
                            onClick = deletefun,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = black
                            )
                        ) {
                            Box() {
                                Text(
                                    text = "Delete!",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}