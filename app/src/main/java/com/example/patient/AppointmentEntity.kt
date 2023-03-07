package com.example.patient

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointmentTable")
data class AppointmentEntity (
    @PrimaryKey
    val appointmentId: String, 
    val code: String
)
