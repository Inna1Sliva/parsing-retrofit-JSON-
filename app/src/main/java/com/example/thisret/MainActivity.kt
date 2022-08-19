package com.example.thisret

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thisret.adapter.DataAdapter
import com.example.thisret.databinding.ActivityMainBinding
import com.example.thisret.newModel.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var Madapter: DataAdapter

    //private var list = ArrayList<Data>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)
        showData()
    }

    private fun showData() {

        APIService.retrofitService.getData().enqueue(object : Callback<Book> {
            override fun onResponse(call: Call<Book>, response: Response<Book>) {
                Log.d("response", response.body().toString())
                recyclerView = findViewById<RecyclerView?>(R.id.recuclerView).apply {
                    val listResponse = response.body()?.result?.data
                    Madapter = listResponse?.let { DataAdapter(it) }!!
                    layoutManager = manager
                    adapter = Madapter
                    Madapter.onItemClick ={
                        val intent = Intent(this@MainActivity, ReadActivity::class.java)
                        intent.putExtra("data" , it)
                        startActivity(intent)
                    }
                }
            }


            override fun onFailure(call: Call<Book>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }
}
