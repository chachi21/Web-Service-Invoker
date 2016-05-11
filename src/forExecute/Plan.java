package forExecute;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Plan extends AbstractPlan {

	private List<String> actions;
	private HashMap<String, Action> services;
	
	public Plan(List<String> actions, HashMap<String, Action> services, HashMap<String, String> inputs, HashMap<String, String> outputs){
		this.actions = actions;
		this.services = services;
		this.initialState = inputs;
		this.finalState = outputs;
	}
	
	public String execute() {
		HashMap<String, String> partialResult = new HashMap<String, String>();
		partialResult.putAll(this.initialState);
		Set<String> servicesSet = services.keySet();
		String result = "";
		for(String actionName: actions){
			for(String name : servicesSet)
				if(actionName.contains(name)){
					Action action = services.get(name);
					action.setInitialState(partialResult);
					result+=action.execute();
					//partialResult.putAll(serv.execute(partialResult));
				}
		}
		
		return result;
	}

}
