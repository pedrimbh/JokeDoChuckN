package br.com.joaopmesquita.jokedochuckn.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {
    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apiKey:String = HTTPCLient.API_KEY): Call<List<String>>
}