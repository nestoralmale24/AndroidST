package com.nst.pruebas

import com.google.gson.annotations.SerializedName

class PokemonResponse (
    @SerializedName("results") var results: ArrayList<Pokemon>
)