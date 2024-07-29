package com.example.apiconnection.model

import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int,
    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : Int
    )
