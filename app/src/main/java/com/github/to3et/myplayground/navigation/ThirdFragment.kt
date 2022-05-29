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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.to3et.myplayground.navigation.compose.NavigationScreen
import com.github.to3et.myplayground.ui.theme.MyPlaygroundTheme

class ThirdFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()

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
                        screenName = "Third",
                        argName = args.arg,
                        onNextClick = null,
                        onBackClick = {
                            findNavController().popBackStack()
                        },
                        onHomeClick = {
                            val action = ThirdFragmentDirections.actionGlobalToNavigationFragment("From Third")
                            findNavController().navigate(action)
                        }
                    )
                }
            }
        }
    }
}