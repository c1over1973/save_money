package com.example.save_money.screen.detail

import android.provider.CalendarContract
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.save_money.data.Detail
import com.example.save_money.navigation.Screen
import com.example.save_money.ui.theme.Typography
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ListContent(detail: Detail) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "$${detail.amount}",
            fontSize = Typography.h4.fontSize
        )
        Text(
            text = detail.content,
            fontSize = Typography.h4.fontSize
        )
        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            text = detail.date,
//            color = colors.surface.copy(alpha = 0.3f),
            fontSize = Typography.h6.fontSize
        )
    }
}

@Composable
@Preview
fun ListContentPreview() {
    val sdf = SimpleDateFormat("M/dd  hh:mm")
    val currentDate = sdf.format(Date())
    ListContent(
        detail = Detail(
            id = 0,
            amount = 500,
            content = "紅包",
            date = currentDate
        )
    )
}