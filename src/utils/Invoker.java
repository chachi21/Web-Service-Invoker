package utils;


import java.lang.reflect.Method;
import java.util.HashMap;

import javax.xml.ws.Service;

public class Invoker {

	 public static HashMap<String, Object> invokeMethod(Object serv, String aClass, String aMethod, Object[] args) throws Exception {
		Class<?> c = Class.forName(aClass);
     	int pos = 0;
     	//System.out.println("metodo de entrada: "+aMethod);
 	    for(int p = 0; p < c.getDeclaredMethods().length; p++){
 	    	//System.out.println("metodo "+p+" "+c.getMethods()[p].getName());
 	    	if(c.getMethods()[p].getName().equals(aMethod))
 	    		pos = p;
 	    }
 	    Method m = c.getDeclaredMethods()[pos];
		if (!m.getName().equals(aMethod)){
			System.err.println("no se encontro el metodo a invocar");
			return null;
		}
		Object o = m.invoke(serv, args);
		HashMap<String, Object> r = new HashMap<String, Object>();
		if(m.getReturnType().getName().contains("String")){
			r.put("Output", o);
			return r;
		}
		r = (HashMap<String, Object>) o.getClass().getMethod("getReturnedData", null).invoke(o, null);
		return r;
	 }
	 
	 public static Object invokeService(Service service, String aClass, String aMethod) throws Exception {
			Class<?> c = Class.forName(aClass);
			int pos = 0;
			//System.out.println("metodo de entrada: "+aMethod);
			for(int p = 0; p < c.getDeclaredMethods().length; p++){
				//System.out.println(c.getMethods()[p].getName());
				if(c.getMethods()[p].getName().equals(aMethod))
					pos = p;
			}
			Method m = c.getDeclaredMethods()[pos];
			if (!m.getName().equals(aMethod)){
				System.err.println("no se encontro el metodo a invocar");
				return null;
			}
			return m.invoke(service);
		 }
}
