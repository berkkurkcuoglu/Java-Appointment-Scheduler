public class MonthlyTester{

	public static void main(String[] args){
	
		Monthly month=new Monthly(20,12,2014,"final",1);
		System.out.println("Expected : final");
		if(month.occursOn(2014,12,20))
			System.out.println("Result: " + month.desc );
			
	}
	
}