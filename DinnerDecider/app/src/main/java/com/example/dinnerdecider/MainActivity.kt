package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dinnerList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

        btnDecide.setOnClickListener{
            dinnerView.text = getRandomElement(dinnerList)
        }

        btnAddFood.setOnClickListener{
            if(!food.text.toString().equals("")){
                dinnerList.add(food.text.toString())
                food.text.clear()
                dinnerView.text = ""
            }
        }
    }

    fun getRandomElement(list: ArrayList<String>): String {
        val randomIndex = Random.nextInt(list.size)
        return list[randomIndex]
    }
}