package com.wanderring.Do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wanderring.Do.ui.App
import com.wanderring.Do.ui.rememberAppState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val appState = rememberAppState()

            App(appState = appState)
        }
    }
}