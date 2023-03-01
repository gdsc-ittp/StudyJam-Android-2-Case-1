package com.ahr.studyjam2case1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.ahr.studyjam2case1.ui.screen.ProfileScreen
import com.ahr.studyjam2case1.ui.theme.StudyJam2Case1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyJam2Case1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen(
                        profile = R.drawable.profile,
                        name = "Alex Marshall",
                        username = "@alex_marshall",
                    )
                }
            }
        }
    }
}