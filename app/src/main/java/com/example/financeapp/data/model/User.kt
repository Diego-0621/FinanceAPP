package com.example.financeapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User - Entidad que representa un usuario en la base de datos
 *@Entity = anotación de Room que marca esta clase como una tabla se SQLite
 *
 */
@Entity(tableName= "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val email: String,
    val passwordHash: String,
    val createAt: Long = System.currentTimeMillis()
)
/**Aqui se está creando una tabla como entidad*/
