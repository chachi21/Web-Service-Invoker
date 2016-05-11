package forExecute;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPlan {
	
	protected HashMap<String, String> initialState;
	protected HashMap<String, String> finalState;

	public abstract String execute();

	public HashMap<String, String> getInitialState() {
		return initialState;
	}

	public void setInitialState(HashMap<String, String> initialState) {
		this.initialState = initialState;
	}

	public HashMap<String, String> getFinalState() {
		return finalState;
	}

	public void setFinalState(HashMap<String, String> finalState) {
		this.finalState = finalState;
	}
}
