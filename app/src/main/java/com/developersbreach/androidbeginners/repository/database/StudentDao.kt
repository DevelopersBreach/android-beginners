package com.developersbreach.androidbeginners.repository.database

import androidx.room.*
import com.developersbreach.androidbeginners.model.Student
import com.developersbreach.androidbeginners.utils.COLUMN_STUDENT_NAME
import com.developersbreach.androidbeginners.utils.TABLE_STUDENTS
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Query("SELECT * FROM $TABLE_STUDENTS ORDER BY $COLUMN_STUDENT_NAME ASC")
    fun getStudentsByOrder(): Flow<List<Student>>

    @Query("SELECT * FROM $TABLE_STUDENTS")
    fun getStudents(): List<Student>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(student: Student)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("DELETE FROM table_student")
    suspend fun deleteAllStudents()

    @Delete
    suspend fun deleteSingleStudent(student: Student)
}