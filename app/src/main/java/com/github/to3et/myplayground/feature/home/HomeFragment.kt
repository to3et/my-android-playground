package com.github.to3et.myplayground.feature.home

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.findNavController
import com.github.to3et.myplayground.ui.theme.MyPlaygroundTheme

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MyPlaygroundTheme {
                    MenuScreen(
                        modifier = Modifier.fillMaxSize(),
                        onNavigationClick = {
                            val uri = Uri.parse("playground:///navigation?from=from Home")
                            findNavController().navigate(uri)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Home")
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Button(
                onClick = onNavigationClick
            ) {
                Text("Navigation")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onNavigationClick
            ) {
                Text("Deep link Navigation")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MyPlaygroundTheme {
        MenuScreen(
            modifier = Modifier.fillMaxSize(),
            onNavigationClick = { }
        )
    }
}
