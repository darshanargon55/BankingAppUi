package com.example.bankingapp.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardName: String,
    val balance: Double,
    val cardNumber: String,
    val cardColor: Brush
)
