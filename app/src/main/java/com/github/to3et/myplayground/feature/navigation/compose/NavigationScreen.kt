package com.github.to3et.myplayground.feature.navigation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.to3et.myplayground.ui.theme.MyPlaygroundTheme

@Composable
fun NavigationScreen(
    modifier: Modifier = Modifier,
    screenName: String = "",
    from: String = "",
    onNextClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
    onHomeClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Screen Name : $screenName")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Argument : $from")

        onNextClick?.let {
            Button(
                onClick = it
            ) {
                Text("Next")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        onBackClick?.let {
            Button(
                onClick = it
            ) {
                Text("Back")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        onHomeClick?.let {
            Button(
                onClick = it
            ) {
                Text("Home")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationScreenPreview() {
    MyPlaygroundTheme {
        NavigationScreen()
    }
}