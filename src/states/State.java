package states;

import java.util.ArrayList;
import java.util.List;

public class State {

	private List<String> facts;
	
	public State(){
		facts = new ArrayList<String>();
	}
	
	public List getFacts(){
		return facts;
	}
	
	public void addFact(String s){
		facts.add(s);
	}
	
	public void addFacts(List<String> ls){
		facts.addAll(ls);
	}
	
	public State (String in){
		facts = new ArrayList<String>();
		String aux = in.replaceAll(" ", "");
		String rec = "";
		for(int i = 0; i<aux.length(); i++){
			rec += aux.substring(i, i+1);
			if(aux.substring(i, i+1).equals(")")){
				facts.add(rec);
				rec = "";
				i++;
			}
		}
	}
	
	public List<String> getVars(int pos){
		String[] vars = facts.get(pos).split(",");
		ArrayList<String> ret = new ArrayList<String>();
		for(String s : vars)
			ret.add(s);
		return ret;
	}
}
