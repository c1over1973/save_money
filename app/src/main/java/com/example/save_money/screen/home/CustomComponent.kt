package com.example.save_money.screen.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CustomComponent(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
    foregroundIndicatorColor: Color = MaterialTheme.colors.primary,
    bigTextFontSize: TextUnit = MaterialTheme.typography.h3.fontSize,
    bigTextColor: Color = MaterialTheme.colors.onSurface,
    smallText: String = "達成度",
    smallTextFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    smallTextColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.3f),
    completefun: () -> Unit
) {
    var allowedIndicatorValue by remember { mutableStateOf(maxIndicatorValue) }

    allowedIndicatorValue = if (indicatorValue <= maxIndicatorValue) {
        indicatorValue
    } else {
        maxIndicatorValue
    }

    var animatedIndicatorValue by remember { mutableStateOf(0f) }
    LaunchedEffect(key1 = allowedIndicatorValue) {
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }

    val percentage = (animatedIndicatorValue / maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    val receivedValue by animateIntAsState(
        targetValue = percentage.toInt(),
        animationSpec = tween(1000)
    )


    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor
//                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
                foregroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor
//                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (percentage.toInt()) {
            100 -> {
                Text(
                    text = "點擊完成!",
                    color = smallTextColor
                )
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = completefun) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = null,
                            tint = Color.Green,
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp)
                        )
                    }
                }
            }
            else -> EmbeddedElements(
                bigText = receivedValue,
                bigTextFontSize = bigTextFontSize,
                bigTextColor = bigTextColor,
                bigTextSuffix = "%",
                smallText = smallText,
                smallTextColor = smallTextColor,
                smallTextFontSize = smallTextFontSize
            )
        }

    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
//    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = 10f,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
//    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = 10f,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

@Composable
fun EmbeddedElements(
    bigText: Int,
    bigTextFontSize: TextUnit,
    bigTextColor: Color,
    bigTextSuffix: String,
    smallText: String,
    smallTextColor: Color,
    smallTextFontSize: TextUnit
) {
    Text(
        text = smallText,
        color = smallTextColor,
        fontSize = smallTextFontSize,
        textAlign = TextAlign.Center
    )
    Text(
        text = "$bigText ${bigTextSuffix.take(2)}",
        color = bigTextColor,
        fontSize = bigTextFontSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}


@Composable
@Preview(showBackground = true)
fun CoustomComponentPreview() {
    CustomComponent(indicatorValue = 0, maxIndicatorValue = 100, completefun = {})
}