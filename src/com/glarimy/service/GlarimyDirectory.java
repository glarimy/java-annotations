package com.glarimy.service;

import java.util.List;

import com.glarimy.api.Directory;
import com.glarimy.api.DirectoryException;
import com.glarimy.api.DuplicateEmployeeException;
import com.glarimy.api.Employee;
import com.glarimy.api.EmployeeNotFoundException;
import com.glarimy.api.Inject;
import com.glarimy.api.InvalidEmployeeException;
import com.glarimy.data.DAO;

public class GlarimyDirectory implements Directory {
	private DAO dao;

	public DAO getDao() {
		return dao;
	}

	@Inject
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public void add(Employee employee) throws InvalidEmployeeException, DuplicateEmployeeException, DirectoryException {
		if (employee == null || employee.getEid() < 1972 || employee.getName() == null
				|| employee.getName().trim().length() == 0)
			throw new InvalidEmployeeException();
		if (dao.find(employee.getEid()) != null) {
			throw new DuplicateEmployeeException();
		}
		dao.add(employee);
	}

	@Override
	public Employee find(int eid) throws EmployeeNotFoundException, DirectoryException {
		Employee e = dao.find(eid);
		if (e == null)
			throw new EmployeeNotFoundException();
		return e;
	}

	@Override
	public List<Employee> list() throws DirectoryException {
		return dao.list();
	}
}
