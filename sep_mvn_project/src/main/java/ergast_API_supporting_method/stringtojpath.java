package ergast_API_supporting_method;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class stringtojpath {

	public static JsonPath m1(Response r) {
	String s=r.asString();
	
	JsonPath s2=new JsonPath(s);
	
	return s2;
	
	}
}
