package com.example.clubhouseclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clubhouseclone.screens.HomeScreen
import com.example.clubhouseclone.screens.RoomDetailsScreen
import com.example.clubhouseclone.ui.theme.ClubhouseCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClubhouseCloneTheme {
                // A surface container using the 'background' color from the theme
                ClubhouseClone()
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun ClubhouseClone() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "/") {
            composable("/") {
                HomeScreen {
                    navController.navigate("/roomDetails")
                }
            }

            composable("/roomDetails") {
                RoomDetailsScreen(navigateUp = { navController.popBackStack() })
            }
        }
    }
}