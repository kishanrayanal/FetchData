package com.example.fetchdata  // This should match your package

import com.example.fetchdata.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"  // Replace with your actual base URL

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Your API base URL
            .addConverterFactory(GsonConverterFactory.create())  // Gson converter to parse JSON
            .build()
            .create(ApiService::class.java)  // Create the ApiService instance
    }
}
