package com.example.mvcwebshushi.entity

import java.io.Serializable

data class User(
    var firstName: String? = null,
    var lastName: String? = null,
) : Serializable {
    override fun toString() = "User{firstName=$firstName, lastName=$lastName}"
}
