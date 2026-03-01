package com.example.services;

public class AppointmentService {
	private final java.util.Map<String, Appointment> appointments = new java.util.HashMap<>();

	public void addAppointment(Appointment appointment) {
		if (appointment == null) {
			throw new IllegalArgumentException("appointment must not be null");
		}
		String appointmentId = appointment.getAppointmentId();
		if (appointments.containsKey(appointmentId)) {
			throw new IllegalArgumentException("Appointment ID already exists: " + appointmentId);
		}
		appointments.put(appointmentId, appointment);
	}

	public Appointment addAppointment(String appointmentId, java.util.Date appointmentDate, String description) {
		Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
		addAppointment(appointment);
		return appointment;
	}

	public void deleteAppointment(String appointmentId) {
		if (appointmentId == null) {
			throw new IllegalArgumentException("appointmentId must not be null");
		}
		Appointment removed = appointments.remove(appointmentId);
		if (removed == null) {
			throw new IllegalArgumentException("No appointment found for ID: " + appointmentId);
		}
	}

	public Appointment getAppointment(String appointmentId) {
		if (appointmentId == null) {
			throw new IllegalArgumentException("appointmentId must not be null");
		}
		Appointment appointment = appointments.get(appointmentId);
		if (appointment == null) {
			throw new IllegalArgumentException("No appointment found for ID: " + appointmentId);
		}
		return appointment;
	}
}
