/** Appointment class with a constructor to create appointment objects with date and description.
*@author Berk Kurkcuoglu
*
*/
public class Appointment implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String desc,type;
	public int year,month,day;
	public String[] atype= {"One Time","Monthly","Daily"};
	/** Default constructor with empty strings and date set to 0. */
	public Appointment(){
		desc="";
		year=0;
		month=0;
		day=0;
		type="";
	}
	/** Appointment constructor with it's features.
	*@param d is used to determine the date
	*@param m is used to determine the month
	*@param y is used to determine the year
	*@param de is to set the description
	*/
	public Appointment(int d,int m,int y,String de,int i){
		desc=de;
		year=y;
		month=m;
		day=d;
		type=atype[i];
	}
	/** A method to check if there is an appointment on a certain date.
	*@param y stands for year and it's an input from the user entered during the main program.
	*@param m stands for month and it's an input from the user entered during the main program.
	*@param d stands for day and it's an input from the user entered during the main program.
	*@return This method returns true or false by checking if the day,month and year entered are same with an existing appointment.
	*/
	boolean occursOn(int y,int m,int d){
		if(year==y && month==m && day==d)
			return true;
		else
			return false;
	}	
		
}