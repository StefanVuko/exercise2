package com.example.movieappmad24

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MovieUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun TopBar() {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("Stefan's Fantastic Movie App")
            }
        )
    }

    @Composable
    fun BottomBar() {
        BottomAppBar {
            NavigationBarItem(
                label = { Text(text = "Home") },
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home Button"
                    )
                })
            NavigationBarItem(
                label = { Text(text = "Watchlist") },
                selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorites"
                    )
                })
        }
    }
}