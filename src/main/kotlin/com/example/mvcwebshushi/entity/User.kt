package com.example.mvcwebshushi.entity

data class User(
    var firstName: String,
    var lastName: String,
) {
    override fun toString() = "User{firstName=$firstName, lastName=$lastName}"
}
