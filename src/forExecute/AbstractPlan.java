package forExecute;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPlan {
	
	protected HashMap<String, String> inputs;
	protected HashMap<String, String> outputs;

	public abstract HashMap<String, String> execute();
}
