package com.example.alanvan.recyclerviewdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class RecipeAdapter (context: Context, recipeTitles: ArrayList<String>, recipeDescriptions: ArrayList<String>)
    : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // Rep
    private val mRecipeTitles = recipeTitles
    private val mRecipeDescriptions = recipeDescriptions
    private val mInflater = LayoutInflater.from(context)

    // Rep invariants:
    // mRecipeTitles.size = mRecipeDescriptions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.RecipeViewHolder {
        val mItemView = mInflater.inflate(R.layout.recipe_item, parent, false)
        return RecipeViewHolder(mItemView, this)
    }

    // Gets the number of items in data
    override fun getItemCount(): Int {
        return mRecipeTitles.size
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        val mCurrentTitle = mRecipeTitles[position]
        val mCurrentDescription = mRecipeDescriptions[position]

        holder.titleItemView.text = mCurrentTitle
        holder.descriptionItemView.text = mCurrentDescription
    }

    inner class RecipeViewHolder(itemView: View, adapter: RecipeAdapter)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val titleItemView: TextView = itemView.findViewById(R.id.recipe_title)
        val descriptionItemView: TextView = itemView.findViewById(R.id.recipe_description)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Toast.makeText(v.context, "clicked", Toast.LENGTH_SHORT).show()
        }
    }

}