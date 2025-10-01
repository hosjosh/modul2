package com.example.praktikumppb

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.praktikumppb.viewmodel.CharacterViewModel

@Composable
fun CharacterListScreen(viewModel: CharacterViewModel = viewModel()) {
    val characterList by viewModel.characterList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(characterList) { character ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(character.images.jpg.image_url),
                        contentDescription = character.name,
                        modifier = Modifier.size(80.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(character.name)
                        Text(character.about ?: "No description available.")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListScreenPreview() {
    CharacterListScreen()
}