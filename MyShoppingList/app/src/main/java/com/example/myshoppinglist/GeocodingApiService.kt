package com.example.myshoppinglist

import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {

    // API endpoint for geocode services
    @GET("maps/api/geocode/json")
    // suspending function. looks like Promise
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latlng: String,
        @Query("key") apiKey: String
    ): GeocodingResponse
}