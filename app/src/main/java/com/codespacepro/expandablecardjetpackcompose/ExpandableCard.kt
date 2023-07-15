package com.codespacepro.expandablecardjetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title: String = "My Title",
    titleFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String="Lorem ipsum dolor sit amet, " +
            "consectetur adipiscing elit, sed do" +
            " eiusmod tempor incididunt ut labore et" +
            " dolore magna aliqua. Ut enim ad minim veniam," +
            " quis nostrud exercitation ullamco laboris nisi " +
            "ut aliquip ex ea commodo consequat. Duis aute irure",
    descriptionFontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    shape: CornerBasedShape = MaterialTheme.shapes.large,
    padding: Dp = 12.dp
) {

    var expendedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if (expendedState) 180f else 0f)


    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(padding)
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300, easing = LinearOutSlowInEasing
            )
        ), shape = MaterialTheme.shapes.large,
        onClick = {
            expendedState = !expendedState
        }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .weight(6f)
                    .padding(padding),
                text = title,
                fontSize = titleFontSize,
                fontWeight = titleFontWeight,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            IconButton(
                onClick = {
                    expendedState = !expendedState
                }, modifier = Modifier
                    .weight(1f)
                    .alpha(alpha = Float.POSITIVE_INFINITY)
                    .rotate(rotationState)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown, contentDescription = "DropDownArrow"
                )
            }
        }
        if (expendedState) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = description,
                fontSize = descriptionFontSize,
                fontWeight = descriptionFontWeight,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }

    }

}

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard()
}