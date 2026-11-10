package com.spendwise.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val merchant: String,

    val amount: Double,

    val category: String,

    val date: Long = System.currentTimeMillis(),

    val paymentMethod: String = "UPI",

    val note: String = ""
)