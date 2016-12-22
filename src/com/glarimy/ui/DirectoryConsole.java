package com.glarimy.ui;

import com.glarimy.api.Directory;
import com.glarimy.api.Employee;
import com.glarimy.api.Factory;

public class DirectoryConsole {
	public static void main(String[] args) throws Exception {
		Directory directory = (Directory) Factory.get("directory");
		Employee employee = new Employee(1972, "Krishna");
		directory.add(employee);

		directory.add(new Employee(1973, "Mohan"));
		System.out.println(directory.find(1972));
	}
}
