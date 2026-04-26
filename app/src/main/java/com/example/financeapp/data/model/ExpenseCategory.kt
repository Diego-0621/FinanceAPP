package com.example.financeapp.data.model

/**
 * ExpenseCategory es una enumeración de categorias de gastos
 */
enum class ExpenseCategory(val displayName: String) {
    FOOD("alimentación"),
    TRANSPORT("Transporte"),
    ENTERTAINMENT("Entretenimiento"),
    BILLS("Servicios"),
    SHOPPING("Compras"),
    HEALTH("Salud"),
    TRAVEL("Viajes"),
    OTHER("Otros"),
}