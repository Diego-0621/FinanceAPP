package com.example.financeapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.financeapp.data.model.User
import kotlinx.coroutines.flow.Flow

/**
 * UserDao es nuestro Data Access Object para la tabla usuario. Es un objeto/interfaz
 * que define las operaciones que se pueden hacer sobre la tabla Users.
 * @Dao es una anotación que marca esta interfaz como Dao.
 * Room que genera automáticamente la implementación de todos los métodos
 */
@Dao
interface UserDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Query("SELECT * FROM users WHERE email= :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserById(userId: Long): Flow<User?>

    @Update
    suspend fun  update(user: User)

    @Delete
    suspend fun delete(user: User)
}