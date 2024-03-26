package com.baben.apps.appformation3.data.remote.models

data class Address(
    val city: String,
    val geolocation: Geolocation,
    val number: Int,
    val street: String,
    val zipcode: String
)