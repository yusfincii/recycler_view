package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    // adapter object
    private lateinit var adapter : Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // list which hold the countries
        val countryList = arrayListOf<Country>()

        // countries
        val brazil = Country(1, "Brazil", 214300000, "South America")
        val turkey = Country(2, "turkey", 91000000, "Europa")
        val czechRepublic = Country(3, "Czech Republic", 11900000, "Europa")

        countryList.add(brazil)
        countryList.add(turkey)
        countryList.add(czechRepublic)

        binding.recyclerView.setHasFixedSize(true)
        // determine layout design
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(this, countryList)

        binding.recyclerView.adapter = adapter

    }

}