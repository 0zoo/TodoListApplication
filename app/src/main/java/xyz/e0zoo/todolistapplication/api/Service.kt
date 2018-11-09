package xyz.e0zoo.todolistapplication.api

import retrofit2.Call
import retrofit2.http.*
import xyz.e0zoo.todolistapplication.api.model.Auth
import xyz.e0zoo.todolistapplication.api.model.SignInUserBody

interface Service {

    @POST("auth/login")
    fun getAccessToken(@Body user: SignInUserBody): Call<Auth>

}