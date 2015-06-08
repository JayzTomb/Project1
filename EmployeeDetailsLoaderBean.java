package com.abc_company;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "EmployeeDetailsLoaderBean")
@ViewScoped
public class EmployeeDetailsLoaderBean {

	private Employee selectedEmployee;
	private List<Employee> filteredEmployee;

	// Generate Getters and Setters after adding this variable

	public List<Employee> empDisplayList = new ArrayList<Employee>();

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public List<Employee> getFilteredEmployee() {
		return filteredEmployee;
	}

	public void setFilteredEmployee(List<Employee> filteredEmployee) {
		this.filteredEmployee = filteredEmployee;
	}

	public EmployeeDetailsLoaderBean() {
		Employee employee = new Employee();
		employee.setEmpNo(123);
		employee.setFirstName("praneeth");
		employee.setLastName("kalindu");
		employee.setEmail("praneeth@gamil.com");
		employee.setMobile(0711070216);
		// Add Student To Display List
		empDisplayList.add(employee);
		employee = new Employee();
		employee.setEmpNo(101);
		employee.setFirstName("Test 1");
		employee.setLastName("Test 1");
		employee.setEmail("test1@gamil.com");
		employee.setMobile(0711070216);
		// Add Student To Display List
		empDisplayList.add(employee);
		employee = new Employee();
		employee.setEmpNo(102);
		employee.setFirstName("Test 2");
		employee.setLastName("Test 2");
		employee.setEmail("test2@gamil.com");
		employee.setMobile(0711070216);
		// Add Student To Display List
		empDisplayList.add(employee);
	}

	public List<Employee> getEmpDisplayList() {
		return empDisplayList;
	}

	public void setEmpDisplayList(List<Employee> empDisplayList) {
		this.empDisplayList = empDisplayList;
	}

	public void deleteEmployee() {
		empDisplayList.remove(selectedEmployee);
	}

	public void onEdit(RowEditEvent event) {
		Employee st = (Employee) event.getObject();
		int empNo = st.getEmpNo();
		FacesMessage msg = new FacesMessage(empNo + " EMP No Row Edited", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		Employee st = (Employee) event.getObject();
		int empNo = st.getEmpNo();
		FacesMessage msg = new FacesMessage(empNo
				+ " EMP No Row Edit Cancelled", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
