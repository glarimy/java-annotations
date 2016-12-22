package com.glarimy.data;

import java.util.List;

import com.glarimy.api.DirectoryException;
import com.glarimy.api.Employee;

public interface DAO {

	void add(Employee employee) throws DirectoryException;

	Employee find(int eid) throws DirectoryException;

	List<Employee> list() throws DirectoryException;

}