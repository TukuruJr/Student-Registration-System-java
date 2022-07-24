package com.java.student_model_class;

public class Student {
	private String surname,firstname,lastname,adm,email,mobile,course,department,faculty,gender,guardian,guardianemail,guardiancontact;
	private int idno;
//
//	public Student() {
//		// TODO Auto-generated constructor stub
//	}

	public Student(String surname, String firstname, String lastname, String adm, String email, String mobile,
			String course, String department, String faculty, String gender, String gurdian, String gurdianemail,
			String guardiancontact,int idno) 
	{
		super();
		this.surname = surname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.adm = adm;
		this.email = email;
		this.mobile = mobile;
		this.course = course;
		this.department = department;
		this.faculty = faculty;
		this.gender = gender;
		this.guardian = gurdian;
		this.guardianemail = gurdianemail;
		this.guardiancontact = guardiancontact;
		this.idno = idno;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAdm() {
		return adm;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getCourse() {
		return course;
	}

	public String getDepartment() {
		return department;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getGender() {
		return gender;
	}

	public String getGuardian() {
		return guardian;
	}

	public String getGuardianemail() {
		return guardianemail;
	}

	public String getGuardiancontact() {
		return guardiancontact;
	}
	
	public int getIdno() {
		return idno;
	}

}
