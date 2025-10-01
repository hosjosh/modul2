package com.example.praktikumppb.network

import com.example.praktikumppb.model.CharacterResponse
import com.example.praktikumppb.model.AnimeListResponse
import retrofit2.http.GET

interface ApiService {
    // Anime by id
    @GET("top/anime")
    suspend fun getTopAnime(): AnimeListResponse

    // Characters endpoint
    @GET("characters")
    suspend fun getCharacters(): CharacterResponse
}