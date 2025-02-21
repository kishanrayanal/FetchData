package com.example.fetchdata

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchdata.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var loadDataButton: Button
    private lateinit var toolbar: Toolbar

    private var allItems: List<Item> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        recyclerView = findViewById(R.id.recyclerView)
        loadDataButton = findViewById(R.id.loadDataButton)
        toolbar = findViewById(R.id.toolbar)

        // Set up the Toolbar (Top Bar)
        setSupportActionBar(toolbar)

        // Initialize RecyclerView with GridLayoutManager for 2 columns
        val gridLayoutManager = GridLayoutManager(this, 2) // 2 columns for ID and Name
        recyclerView.layoutManager = gridLayoutManager
        adapter = ItemAdapter()
        recyclerView.adapter = adapter

        // Set click listener for Load Data button
        loadDataButton.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData() {
        lifecycleScope.launch {
            try {
                // Fetching the data from the API
                val items = RetrofitInstance.apiService.getItems()

                // Filtering out items where name is null or empty
                allItems = items.filter { it.name?.isNotBlank() == true }

                // Initially, display the list sorted by listId and name
                val sortedItems = allItems.sortedWith(compareBy({ it.listId }, { it.name }))
                adapter.submitList(sortedItems)

            } catch (e: HttpException) {
                Toast.makeText(this@MainActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
