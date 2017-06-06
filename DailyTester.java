public class DailyTester{

	public static void main(String[] args){
	
		Daily day=new Daily(20,12,2014,"final",2);
		System.out.println("Expected : final");
		if(day.occursOn(20,12,2014))
			System.out.println("Result: " + day.desc );
			
	}
	
}