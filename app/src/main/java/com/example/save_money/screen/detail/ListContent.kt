package com.example.save_money.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.save_money.model.Detail
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ListContent(
    detail: Detail,
    clickitem: () -> Unit
) {

    val df = DecimalFormat("#,###")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable (
                onClick = clickitem
                    ),
        shape = RoundedCornerShape(5.dp),
        backgroundColor = Color.Gray
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(0.35f),
                text = "$${df.format(detail.amount)}",
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier.fillMaxWidth(0.6f),
                text = detail.content,
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                text = detail.date,
                fontSize = 15.sp
            )
        }
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
        ),
        clickitem = {}
    )
}