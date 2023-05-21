package com.fatihkaratekin.yemekapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navigateToRecipesButton: Button = findViewById(R.id.navigateToRecipesBtn)
        val img: ImageView = findViewById(R.id.app_icon)

        img.setImageResource(R.drawable.logo)



        navigateToRecipesButton.setOnClickListener {

            val intent = Intent(this, TarifListesi::class.java)

            startActivity(intent)

            overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        }
    }
    }

