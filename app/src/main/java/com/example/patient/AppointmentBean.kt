package com.example.patient

import android.content.Context

class AppointmentBean(c: Context) {

    private var model: ModelFacade = ModelFacade.getInstance(c)

    private var appointmentId = ""
    private var code = ""
    private var patientId = ""

    private var errors = ArrayList<String>()
    private var checkParameter = " is not exist"
    private var checkEmpty = " cannot be empty"

    fun setAppointmentId(appointmentIdx: String) {
	 appointmentId = appointmentIdx
    }
    
    fun setCode(codex: String) {
	 code = codex
    }
    

    fun setPatientId(patientIdx : String) {
	patientId = patientIdx
    }

    fun resetData() {
	  appointmentId = ""
	  code = ""
    }
    
    fun isCreateAppointmentError(): Boolean {
	        
	 errors.clear()
	        
          if (appointmentId != "") {
	//validate
}
	else {
	 	  errors.add(appointmentId + checkEmpty)
	}
          if (code != "") {
	//validate
}
	else {
	 	  errors.add(code + checkEmpty)
	}

	        return errors.isNotEmpty()
	    }
	    
	    suspend fun createAppointment() {
	        model.createAppointment(AppointmentEntity(appointmentId, code))
	        resetData()
	    }

    fun isListAppointmentError(): Boolean {
	        errors.clear()
		//if statement
	        return errors.isNotEmpty()
	    }

     suspend fun editAppointment() {
		     model.editAppointment(AppointmentEntity(appointmentId, code))
		     resetData()
		 }
		       
		 fun isEditAppointmentError(allAppointmentappointmentIds: List<String>): Boolean {
	        
	        errors.clear()
			
			if (!allAppointmentappointmentIds.contains(appointmentId)) {
				errors.add(appointmentId + checkParameter)
		    }
			          if (appointmentId != "") {
	        	//validate
	        }
	         else {
	               errors.add(appointmentId + checkEmpty)
	         }
	                  if (code != "") {
	        	//validate
	        }
	         else {
	               errors.add(code + checkEmpty)
	         }
	        
       return errors.isNotEmpty()
   }

	    suspend fun deleteAppointment() {
	        model.deleteAppointment(appointmentId)
	        resetData()
	    }
	    
	    fun isDeleteAppointmentError(allAppointmentappointmentIds: List<String>): Boolean {
	         errors.clear()
			 if (!allAppointmentappointmentIds.contains(appointmentId)) {
			    errors.add(appointmentId + checkParameter)
	         }
	         return errors.isNotEmpty()
		}    


		fun isSearchAppointmentIdError(allAppointmentIds: List<String>): Boolean {
    	   errors.clear()
   	       if (!allAppointmentIds.contains(appointmentId)) {
    	       errors.add(appointmentId + checkParameter)
    	   }
           return errors.isNotEmpty()
    }

    fun errors(): String {
        return errors.toString()
    }

   fun isAddPatientattendsAppointmentError(): Boolean {
        errors.clear()
	if (appointmentId != "" ) {
		   //ok
	   } else
		   errors.add(appointmentId + checkEmpty)

	if ( patientId != "") {
		   //ok
	   } else
		   errors.add(patientId + checkEmpty)
        return errors.isNotEmpty()
    }

    fun addPatientattendsAppointment() {
         model.addPatientattendsAppointment(appointmentId, patientId)
         resetData()
    }
    
   fun isRemovePatientattendsAppointmentError(): Boolean {
        errors.clear()
	if (appointmentId != "" ) {
		   //ok
	   } else
		   errors.add(appointmentId + checkEmpty)

	if ( patientId != "" && patientId != "Null") {
		   //ok
	   } else
		   errors.add(patientId + checkEmpty)
        return errors.isNotEmpty()
    }

    fun removePatientattendsAppointment() {
         model.removePatientattendsAppointment(appointmentId, patientId)
         resetData()
    }
    


}

