/** A subclass of appointment class that passes its variables to super constructor and has occursOn method.
*/
public class Monthly extends Appointment implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/** Default constructor without any parameters referring to super constructor.*/
	public Monthly(){
		super();
	}
/** A constructor that passes its parameters to super constructor. */
	public Monthly(int d,int m,int y,String de,int i){
		super(d,m,y,de,i);
	}
/** A method to check if there is an appointment on a certain date and overrides the original occursOn.
*@param y stands for year and it's an input from the user entered during the main program.
*@param m stands for month and it's an input from the user entered during the main program.
*@param d stands for day and it's an input from the user entered during the main program.
*@return This method returns true or false by checking if the day entered is same with an existing appointment.
*/
	boolean occursOn(int y,int m,int d){
		if(day==d)
			return true;
		else
			return false;
	}


}