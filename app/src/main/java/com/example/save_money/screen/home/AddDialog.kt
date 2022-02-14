package com.example.save_money.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun AddDialog(
    open: MutableState<Boolean>,
    addfun: () -> Unit,
    text: MutableState<String>,
    amount: MutableState<Int>
) {
//    var openDialog by remember { mutableStateOf(open) }
//
//    var text by remember {
//        mutableStateOf(text)
//    }
//
//    var amount by remember {
//        mutableStateOf(amount)
//    }

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
                        text = "新增收入",
                        color = Color.Black,
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
                        )
                    )

                    Button(
                        modifier = Modifier.padding(top = 40.dp),
                        onClick = addfun
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "加入")
                        }
                    }
                }
            }
        }

    }
}

//@Composable
//@Preview
//fun AddDialogPreview() {
//    val context = LocalContext.current
//    val text = "已加入"
//    AddDialog()
//}