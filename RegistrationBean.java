package com.abc_company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FlowEvent;

@ManagedBean(name = "RegistrationBean")
@ViewScoped
public class RegistrationBean {

	final String JDBC_DRIVER = "org.postgresql.Driver";
	final String DB_URL = "jdbc:postgresql://localhost/ABC_Company";
	final String USER = "postgres";
	final String PASS = "admin";

	private boolean skip;
	private String empNo;
	private String firstName;
	private String lastName;
	private Date join_date;
	private String nic;
	private int age;
	private char sex;
	private String designation;
	private String add1;
	private String add2;
	private String add3;
	private int mobile;
	private int office;
	private String email;
	private int viber;
	private String skype;
	private String facebook;
	private String twitter;
	private String google_plus;
	private String depend_name;
	private String relationship;
	private String dependancy;
	private Date dob;
	private String gender;

	public void save(ActionEvent actionEvent) {
		boolean insertState = false;
		// Insert Recode
		insertState = insertRecode();
		if (insertState) {
			System.out.println("########### Successfully Submited###########");
			resetData();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO:",
							"Successfully Submited"));
		} else {
			System.out.println("########### Submit Fail ###########");
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"Submit Fail"));
		}
	}

	private boolean insertRecode() {
		boolean insertState = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			try {
				System.out.println("Connecting to Database...");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Executing SQL...");
				/*
				 * Format formatter = new
				 * SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				 */
				String sex = String.valueOf(this.sex);

				/* String formatedDob = formatter.format(this.dob); */

				/* String formatedJoinDate = formatter.format(this.join_date); */

				String sql =

				"INSERT INTO IT.Employee (fname, lname, NIC, age, sex, designation, add1, add2, add3) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, this.firstName);
				pstmt.setString(2, this.lastName);
				/* pstmt.setString(3, formatedJoinDate); */
				pstmt.setString(3, this.nic);
				pstmt.setInt(4, this.age);
				pstmt.setString(5, sex);
				pstmt.setString(6, this.designation);
				pstmt.setString(7, this.add1);
				pstmt.setString(8, this.add2);
				pstmt.setString(9, this.add3);

				int affectedRows = pstmt.executeUpdate();

				System.out.println(affectedRows + " row(s) affected !!");
				System.out.println("Recode Insert successfully...");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != pstmt) {
						pstmt.close();
					}
					if (null != con) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return insertState;
	}

	// Reset Page Data After Submit
	private void resetData() {
		this.firstName = "";
		this.lastName = "";
		this.join_date = null;
		this.nic = "";
		this.age = 0;
		this.sex = '\u0000';
		this.designation = "";
		this.add1 = "";
		this.add2 = "";
		this.add3 = "";
		this.mobile = 0;
		this.office = 0;
		this.email = "";
		this.viber = 0;
		this.skype = "";
		this.facebook = "";
		this.twitter = "";
		this.google_plus = "";
		this.depend_name = "";
		this.relationship = "";
		this.dependancy = "";
		this.dob = null;
		this.gender = "";
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	// Generate Getters and Setters

	public String getFirstName() {
		return firstName;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getOffice() {
		return office;
	}

	public void setOffice(int office) {
		this.office = office;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getViber() {
		return viber;
	}

	public void setViber(int viber) {
		this.viber = viber;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getGoogle_plus() {
		return google_plus;
	}

	public void setGoogle_plus(String google_plus) {
		this.google_plus = google_plus;
	}

	public String getDepend_name() {
		return depend_name;
	}

	public void setDepend_name(String depend_name) {
		this.depend_name = depend_name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getDependancy() {
		return dependancy;
	}

	public void setDependancy(String dependancy) {
		this.dependancy = dependancy;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
