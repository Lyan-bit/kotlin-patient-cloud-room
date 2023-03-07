package com.example.patient

import kotlinx.coroutines.flow.Flow

class Repository : AppointmentRepository  {

    private val appointmentDao: AppointmentEntityDao by lazy { PatientApplication.database.appointmentDao() }

    val allAppointments: Flow<List<AppointmentEntity>> = appointmentDao.listAppointments()

    val allAppointmentappointmentIds: Flow<List<String>> = appointmentDao.listAppointmentappointmentIds()
    val allAppointmentcodes: Flow<List<String>> = appointmentDao.listAppointmentcodes()

    //Create
    override suspend fun createAppointment(appointment: AppointmentEntity) {
        appointmentDao.createAppointment(appointment)
    }

    //Read
    override suspend fun listAppointment(): List<AppointmentEntity> {
        return appointmentDao.listAppointment()
    }

    //Update
    override suspend fun updateAppointment(appointment: AppointmentEntity) {
        appointmentDao.updateAppointment(appointment)
    }

    //Delete all Appointments
    override suspend fun deleteAppointments() {
       appointmentDao.deleteAppointments()
    }

    //Delete a Appointment
	override suspend fun deleteAppointment(appointmentId: String) {
	   appointmentDao.deleteAppointment(appointmentId)
    }
    
     //Search with live data
     override fun searchByAppointmentappointmentId (searchQuery: String): Flow<List<AppointmentEntity>>  {
         return appointmentDao.searchByAppointmentappointmentId(searchQuery)
     }
     
     //Search with live data
     override fun searchByAppointmentcode (searchQuery: String): Flow<List<AppointmentEntity>>  {
         return appointmentDao.searchByAppointmentcode(searchQuery)
     }
     

    //Search with suspend
     override suspend fun searchByAppointmentappointmentId2 (appointmentId: String): List<AppointmentEntity> {
          return appointmentDao.searchByAppointmentappointmentId2(appointmentId)
     }
	     
    //Search with suspend
     override suspend fun searchByAppointmentcode2 (code: String): List<AppointmentEntity> {
          return appointmentDao.searchByAppointmentcode2(code)
     }
	     


}
