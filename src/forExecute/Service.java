package forExecute;

import java.util.HashMap;

public class Service extends AbstractPlan {
	
	public Service(HashMap<String, String> inputs){
		this.inputs = inputs;
		this.outputs = new HashMap<String, String>();
	}
	
	public Service(HashMap<String, String> inputs, HashMap<String, String> outputs){
		this.inputs = inputs;
		this.outputs = outputs;
	}
	
	public HashMap<String, String> execute(HashMap<String, String> partialResult){
		for(String input : inputs.keySet()){
			inputs.put(input, partialResult.get(input));
			if(inputs.get(input).equals(null))
				return null;
		}
			
		return outputs;
	}
	
	public HashMap<String, String> execute() {
		for(String input : inputs.keySet())
			if(inputs.get(input).equals(null))
				return null;
		return outputs;
	}

}
