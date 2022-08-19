package com.example.thisret

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.os.HandlerCompat.postDelayed

class LogoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        Handler(Looper.getMainLooper()).postDelayed({
            isNetworkAvailable()

        }, 3000)
    }

    private fun isNetworkAvailable(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkActivity = Intent(this, NetworkActivity::class.java)
            startActivity(networkActivity)
            finish()
            val network = cm.activeNetwork

            network ?: return false
            val actNetwork = cm.getNetworkCapabilities(network)
            return when {
                actNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    val mainActivity = Intent(this, MainActivity::class.java)
                    startActivity(mainActivity)
                    finish()
                    Log.d("Network", "wifi connected")
                    true
                }
                actNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    val mainActivity = Intent(this, MainActivity::class.java)
                    startActivity(mainActivity)
                    finish()
                    Log.d("Network", "cellular network connected")
                    true
                }
                else -> {
                    val networkActivity = Intent(this, NetworkActivity::class.java)
                    startActivity(networkActivity)
                    finish()
                    Log.d("Network", "internet not connected ")
                    false
                }
            }
        }
        return false
    }
}





