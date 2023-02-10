package Appointment; 

import java.util.Date;

public class Appointment {

	final private byte ID_LENGTH;
	final private byte DESCRIPTION_LENGTH;
	final private String TEST;
	// Varaibles required by Rubrtic
	private String appointmentID;
	private Date appointmentDate;
	private String description;

	{
		ID_LENGTH = 10; // Rubric requirement says this can not be longer than 10 characters
		DESCRIPTION_LENGTH = 50; // Rubric requirement says this can not be longer than 50 characters
		TEST = "INITIAL";
	} 

	public Appointment() {
		Date today = new Date(); // Todays data is the new date
		appointmentID = TEST;
		appointmentDate = today; // Appointment data is set to today's date
		description = TEST;
	}

	public Appointment(String ID) {
		Date today = new Date();
		updateAppointmentID(ID);
		appointmentDate = today;
		description = TEST;
	}

	public Appointment(String ID, Date date) {
		updateAppointmentID(ID);
		updateDate(date);
		description = TEST;
	}

	public Appointment(String ID, Date date, String description) {
		updateAppointmentID(ID);
		updateDate(date);
		updateDescription(description);
	}
	
	// The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. 
	// The appointment ID shall not be null and shall not be updatable.
	public void updateAppointmentID(String ID) {
		if (ID == null) {
			throw new IllegalArgumentException("The appointment ID cannot be null.");
		} else if (ID.length() > ID_LENGTH) {
			throw new IllegalArgumentException("Appointment ID cannot be longer than " + ID_LENGTH + " characters.");
		} else {
			this.appointmentID = ID;
		}
	}

	public String getAppointmentID() {
		return appointmentID;
	}

	// The appointment object shall have a required appointment Date field. 
	// The appointment Date field cannot be in the past. 
	// The appointment Date field shall not be null.
	public void updateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("The appointment date cannot be null.");
		} else if (date.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment on that date.");
		} else {
			this.appointmentDate = date;
		}
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	// The appointment object shall have a required description String field that cannot be longer than 50 characters. 
	// The description field shall not be null.
	public void updateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("The appointment description cannot be null.");
		} else if (description.length() > DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException(
					"Appointment description cannot be longer than " + DESCRIPTION_LENGTH + " characters.");
		} else {
			this.description = description;
		}
	}

	public String getDescription() {
		return description;
	}
}