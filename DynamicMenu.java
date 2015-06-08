package com.abc_company;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "DynamicMenu")
@SessionScoped
public class DynamicMenu {

	private MenuModel menuModel;

	public DynamicMenu() throws Exception {
		generateMenuModel();
	}

	public void generateMenuModel() {
		try {

			DefaultSubMenu subMenuHeader = null;

			DefaultMenuItem item = null;

			menuModel = new DefaultMenuModel();

			subMenuHeader = new DefaultSubMenu("Employee Managment");

			item = new DefaultMenuItem("Register Employee");
			item.setUrl("/pages/CreateEmp.xhtml?param=registration");
			item.setIcon("ui-icon-disk");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("Edit Employee");
			item.setUrl("/pages/EditEmp.xhtml?param=editEmp");
			item.setIcon("ui-icon-check");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("View Employee");
			item.setUrl("/pages/ViewEmp.xhtml?param=viewEmp");
			item.setIcon("ui-icon-search");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("Delete Employee");
			item.setUrl("/pages/DeleteEmp.xhtml?param=deleteEmp");
			item.setIcon("ui-icon-close");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			menuModel.addElement(subMenuHeader);

			subMenuHeader = new DefaultSubMenu("Department Managment");

			item = new DefaultMenuItem("Create Department");
			item.setUrl("/pages/CreateDept.xhtml?param=createDepartment");
			item.setIcon("ui-icon-disk");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("Edit Department");
			item.setUrl("/pages/EditDept.xhtml?param=editDept");
			item.setIcon("ui-icon-check");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("View Department");
			item.setUrl("/pages/ViewDept.xhtml?param=viewDept");
			item.setIcon("ui-icon-search");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("Delete Department");
			item.setUrl("/pages/DeleteDept.xhtml?param=deleteDept");
			item.setIcon("ui-icon-close");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			menuModel.addElement(subMenuHeader);

			subMenuHeader = new DefaultSubMenu("Project Managment");

			item = new DefaultMenuItem("Create Project");
			item.setUrl("/pages/CreateProject.xhtml?param=createProj");
			item.setIcon("ui-icon-disk");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("Edit Project");
			item.setUrl("/pages/EditProject.xhtml?param=editProj");
			item.setIcon("ui-icon-check");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("View Project");
			item.setUrl("/pages/ViewProject.xhtml?param=viewProj");
			item.setIcon("ui-icon-search");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			item = new DefaultMenuItem("Delete Project");
			item.setUrl("/pages/DeleteProject.xhtml?param=deleteProj");
			item.setIcon("ui-icon-close");
			item.setAjax(false);
			subMenuHeader.addElement(item);

			menuModel.addElement(subMenuHeader);

		} catch (Exception e) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Internal Error", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
}
