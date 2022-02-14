package com.example.save_money.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.save_money.data.Detail
import com.example.save_money.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    val getgoals = homeViewModel.readAllGoals.observeAsState(listOf()).value
    val context = LocalContext.current

    var openDialog = remember {
        mutableStateOf(false)
    }

    var text = remember {
        mutableStateOf("")
    }

    var amount = remember {
        mutableStateOf(0)
    }

//    var sum = remember {
//        mutableStateOf(
//            if (getgoals.isEmpty()) {
//                0
//            } else {
//                getgoals[0].sum
//            }
//        )
//    }



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
                if (getgoals.isEmpty()){
                    0
                }else{
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
                    homeViewModel.deleteAllDetail()
                    navController.navigate(Screen.Add.route)
                }
            )

            AmountComponent(
                current =
                if (getgoals.isEmpty()){
                    0
                }else{
                    getgoals[0].sum
                },
//                sum.value,
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
                }
            ) {
                Box(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "add new!")
                }
            }


            AddDialog(
                open = openDialog,
                addfun = {
//                    sum.value = amount.value + sum.value
//                    val detail = Detail(amount.value, text.value, "")
//                    homeViewModel.addDetail(detail)

                    homeViewModel.updateSum(getgoals[0].goal, getgoals[0].sum + amount.value)
                    Toast.makeText(context,"已新增明細",Toast.LENGTH_SHORT).show()
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

