package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonCreate.setOnClickListener{
            var mainIntent = Intent(this,MainActivity::class.java)
            if (editTextFirstNm.text.isNotEmpty() && editTextLastNm.text.isNotEmpty() && editTextRegUserName.text.isNotEmpty()
                && editTextRegPassword.text.isNotEmpty()){
                val newUser = User(editTextFirstNm.text.toString(), editTextLastNm.text.toString(),
                    editTextRegUserName.text.toString(), editTextRegPassword.text.toString())
                mainIntent.putExtra("newUser", newUser)
                startActivity(mainIntent)
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Some required fields are empty!", Toast.LENGTH_LONG).show()
            }
        }
    }
}