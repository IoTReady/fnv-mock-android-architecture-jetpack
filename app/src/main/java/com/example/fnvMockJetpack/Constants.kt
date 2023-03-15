package com.example.fnvMockJetpack

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle

object Constants  {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "TransferOut",
            icon = Icons.Filled.AccountCircle,
            route = "TransferOut"
        ),
        BottomNavItem(
            label = "Procurement",
            icon = Icons.Filled.AccountCircle,
            route = "Procurement"
        ),

        )
}