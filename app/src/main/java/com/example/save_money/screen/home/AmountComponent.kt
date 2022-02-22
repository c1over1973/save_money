package com.example.save_money.screen.home

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
//        modifier = Modifier
//            .width(300.dp)
//            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "目前金額", textAlign = TextAlign.Center)
            Text(
                text = "$" + df.format(currentValue),
                textAlign = TextAlign.Center,
            )
        }

//        Spacer(modifier = Modifier.fillMaxWidth(0.5f))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "目標金額", textAlign = TextAlign.Center)
            Text(
                text = "$" + df.format(targetValue),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AmountComponentPreivew() {
    AmountComponent()
}