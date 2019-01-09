package com.nhahv.managermoney.data.model

data class UserWedding(
    var id: Long = System.currentTimeMillis(),
    var image: String = "",
    var name: String = "",
    var numberPhone: String = "",
    var moneyWed: String = "",
    var timeWed: String = ""
)