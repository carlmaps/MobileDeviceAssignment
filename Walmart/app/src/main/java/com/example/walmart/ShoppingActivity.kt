package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val shoppingIntent = intent
        val welcomeText = "Welcome ${shoppingIntent.getStringExtra("username")}"
        textWelcome.text = welcomeText
    }

    fun onClickHandler(view: View) {

        when (view.getId()){
            R.id.imageElectronics -> {
                Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
                val plistIntent = Intent(this, ProductList::class.java)
                startActivity(plistIntent)
            }
            R.id.imageClothing -> Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
            R.id.imageBeauty -> Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
            R.id.imageFood -> Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
        }
    }
}