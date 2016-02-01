

import java.util.HashMap;

import javax.xml.ws.Service;

import utils.Invoker;

public class main {
	
	public static HashMap<String, Object> getReturnedData(String classDescription, String methodConnection, String classService, String methodToInvoke, Object[] arguments){
		try {
        	//System.out.println("obtengo el soap");
        	Class<?> a1 = Class.forName(classDescription);
        	Service serv = (Service) a1.newInstance();
        	Object r1 = Invoker.invokeService(serv, classDescription, methodConnection);
        	//System.out.println(r1.toString());
        	
        	//System.out.println("intento invocar al metodo: "+methodToInvoke);
        	HashMap<String, Object> o2 = Invoker.invokeMethod(r1, classService, methodToInvoke, arguments);
			//System.out.println("muestro el resultado");
			//System.out.println(o2.toString());
			return o2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		System.out.println("intento ejecutar los del clima");
		HashMap<String, Object> o2 = getReturnedData("weatherGet.Weather", "getWeatherSoap", "weatherGet.WeatherSoap", "getCityWeatherByZIP", new Object[]{new String("10007")});
		System.out.println("salida: "+o2);
		
		System.out.println("intento ejecutarlo la conversion de farenheit a celsius");
		Object o = getReturnedData("tempConverter.TempConvert", "getTempConvertSoap", "tempConverter.TempConvertSoap", "fahrenheitToCelsius", new Object[]{o2.get("Temperature")});
		System.out.println("salida: "+o.toString());
		
    }
}
