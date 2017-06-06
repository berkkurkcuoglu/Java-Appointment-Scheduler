public class OnetimeTester{

	public static void main(String[] args){
	
		Onetime one=new Onetime(20,12,2014,"final",1);
		System.out.println("Expected : final");
		if(one.occursOn(2014,12,20))
			System.out.println("Result: " + one.desc );
			
	}
	
}