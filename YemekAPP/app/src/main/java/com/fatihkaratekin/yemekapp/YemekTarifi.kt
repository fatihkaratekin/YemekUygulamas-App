package com.fatihkaratekin.yemekapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class YemekTarifi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yemek_tarifi)

        val foodName = intent.getStringExtra("foodName")
        val recipeText = intent.getStringExtra("explanation")
        val foodImage = intent.getIntExtra("image", 0)


        val foodNameTV: TextView = findViewById(R.id.foodNameTV)
        val foodIV: ImageView = findViewById(R.id.foodIV)
        val recipeTV: TextView = findViewById(R.id.foodRecipeExplanationTV)


        foodNameTV.text = foodName
        foodIV.setImageResource(foodImage)
        recipeTV.text = recipeText



    }
}

