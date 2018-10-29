package com.example.alanvan.recyclerviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {
    private val mRecipeTitleList = ArrayList<String>()
    private val mRecipeDescriptionList = ArrayList<String>()
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populate mRecipleTitleList and mRecipeDescriptionList with information from resources
        val recipeTitles = resources.getStringArray(R.array.recipe_title)
        val recipeDescription = resources.getStringArray(R.array.recipe_description)

        for (string in recipeTitles)
            mRecipeTitleList.add(string)
        for (string in recipeDescription)
            mRecipeDescriptionList.add(string)

        // Get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview)
        // Create an adapter and supply data to be displayed
        mAdapter = RecipeAdapter(this, mRecipeTitleList, mRecipeDescriptionList)
        // Connect the adapter with the ReyclerView
        mRecyclerView.adapter = mAdapter
        // Give the RecyclerView a default layout manager
        mRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
