package validatingF1ReponseData;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestClassForValidatingTestData 
{
	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20(){
		
		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
		
	}
	@Test
	public void validateStatusCode(){
		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().statusCode(200);
	}
	
	@Test
	public void validateByPassingAsParameter(){
		
		String season="2017";
		int no_of_races=20;
		given().pathParam("raceSeason", season).when().get("http://ergast.com/api/f1/{raceSeason}/circuits.json").then().assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(no_of_races));
	}
}
