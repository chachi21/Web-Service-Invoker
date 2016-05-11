import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import forExecute.AbstractPlan;
import forExecute.Plan;
import forExecute.RestService;
import forExecute.Action;

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
		HashMap<String, Action> services = new HashMap<String, Action>();
		
		
		
		// Set final state
		finalState.put("temperaturecelsius", "");
		//finalState.put("wind", "");
		
		// Define services
		inputsTemperature.put("city", null);
		inputsTemperature.put("date", null);
		//outputsTemperature.put("temperaturecelsius", "4");
		String urlTemperature = "http://localhost:8080/api/gettemperaturecelsius?";
		RestService temperatureRestService = new RestService();
		temperatureRestService.setUrlBase(urlTemperature);
		Action temperatureAction = new Action(inputsTemperature, temperatureRestService);
		ArrayList<String> paramsOrder = new ArrayList<>();
		paramsOrder.add("city");
		paramsOrder.add("date");
		temperatureAction.setParamsOrder(paramsOrder);
		services.put("gettemperaturecelsius", temperatureAction);
		
		/*inputsWind.put("cityzip", null);
		inputsWind.put("datenormal", null);
		outputsWind.put("wind", "3");
		Action windService = new Action(inputsWind, outputsWind);
		services.put("getwind", windService);
		
		inputsCity.put("cityname", null);
		outputsCity.put("cityzip", "7000");
		Action cityService = new Action(inputsCity, outputsCity);
		services.put("fromcitynametocityzip", cityService);*/
		
		// Define the actions of the plan
		//actions.add("fromcitynametocityzip_26");
		actions.add("gettemperaturecelsius_23");
		//actions.add("getwind_28");
		//actions.add("fromcitynametocityzip_26");
		
		initialStatePlan.put("city", "tandil");
		initialStatePlan.put("date", "11/12/2011");
		Plan p = new Plan(actions, services, initialStatePlan, finalState);
		
		System.out.println(p.execute());
	}

}
