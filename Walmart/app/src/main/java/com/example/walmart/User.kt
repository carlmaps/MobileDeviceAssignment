package com.example.walmart

import java.io.Serializable

class User(var firstName: String, var lastName: String,var userName: String, var password: String):Serializable {
    override fun toString(): String {
        return "User(firstName=$firstName, lastName=$lastName, userName=$userName, password=$password)"
    }
}




