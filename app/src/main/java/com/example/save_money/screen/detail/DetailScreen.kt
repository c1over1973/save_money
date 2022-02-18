package com.example.save_money.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.save_money.screen.Navigationbar
import java.text.SimpleDateFormat

@Composable
fun DetailScreen(
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    val getAllDetail = detailViewModel.readAllDetail.observeAsState(listOf()).value
//    val sdf = SimpleDateFormat("M/dd")

    Scaffold(
        topBar = {
            Navigationbar(navController = navController)
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(all = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
//                stickyHeader(key = {date -> sdf.format(date)})
                items(items = getAllDetail) { detail ->
                    ListContent(detail = detail)
                }
            }
        }
    )
}