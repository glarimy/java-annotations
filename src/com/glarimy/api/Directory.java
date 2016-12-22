package com.glarimy.api;

import java.util.List;

public interface Directory {
	public void add(Employee employee) throws InvalidEmployeeException, DuplicateEmployeeException, DirectoryException;

	public Employee find(int eid) throws EmployeeNotFoundException, DirectoryException;

	public List<Employee> list() throws DirectoryException;

}
