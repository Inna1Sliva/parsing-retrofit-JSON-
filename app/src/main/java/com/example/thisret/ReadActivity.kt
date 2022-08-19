package com.example.thisret

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thisret.databinding.ActivityMainBinding
import com.example.thisret.databinding.ActivityReadBinding
import com.example.thisret.newModel.Data

class ReadActivity : AppCompatActivity() {


    private lateinit var binding: ActivityReadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.navigationbefore?.setOnClickListener {beforActivity()  }
        val data = intent.getParcelableExtra<Data>("data")
        if (data !=null){
            val textbar = binding.titleActivity
            val  titleName = binding.titleName
            val titleData = binding.titleData
            val description =binding.description
            textbar.text = data.name
            titleName.text = data.name
            titleData.text = data.date
            description!!.text = data.description
        }
    }

    private fun beforActivity() {
        val mainActivity = Intent(this, MainActivity::class.java)
        startActivity(mainActivity)
    }
}