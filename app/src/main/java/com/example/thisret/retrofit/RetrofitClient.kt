package com.example.thisret


import com.example.thisret.newModel.Book
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://candidate.scid.ru/api/" //books?page=1
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface RetrofitClient {
    @GET("books?page=1")
    fun getData():Call<Book>
}
object APIService{
    val retrofitService: RetrofitClient by lazy{retrofit.create(RetrofitClient::class.java)}

}