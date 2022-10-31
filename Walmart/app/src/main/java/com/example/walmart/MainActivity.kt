package com.example.walmart

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userList = arrayListOf(
        User("John", "Lennon", "jlennon@gmail.com", "lennonBeatles1!"),
        User("Paul", "McCartney", "pmccartney@yahoo.com", "mccartneyBeatles2!"),
        User("George", "Harrison", "gharrison@hotmail.com", "harrisonBeatles3!"),
        User("Ringo", "Starr", "rstarr@gmail.com", "starrBeatles1!"),
        User("Elvis", "Presley", "epresley@hotmail.com", "rockNroll!"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerIntent = intent.getSerializableExtra("newUser")
        registerIntent?.let {
            registerIntent as User
            userList.add(registerIntent)
        }

        btnSignIn.setOnClickListener{
            if(validateUser(userList)){
                val intentShopping = Intent(this, ShoppingActivity::class.java)
                intentShopping.putExtra("username", editUserName.text.toString())
                startActivity(intentShopping)
            }
            else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show()
            }
        }

        btnCreateAccount.setOnClickListener{
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }

        textViewForget.setOnClickListener{
            val to: String = editUserName.text.toString()
            val subject = "Account Password"
            val message: String = "Your Walmart account password is: "
            if(to.isNullOrEmpty()){
                Toast.makeText(this, "Email Address is empty", Toast.LENGTH_LONG).show()
            }
            else{
                val pword = userList.filter { it.userName.equals(to) }.first().password
                val email = Intent(Intent.ACTION_SEND)
                email.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
                email.putExtra(Intent.EXTRA_SUBJECT, subject)
                email.putExtra(Intent.EXTRA_TEXT, "$message $pword")

                email.setType("text/plain");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        }
    }

    fun validateUser(list: ArrayList<User>) : Boolean{
        return list.filter { it.userName.equals(editUserName.text.toString()) && it.password.equals(editTextPassword.text.toString())}.size == 1
    }
}