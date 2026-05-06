package com.example.financeapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.financeapp.data.model.SharedExpense
import kotlinx.coroutines.flow.Flow

    @Dao
    interface SharedExpenseDao {

        //Insert
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(sharedExpense: SharedExpense)

        //Gastos compartidos por usuario por fecha reciente a antigua)
        @Query("SELECT * FROM shared_expenses WHERE creatorUserId = :userId ORDER BY date DESC")
        fun getSharedExpensesByUser(userId: Long): Flow<List<SharedExpense>>

        //Gastos pendientes (no liquidados, settled = 0)
        @Query("SELECT * FROM shared_expenses WHERE creatorUserId = :userId AND settled = 0")
        fun getUnsettledSharedExpenses(userId: Long): Flow<List<SharedExpense>>

        // Paso 5: Update [cite: 199]
        @Update
        suspend fun update(sharedExpense: SharedExpense)

        // Paso 5: Delete [cite: 199]
        @Delete
        suspend fun delete(sharedExpense: SharedExpense)

    }

