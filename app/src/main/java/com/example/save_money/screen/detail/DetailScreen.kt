package com.example.save_money.screen.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.save_money.screen.Navigationbar


@ExperimentalFoundationApi
@Composable
fun DetailScreen(
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
//    val coroutinescope = rememberCoroutineScope()
//    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
//        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
//    )
    val getAllDetail = detailViewModel.readAllDetail.observeAsState(listOf()).value
    val getAllGoal = detailViewModel.readAllGoals.observeAsState(listOf()).value

    var openDialog = remember {mutableStateOf(false) }

    var text = remember { mutableStateOf("") }

    var amount = remember { mutableStateOf(0) }

    var currentid by remember { mutableStateOf(0) }
    var temp by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            Navigationbar(navController = navController)
        },
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                stickyHeader {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(0.35f),
                            text = "amount:"
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(0.65f),
                            text = "detail:"
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "date:"
                        )
                    }
                }
                items(items = getAllDetail) { detail ->
                    ListContent(
                        detail = detail,
                        clickitem = {
                            openDialog.value = true
                            text.value = detail.content
                            amount.value = detail.amount
                            temp = detail.amount
                            currentid = detail.id
                        }
                    )
                }
            }
            UpdateDialog(
                open = openDialog,
                text = text,
                amount = amount,
                updatefun = {
                    detailViewModel.UpdateDetail(currentid, amount.value, text.value)
                    detailViewModel.UpdateSum(getAllGoal[0].goal, getAllGoal[0].sum - temp + amount.value)
                    openDialog.value = false
                },
                deletefun = {
                    detailViewModel.UpdateSum(getAllGoal[0].goal, getAllGoal[0].sum - temp)
                    detailViewModel.DeleteDetail(currentid)
                    openDialog.value = false
                }
            )
        }
    )

//    BottomSheetScaffold(
//        topBar = {Navigationbar(navController = navController)},
//        sheetContent = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .background(Color.White)
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(text = "bottom sheet!")
//                }
//            }
//        },
//        sheetPeekHeight = 0.dp
//    ) {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(all = 12.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            stickyHeader {
//                Row(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text(
//                        modifier = Modifier.fillMaxWidth(0.35f),
//                        text = "amount:")
//                    Text(
//                        modifier = Modifier.fillMaxWidth(0.65f),
//                        text = "detail:")
//                    Text(
//                        modifier = Modifier.fillMaxWidth(),
//                        text = "date:")
//                }
//            }
//            items(items = getAllDetail) { detail ->
//                ListContent(
//                    detail = detail,
//                    clickitem = {
//                        coroutinescope.launch {
//                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
//                                bottomSheetScaffoldState.bottomSheetState.expand()
//                            }else{
//                                bottomSheetScaffoldState.bottomSheetState.collapse()
//                            }
//                        }
//                    }
//                )
//            }
//        }
//    }
}

