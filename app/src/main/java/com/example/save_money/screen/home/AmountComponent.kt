package com.example.save_money.screen.home

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat

@Composable
fun AmountComponent(
    current: Int = 100,
    target: Int = 1000
) {
    val df = DecimalFormat("#,###")

    var animatedtargetValue by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = target) {
        animatedtargetValue = target
    }

    var animatedcurrentValue by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = current) {
        animatedcurrentValue = current
    }

    val currentValue by animateIntAsState(
        targetValue = animatedcurrentValue,
        animationSpec = tween(1000)
    )

    val targetValue by animateIntAsState(
        targetValue = animatedtargetValue,
        animationSpec = tween(1000)
    )


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Column(Modifier.padding(end = 40.dp)) {
            Text(text = "目前金額")
            Text(
                text = "$" + df.format(currentValue),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(57.dp)
            )
        }

        Column(Modifier.padding(start = 40.dp)) {
            Text(text = "目標金額")
            Text(
                text = "$" + df.format(targetValue),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(57.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AmountComponentPreivew() {
    AmountComponent()
}