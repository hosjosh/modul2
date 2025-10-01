package com.example.praktikumppb

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.praktikumppb.model.Anime

@Composable
fun AnimeDetailScreen(anime: Anime) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(anime.images.jpg.image_url),
            contentDescription = anime.title,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(anime.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Type: ${anime.type ?: "-"}")
        Text("Episodes: ${anime.episodes ?: "N/A"}")
        Text("Score: ${anime.score ?: "N/A"}")
    }
}