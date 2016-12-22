package com.glarimy.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.api.DirectoryException;
import com.glarimy.api.Employee;
import com.glarimy.api.Singleton;

@Singleton(factoryMethod = "getInstance")
public class MemoryDAO implements DAO {
	private Map<Integer, Employee> staff = new HashMap<>();
	private static DAO instance = null;

	private MemoryDAO() {

	}

	public static synchronized DAO getInstance() {
		if (instance == null)
			instance = new MemoryDAO();
		return instance;
	}

	@Override
	public void add(Employee employee) throws DirectoryException {
		staff.put(employee.getEid(), employee);
	}

	@Override
	public Employee find(int eid) throws DirectoryException {
		return staff.get(eid);
	}

	@Override
	public List<Employee> list() throws DirectoryException {
		return new ArrayList<>(staff.values());
	}

}
