package com.example.movieappmad24

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

class Card {

    //Code from lecture
    @Composable
    private fun MovieRow(movie: Movie) {
        var isExpended by remember { mutableStateOf(false) }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = ShapeDefaults.Large,
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        contentScale = ContentScale.Crop,
                        model = movie.images[0],
                        contentDescription = "Movie Image"
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp),
                        contentAlignment = Alignment.TopEnd
                    )
                    {
                        Icon(
                            tint = MaterialTheme.colorScheme.secondary,
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Add Favorites"
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = movie.title)
                    Button (
                        onClick = { isExpended = !isExpended },
                        colors = ButtonDefaults.buttonColors (
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        )
                    )
                    {
                        Icon (
                            modifier = Modifier,
                            imageVector = if (isExpended) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = "Arrow Up"
                        )
                    }
                }
                AnimatedVisibility(visible = isExpended) {
                    Column {
                        if (isExpended) {
                            Text(text = "Director: " + movie.director)
                            Text(text = "Released: " + movie.year)
                            Text(text = "Genre: " + movie.genre)
                            Text(text = "Actors: " + movie.actors)
                            Text(text = "Rating: " + movie.rating)
                            Divider()
                            Text(text = "Plot: " + movie.plot)
                        }
                    }
                }

            }
        }
    }

    @Composable
    fun MovieList(movieList: List<Movie> = getMovies()) {
        LazyColumn {
            items(movieList) { movie ->
                MovieRow(movie)
            }
        }
    }
}