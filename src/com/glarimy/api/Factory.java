package com.glarimy.api;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Factory {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object get(String key) throws Exception {

		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		Class claz = Class.forName(properties.getProperty(key));
		Object o = null;
		try {
			o = claz.newInstance();
		} catch (Exception e) {
			Singleton singleton = (Singleton) claz.getAnnotation(Singleton.class);
			Method method = claz.getMethod(singleton.factoryMethod());
			o = method.invoke(claz);
		}

		Method[] methods = claz.getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("set") && m.isAnnotationPresent(Inject.class)) {
				String param = m.getName().substring(3).toLowerCase();
				Object dependency = Factory.get(param);
				m.invoke(o, dependency);
			}
		}

		return o;
	}

}
