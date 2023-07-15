package com.codespacepro.expandablecardjetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpCard() {

    var expendedState by remember { mutableStateOf(false) }
    val rotatingAnimation by animateFloatAsState(targetValue = if (expendedState) 180f else 0f)

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300, easing = LinearOutSlowInEasing
            )
        ), shape = MaterialTheme.shapes.large, onClick = { expendedState = !expendedState }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Register Now",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .weight(6f),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            IconButton(
                onClick = { expendedState = !expendedState },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .rotate(rotatingAnimation)
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop Down Arrow..."
                )
            }
        }
        if (expendedState) {
            Text(
                text = "Unlock Infinite Possibilities - Register Now!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                fontWeight = FontWeight.Normal,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
            var text by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Email") },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                    }
                }
            )
            var username by remember {
                mutableStateOf("")
            }
            OutlinedTextField(value = username, onValueChange = { newtext ->
                username = newtext
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
                label = { Text(text = "Username") },
                placeholder = { Text(text = "John Mark") },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Account"
                        )
                    }
                })

            var password by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = password, onValueChange = { newtext ->
                    password = newtext
                },
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                placeholder = { Text(text = "Password") },
                label = { Text(text = "Password") },
                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password"
                        )
                    }
                }
            )

            OutlinedIconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = ButtonDefaults.outlinedShape
            ) {
                Text(text = "SignUp")
            }
        }

    }

}

@Preview
@Composable
fun ExpCardPreview() {
    ExpCard()
}