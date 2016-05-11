package forExecute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestService extends AbstractService{
	
	private String urlBase;
	private List<String> paramsOrder;
	private HashMap<String, String> params;
	
	public RestService(){
		this.params = new HashMap<String, String>();
		this.paramsOrder = new ArrayList<String>();
	}
	
	public RestService(String url){
		this.urlBase = url;
		this.params = new HashMap<String, String>();
		this.paramsOrder = new ArrayList<String>();
	}

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String url) {
		this.urlBase = url;
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
	
	public List<String> getParamsOrder() {
		return paramsOrder;
	}

	public void setParamsOrder(List<String> paramsOrder) {
		this.paramsOrder = paramsOrder;
	}

	public String execute(){
		try {
			for(String param : this.paramsOrder){
				this.urlBase += param + "=" + this.params.get(param) + "&";
			}
			URL urlConnect = new URL(this.urlBase);
			HttpURLConnection conn = (HttpURLConnection) urlConnect.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
			return output;

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		return null;
	}
	
}
