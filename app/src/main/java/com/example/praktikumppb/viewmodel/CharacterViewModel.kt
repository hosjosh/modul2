package com.example.praktikumppb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikumppb.model.Character
import com.example.praktikumppb.model.CharacterResponse
import com.example.praktikumppb.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characterList = MutableStateFlow<List<Character>>(emptyList())
    val characterList: StateFlow<List<Character>> = _characterList

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response: CharacterResponse = ApiClient.service.getCharacters()
                _characterList.value = response.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}