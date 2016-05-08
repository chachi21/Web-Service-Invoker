import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import forExecute.AbstractPlan;
import forExecute.Plan;
import forExecute.Service;

public class mainForExecute {

	public static void main(String[] args) {
		
		List<String> actions = new ArrayList<String>();
		
		HashMap<String, String> initialStatePlan = new HashMap<String, String>();
		
		HashMap<String, String> inputsTemperature = new HashMap<String, String>();
		HashMap<String, String> inputsWind = new HashMap<String, String>();
		HashMap<String, String> inputsCity = new HashMap<String, String>();
		
		HashMap<String, String> outputsTemperature = new HashMap<String, String>();
		HashMap<String, String> outputsWind = new HashMap<String, String>();
		HashMap<String, String> outputsCity = new HashMap<String, String>();
		
		HashMap<String, String> finalState = new HashMap<String, String>();
		HashMap<String, Service> services = new HashMap<String, Service>();
		
		
		// Set final state
		finalState.put("temperaturecelsius", "");
		finalState.put("wind", "");
		
		// Define services
		inputsTemperature.put("cityzip", null);
		inputsTemperature.put("datenormal", null);
		outputsTemperature.put("temperaturecelsius", "4");
		Service temperatureService = new Service(inputsTemperature, outputsTemperature);
		services.put("gettemperaturecelsius", temperatureService);
		
		inputsWind.put("cityzip", null);
		inputsWind.put("datenormal", null);
		outputsWind.put("wind", "3");
		Service windService = new Service(inputsWind, outputsWind);
		services.put("getwind", windService);
		
		inputsCity.put("cityname", null);
		outputsCity.put("cityzip", "7000");
		Service cityService = new Service(inputsCity, outputsCity);
		services.put("fromcitynametocityzip", cityService);
		
		// Define the actions of the plan
		actions.add("fromcitynametocityzip_26");
		actions.add("gettemperaturecelsius_23");
		actions.add("getwind_28");
		//actions.add("fromcitynametocityzip_26");
		
		initialStatePlan.put("cityname", "tandil");
		initialStatePlan.put("datenormal", "11/12/2011");
		Plan p = new Plan(actions, services, initialStatePlan, finalState);
		
		System.out.println(p.execute());
	}

}
