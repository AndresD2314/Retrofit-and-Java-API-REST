package com.example.apiconnection.retrofit.services

import com.example.apiconnection.model.People
import retrofit2.Call
import retrofit2.http.*

interface PeopleService {

    @GET("/api/v1/people")
    fun getAllPeople(): Call<List<People>>

    @POST("/api/v1/people")
    fun createPeople(@Body people: People): Call<People>

    @GET("/api/v1/people/{id}")
    fun getPeopleById(@Path("id") id: Int): Call<People>

    @PUT("/api/v1/people/{id}")
    fun updatePeople(@Path("id") id: Int, @Body people: People): Call<People>

    @DELETE("/api/v1/people/{id}")
    fun deletePeople(@Path("id") id: Int): Call<Void>
}