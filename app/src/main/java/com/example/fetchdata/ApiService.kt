package com.example.fetchdata // Ensure this matches your package structure

import com.example.fetchdata.Item  // Ensure this is the correct import for the Item data class
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")  // Replace with your actual API endpoint
    suspend fun getItems(): List<Item>  // This will fetch the list of `Item` objects from the API
}
