package ergast_API_Test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import ergast_API_supporting_method.stringtojpath;

public class getdriverlist {
	
	private static final Logger logger = LogManager.getLogger(getdriverlist.class);
@Test

public void getdriverdetails() throws IOException {
	
		logger.trace("Entering application SepaPayments.");
		// logger.error("Didn't do it.");
		 //logger.trace("Exiting application.");
		
		Properties prop=new Properties(); 
		


FileInputStream f1= new FileInputStream("C:\\Users\\Suchita\\eclipse-workspace\\sep_mvn_project\\src\\test\\resources\\env.properties");
prop.load(f1);
RestAssured.baseURI=prop.getProperty("HOST");

Response r=given().when().get("/drivers.json").then().assertThat().statusCode(200).extract().response();

JsonPath s2=stringtojpath.m1(r);

int i=s2.get("MRData.DriverTable.Drivers.size()");
System.out.println(i);

for(int j=0;j<i;j++)
	
{
	int k=j+1;
	logger.info("Driver No is="+k);
	String s11="MRData.DriverTable.Drivers[";
String j1=s2.get(s11+j+"].driverId");
String j2=s2.get(s11+j+"].givenName");
String j3=s2.get(s11+j+"].familyName");
String j4=s2.get(s11+j+"].dateOfBirth");
System.out.println("driver id="+j1+"\n"+"given name="+j2+"\n"+"family name="+j3+"\n"+"dateofbirth="+j4);
	}}

	
}
