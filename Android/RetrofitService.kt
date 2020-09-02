package com.example.myapplication.Android

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService{
    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    // 해당 주소의 get 요청을 하는데, 그 response가 ArrayList<PersonFromServer> 이 타입이다.

    @POST("json/students/")
    fun createStudnet(
        @Body params: HashMap<String, Any>
    ):Call<PersonFromServer>

    @POST("json/students/")
    fun createStudentEasy(
        @Body person: PersonFromServer
    ): Call<PersonFromServer>
}