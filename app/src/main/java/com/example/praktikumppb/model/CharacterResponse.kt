package com.example.praktikumppb.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    val data: List<Character>
)

data class Character(
    @SerializedName("mal_id")
    val malId: Int, // Properti ini sekarang menggunakan camelCase
    val name: String,
    val about: String?,
    val images: Images
)