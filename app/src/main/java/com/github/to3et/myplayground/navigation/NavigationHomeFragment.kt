package com.github.to3et.myplayground.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.github.to3et.myplayground.navigation.compose.NavigationScreen
import com.github.to3et.myplayground.ui.theme.MyPlaygroundTheme

class NavigationHomeFragment : Fragment() {

    private val args: NavigationHomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                MyPlaygroundTheme {
                    NavigationScreen(
                        modifier = Modifier.fillMaxSize(),
                        screenName = "Home",
                        argName = args.arg,
                        onNextClick = {
                            val action = NavigationHomeFragmentDirections.actionToFirstFragment("from Home")
                            findNavController().navigate(action)
                        },
                        onBackClick = {
                            findNavController().popBackStack()
                        },
                        onHomeClick = null
                    )
                }
            }
        }
    }
}