package com.developersbreach.androidbeginners.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.developersbreach.androidbeginners.utils.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_STUDENTS)
data class Student(

    @PrimaryKey
    @ColumnInfo(name = COLUMN_STUDENT_NAME)
    val name: String
): Parcelable