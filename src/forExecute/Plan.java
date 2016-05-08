package forExecute;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Plan extends AbstractPlan {

	private List<String> actions;
	private HashMap<String, Service> services;
	
	public Plan(List<String> actions, HashMap<String, Service> services, HashMap<String, String> inputs, HashMap<String, String> outputs){
		this.actions = actions;
		this.services = services;
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	public HashMap<String, String> execute() {
		HashMap<String, String> partialResult = new HashMap<String, String>();
		partialResult.putAll(inputs);
		Set<String> servicesSet = services.keySet();
		for(String action: actions){
			for(String name : servicesSet)
				if(action.contains(name)){
					Service serv = services.get(name);
					partialResult.putAll(serv.execute(partialResult));
				}
		}
		for(String out : partialResult.keySet())
			if(outputs.containsKey(out))
				outputs.put(out, partialResult.get(out));
		return this.outputs;
	}

}
