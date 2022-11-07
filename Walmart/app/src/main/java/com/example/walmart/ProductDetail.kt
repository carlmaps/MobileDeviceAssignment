package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val pdetails = intent
        viewProductDetail.setImageResource(intent.getIntExtra("image",0))
        val color = "Color: ${intent.getStringExtra("color")}"
        val itemid = "Walmart#: ${intent.getStringExtra("itemID")}"
        val description = "Item Description: \n${intent.getStringExtra("desc")}"
        tvTitle.text = intent.getStringExtra("title")
        tvColor.text = color
        tvItemID.text = itemid
        tvDesc.text = description
    }
}