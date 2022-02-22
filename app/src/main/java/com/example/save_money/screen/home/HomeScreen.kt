package com.example.save_money.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.save_money.model.Detail
import com.example.save_money.navigation.Screen
import com.example.save_money.screen.Navigationbar
import com.example.save_money.ui.theme.black
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val getgoals = homeViewModel.readAllGoals.observeAsState(listOf()).value
    val context = LocalContext.current
    val sdf = SimpleDateFormat("M/dd HH:mm")
    var currentDate = ""


    var openDialog = remember {
        mutableStateOf(false)
    }

    var text = remember {
        mutableStateOf("")
    }

    var amount = remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
        Navigationbar(navController = navController)
    },
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.padding(top = 50.dp, bottom = 50.dp),
                        text =
                        if (getgoals.isEmpty()) {
                            "新目標"
                        } else {
                            getgoals[0].goal
                        },
                        fontSize = MaterialTheme.typography.h2.fontSize,
                        textAlign = TextAlign.Center
                    )

                    CustomComponent(
                        indicatorValue =
                        if (getgoals.isEmpty()) {
                            0
                        } else {
                            getgoals[0].sum
                        },
                        maxIndicatorValue =
                        if (getgoals.isEmpty()) {
                            0
                        } else {
                            getgoals[0].amount
                        },
                        completefun = {
                            homeViewModel.deleteAllGoals()
                            homeViewModel.deleteAllDetails()
                            navController.navigate(Screen.Add.route)
                        }
                    )

                    AmountComponent(
                        current =
                        if (getgoals.isEmpty()) {
                            0
                        } else {
                            getgoals[0].sum
                        },
                        target =
                        if (getgoals.isEmpty()) {
                            0
                        } else {
                            getgoals[0].amount
                        }
                    )
                    Button(
                        modifier = Modifier.padding(top = 40.dp),
                        onClick = {
                            openDialog.value = true
                            currentDate = sdf.format(Date())
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = black
                        )
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "add new!",
                                color = Color.White
                            )
                        }
                    }


                    AddDialog(
                        open = openDialog,
                        addfun = {
                            if(amountCheck(amount.value)){
                                val detail = Detail(0, amount.value, text.value, currentDate)
                                homeViewModel.addDetail(detail)
                                homeViewModel.updateSum(getgoals[0].goal, getgoals[0].sum + amount.value)
                                Toast.makeText(context, "已新增明細!", Toast.LENGTH_SHORT).show()
                            }else{
                                Toast.makeText(context, "金額請勿為0!", Toast.LENGTH_SHORT).show()
                            }
                            text.value = ""
                            amount.value = 0
                            openDialog.value = false
                        },
                        text = text,
                        amount = amount
                    )
                }

            }
        }
    )



}

fun amountCheck(amount: Int): Boolean {
    return amount != 0
}

