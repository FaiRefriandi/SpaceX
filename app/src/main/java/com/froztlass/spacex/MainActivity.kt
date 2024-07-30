package com.froztlass.spacex

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var launchesAdapter: LaunchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set status bar and navigation bar to transparent
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT

        // Optional: To make status bar icons and navigation bar icons darker
        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        insetsController?.isAppearanceLightStatusBars = true
        insetsController?.isAppearanceLightNavigationBars = true

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchLaunches()
    }
    //10121079
    //Fa'i Refriandi
    //IF-2 (PemAndro-3)

    private fun fetchLaunches() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(SpaceXApi::class.java)

        api.getLaunches().enqueue(object : Callback<List<Launch>> {
            override fun onResponse(call: Call<List<Launch>>, response: Response<List<Launch>>) {
                if (response.isSuccessful) {
                    launchesAdapter = LaunchAdapter(response.body() ?: emptyList())
                    recyclerView.adapter = launchesAdapter
                }
            }

            override fun onFailure(call: Call<List<Launch>>, t: Throwable) {
            }
        })
    }
}

