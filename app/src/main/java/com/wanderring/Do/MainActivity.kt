package com.wanderring.Do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wanderring.Do.app.App
import com.wanderring.Do.app.rememberAppState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val appState = rememberAppState()

            App(appState = appState)
        }
    }
}