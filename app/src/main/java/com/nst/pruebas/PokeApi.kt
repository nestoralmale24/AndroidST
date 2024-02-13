package com.nst.pruebas

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface PokeAPI {
    @Headers("Accept: application/json")

    @GET("pokemon")
    fun getPokemons(): Call<PokemonResponse>

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>
}
