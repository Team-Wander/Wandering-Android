package com.wanderring.Do

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wanderring.Do.app.App
import com.wanderring.Do.app.rememberAppState
import com.wanderring.domain.repository.UserDataRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var userDataRepository: UserDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val appState = rememberAppState(userDataRepository = userDataRepository)

            App(appState = appState)
        }
    }
}