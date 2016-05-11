package forExecute;

import java.util.HashMap;
import java.util.List;

public class Action extends AbstractPlan {
	
	private RestService rServ;
	private List<String> paramsOrder;
	
	public Action(HashMap<String, String> inputs, RestService service){
		this.initialState = inputs;
		this.finalState = new HashMap<String, String>();
		this.rServ = service;
	}
	
	public List<String> getParamsOrder() {
		return paramsOrder;
	}

	public void setParamsOrder(List<String> paramsOrder) {
		this.paramsOrder = paramsOrder;
	}

	public String execute(){
		this.rServ.setParamsOrder(this.paramsOrder);
		this.rServ.setParams(this.initialState);
			
		String output = this.rServ.execute();
					
		return output;
	}

}
