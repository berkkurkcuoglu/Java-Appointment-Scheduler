import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
/**
 * Gui Scheduler
 * CS140 B1 Project 4
 * @author Berk Kurkcuoglu
 *
 */
public class Scheduler {
	JFrame frame = new JFrame("Scheduler"); // creating frame
	
	JPanel panelController = new JPanel(); // creating panels
	JPanel menu = new JPanel();
	JPanel addPanel = new JPanel();
	JPanel addOnetime = new JPanel();
	JPanel addDaily = new JPanel();
	JPanel addMonthly = new JPanel();
	JPanel delPanel = new JPanel();
	JPanel dayPanel = new JPanel();
	JPanel allPanel = new JPanel();
	JPanel howtoPanel = new JPanel();
	
	JButton addButton = new JButton("Add");	// creating buttons
	JButton onetimeButton = new JButton("Onetime");
	JButton dailyButton= new JButton("Daily");
	JButton monthlyButton = new JButton("Monthly");	
	JButton delButton = new JButton("Delete");
	JButton dayButton = new JButton("See day");
	JButton allButton = new JButton("See all");
	JButton loadButton = new JButton("Load");
	JButton saveButton = new JButton("Save");
	JButton homeButton = new JButton("Home");
	JButton homeButton2 = new JButton("Home");
	JButton homeButton3 = new JButton("Home");
	JButton homeButton4 = new JButton("Home");
	JButton homeButton5 = new JButton("Home");
	JButton homeButton6 = new JButton("Home");
	JButton homeButton7 = new JButton("Home");
	JButton homeButton8 = new JButton("Home");
	JButton submitButton = new JButton("Submit");
	JButton submitButton2 = new JButton("Submit");
	JButton submitButton3 = new JButton("Submit");
	JButton submitButton4 = new JButton("Submit");	
	JButton submitButton5 = new JButton("Submit");
	JButton backButton1 = new JButton("Back");
	JButton backButton2 = new JButton("Back");
	JButton backButton3 = new JButton("Back");
	JButton howtoButton= new JButton("How it works?");
	
	
	JLabel dayLabel=new JLabel("Day:");	 // creating labels
	JLabel dayLabel2=new JLabel("Day:");	
	JLabel dayLabel3=new JLabel("Day:");
	JLabel monthLabel=new JLabel("Month:");
	JLabel monthLabel2=new JLabel("Month:");
	JLabel yearLabel=new JLabel("Year:");
	JLabel yearLabel2=new JLabel("Year:");
	JLabel descLabel=new JLabel("Description:");
	JLabel descLabel2=new JLabel("Description:");
	JLabel descLabel3=new JLabel("Description:");
	JLabel delnum= new JLabel("Enter number to delete");
	
	
	JTextField fieldDesc=new JTextField(10); // creating text fields and areas
	JTextField fieldDesc2=new JTextField(10);
	JTextField fieldDesc3=new JTextField(10);
	JTextArea area1=new JTextArea(30,30);	
	JTextArea area2=new JTextArea(30,30);	
	JTextArea area3=new JTextArea(30,30);
	JTextArea area4=new JTextArea(20,45);	
	JScrollPane scrollPane = new JScrollPane(area1); // adding areas to scroll panes
	JScrollPane scrollPane2 = new JScrollPane(area2);
	JScrollPane scrollPane3 = new JScrollPane(area3);
	JScrollPane scrollPane4 = new JScrollPane(area4);	
	JTextField dell=new JTextField(2);
	
	Integer[] days=new Integer[31]; 	// creating arrays that will be used in combo boxes
	Integer[] months=new  Integer[12];
	Integer[] years=new Integer[300];	
	JComboBox dayCombo;   // creating combo boxes
	JComboBox dayCombo2;
	JComboBox monthCombo;
	JComboBox yearCombo;
	JComboBox dayseeCombo;
	JComboBox monthseeCombo;
	JComboBox yearseeCombo;
	
	
	CardLayout cl = new CardLayout(); // creating card layout
	
	private Font font = new Font("Milford",Font.BOLD,14);  // creating default fonts
	private Font fieldfont = new Font("Milford",Font.BOLD,22);
	
	static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	int d,m,y;
	String de;

/** 
 * constructor having all Panels with their buttons and actionlisteners
 */
 public Scheduler() {
	 panelController.setLayout(cl);	 // setting layout as Card Layout		
	 fieldDesc.setFont(fieldfont);
	 fieldDesc2.setFont(fieldfont);
	 fieldDesc3.setFont(fieldfont);
	 area1.setFont(fieldfont);
	 area2.setFont(fieldfont);
	 area3.setFont(fieldfont);
	 area4.setFont(fieldfont);
	 dell.setFont(fieldfont);
	 area1.setEditable(false); // setting text areas not editable
	 area2.setEditable(false);
	 area3.setEditable(false);
	 area4.setEditable(false);	
	 scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // setting scrollbars always visible
	 scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 scrollPane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 dayLabel.setForeground(Color.WHITE);	// setting text colors and fonts
	 dayLabel.setFont(font);
	 dayLabel2.setForeground(Color.WHITE);
	 dayLabel2.setFont(font);
	 dayLabel3.setForeground(Color.WHITE);
	 dayLabel3.setFont(font);
	 monthLabel.setForeground(Color.WHITE);
	 monthLabel.setFont(font);
	 monthLabel2.setForeground(Color.WHITE);
	 monthLabel2.setFont(font);
	 yearLabel.setForeground(Color.WHITE);
	 yearLabel.setFont(font);
	 yearLabel2.setForeground(Color.WHITE);
	 yearLabel2.setFont(font);
	 descLabel.setForeground(Color.WHITE);
	 descLabel.setFont(font);
	 descLabel2.setForeground(Color.WHITE);
	 descLabel2.setFont(font);
	 descLabel3.setForeground(Color.WHITE);
	 descLabel3.setFont(font);
	 delnum.setForeground(Color.WHITE);
	 delnum.setFont(font);
	 addButton.setFont(font);
	 onetimeButton.setFont(font);
	 dailyButton.setFont(font);
	 monthlyButton.setFont(font);
	 delButton.setFont(font);
	 dayButton.setFont(font);
	 allButton.setFont(font);
	 loadButton.setFont(font);
	 saveButton.setFont(font);
	 homeButton.setFont(font);
	 homeButton2.setFont(font);
	 homeButton3.setFont(font);
	 homeButton4.setFont(font);
	 homeButton5.setFont(font);
	 homeButton6.setFont(font);
	 homeButton7.setFont(font);
	 submitButton.setFont(font);
	 submitButton2.setFont(font);
	 submitButton3.setFont(font);
	 submitButton4.setFont(font);
	 submitButton5.setFont(font);
	 backButton1.setFont(font);
	 backButton2.setFont(font);
	 backButton3.setFont(font);
	 howtoButton.setFont(font);
	 
	 for(int i=0;i<31;i++)    // initializing days array
			days[i]=i+1;
	 dayCombo=new JComboBox(days); // initializing day combo boxes	 
	 dayCombo2=new JComboBox(days);
	 dayseeCombo=new JComboBox(days);	 
	 for(int i=0;i<12;i++) 			// initializing months array
			months[i]=i+1;
	 monthCombo=new JComboBox(months); // initializing month combo boxes
	 monthseeCombo=new JComboBox(months);
	 for(int i=0;i<300;i++)		// initializing years array
			years[i]=i+1900;
	 yearCombo=new JComboBox(years); // initializing year combo boxes
	 yearseeCombo=new JComboBox(years);
	 yearCombo.setSelectedIndex(114);
	 yearseeCombo.setSelectedIndex(114);
	
	 
	 menu.add(addButton); // adding buttons to home page(panel)
	 menu.add(addButton);
	 menu.add(delButton);
	 menu.add(dayButton);
	 menu.add(allButton);
	 menu.add(loadButton);
	 menu.add(saveButton);
	 menu.add(howtoButton);	 
	 
	 addPanel.add(homeButton);	// adding buttons to add panel
	 addPanel.add(onetimeButton);	 
	 addPanel.add(monthlyButton);
	 addPanel.add(dailyButton);
	 
	 addOnetime.add(homeButton5);	// adding buttons,fields and labels to one time adding panel
	 addOnetime.add(dayLabel);	
	 addOnetime.add(dayCombo);
	 addOnetime.add(monthLabel);	
	 addOnetime.add(monthCombo);
	 addOnetime.add(yearLabel);	
	 addOnetime.add(yearCombo);
	 addOnetime.add(descLabel);
	 addOnetime.add(fieldDesc);
	 addOnetime.add(submitButton);
	 addOnetime.add(backButton1);	  
	 
	 addDaily.add(homeButton6);			// adding buttons,fields and labels to daily appointment adding panel
	 addDaily.add(descLabel2);
	 addDaily.add(fieldDesc2);
	 addDaily.add(submitButton2);
	 addDaily.add(backButton2);
	 
	 addMonthly.add(homeButton7);	 // adding buttons,fields and labels to monthly adding panel
	 addMonthly.add(dayLabel2);
	 addMonthly.add(dayCombo2);
	 addMonthly.add(descLabel3);
	 addMonthly.add(fieldDesc3);
	 addMonthly.add(submitButton3);
	 addMonthly.add(backButton3);
	 
	 delPanel.add(homeButton2);	// adding scrollpane,buttons and textfields to deleting panel
	 delPanel.add(scrollPane);
	 delPanel.add(delnum);
	 delPanel.add(dell);
	 delPanel.add(submitButton4);
	 
	 dayPanel.add(homeButton3); // adding scrollpane,buttons and textfields to see day panel
	 dayPanel.add(dayLabel3);
	 dayPanel.add(dayseeCombo);
	 dayPanel.add(monthLabel2);
	 dayPanel.add(monthseeCombo);
	 dayPanel.add(yearLabel2);
	 dayPanel.add(yearseeCombo);
	 dayPanel.add(submitButton5);
	 dayPanel.add(scrollPane2);	
	 
	 allPanel.add(homeButton4); // adding home button and scrollpane to see all panel
	 allPanel.add(scrollPane3);
	 
	 howtoPanel.add(homeButton8);	// adding home button and scrollpane to how it works panel
	 howtoPanel.add(scrollPane4);
	
	 
	 menu.setBackground(new Color(120,150,180)); // setting backgrounds to a custom color 
	 addPanel.setBackground(new Color(120,150,180));
	 addOnetime.setBackground(new Color(120,150,180));
	 addDaily.setBackground(new Color(120,150,180));
	 addMonthly.setBackground(new Color(120,150,180));	 
	 delPanel.setBackground(new Color(120,150,180));
	 dayPanel.setBackground(new Color(120,150,180));
	 allPanel.setBackground(new Color(120,150,180));
	 howtoPanel.setBackground(new Color(120,150,180));
	 panelController.add(menu, "1"); // adding other panels to controller panel and name them as increasing numbers
	 panelController.add(addPanel, "2");
	 panelController.add(delPanel, "3");
	 panelController.add(dayPanel, "4");
	 panelController.add(allPanel, "5");
	 panelController.add(addOnetime, "6");
	 panelController.add(addDaily, "7");
	 panelController.add(addMonthly, "8");
	 panelController.add(howtoPanel, "9");
	 cl.show(panelController, "1");
	 
	 homeButton.addActionListener(new ActionListener() { // home button that shows home panel when clicked
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
		 }
	 });
	 homeButton2.addActionListener(new ActionListener() { // home button that shows home panel when clicked and emptying the text area 1
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
			 area1.setText("");
			 dell.setText("");
		 }
	 });
	 homeButton3.addActionListener(new ActionListener() { // home button that shows home panel when clicked and emptying text area 2 and fields at one time appointment adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
			 area2.setText("");
			 dayseeCombo.setSelectedIndex(0);
			 monthseeCombo.setSelectedIndex(0);
			 yearseeCombo.setSelectedIndex(114);
		 }
	 });
	 homeButton4.addActionListener(new ActionListener() { // home button that shows home panel when clicked and emptying text area 3
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
			 area3.setText("");
		 }
	 });
	 homeButton5.addActionListener(new ActionListener() { // home button that shows home panel when clicked
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
			 dayCombo.setSelectedIndex(0);
			 monthCombo.setSelectedIndex(0);
			 yearCombo.setSelectedIndex(114);
		 }
	 });
	 homeButton6.addActionListener(new ActionListener() { // home button that shows home panel when clicked
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
		 }
	 });
	 homeButton7.addActionListener(new ActionListener() { // home button that shows home panel when clicked
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
			 dayCombo2.setSelectedIndex(0);
		 }
	 });
	 homeButton8.addActionListener(new ActionListener() { // home button that shows home panel when clicked
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "1");
		 }
	 });
	 addButton.addActionListener(new ActionListener() { // shows adding panel when clicked
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "2");
			 
		 }
	 });
	 delButton.addActionListener(new ActionListener() { // shows deleting panel when clicked and fills textarea with existing appointments to let the user select the one to delete
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "3");
			
			 for(Appointment app:appointments){
				 if(app.type.equals("One Time"))			 
					 area1.append(((appointments.indexOf(app))+1)+": " +app.day + "/" + app.month + "/" + app.year + " ==> " +app.desc + "   --> " + app.type + "\n");
				 else if(app.type.equals("Monthly"))
					 area1.append(((appointments.indexOf(app))+1)+": " +app.day + " ==> " +app.desc + "   --> " + app.type+ "\n");
				 else if(app.type.equals("Daily"))
					 area1.append(((appointments.indexOf(app))+1)+": " +app.desc + "   --> " + app.type+ "\n");
			 }
		 }
	 });
	 dayButton.addActionListener(new ActionListener() { // shows see appointments for a specific day panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "4");
			
			 			 
		 }
	 });
	 allButton.addActionListener(new ActionListener() { // shows all appointments panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "5");
				
			 for(Appointment app:appointments){
				 if(app.type.equals("One Time"))			 
					 area3.append(((appointments.indexOf(app))+1)+": " +app.day + "/" + app.month + "/" + app.year + " ==> " +app.desc + "   --> " + app.type + "\n");
				 else if(app.type.equals("Monthly"))
					 area3.append(((appointments.indexOf(app))+1)+": " +app.day + " ==> " +app.desc + "   --> " + app.type+ "\n");
				 else if(app.type.equals("Daily"))
					 area3.append(((appointments.indexOf(app))+1)+": " +app.desc + "   --> " + app.type+ "\n");
			 }
			
		 }
	 });
	 onetimeButton.addActionListener(new ActionListener() { // shows one time appointment adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "6");
		 }
	 });
	 dailyButton.addActionListener(new ActionListener() { // shows daily appointment adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "7");
		 }
	 });
	 monthlyButton.addActionListener(new ActionListener() { // shows monthly appointment adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "8");
		 }
	 });
	 submitButton.addActionListener(new ActionListener() { // one time appointment adding button, sets fields empty at the end
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			if(!fieldDesc.getText().isEmpty()){ // checks if field is empty
				
				d=Integer.parseInt(dayCombo.getSelectedItem().toString());									
				m=Integer.parseInt(monthCombo.getSelectedItem().toString());		
				y=Integer.parseInt(yearCombo.getSelectedItem().toString());			
				de=fieldDesc.getText();		
				
				appointments.add(new Onetime(d,m,y,de,0)); // adds new one time appointment to the arraylist and prints success message		
				JOptionPane.showMessageDialog(null,"Appointment '"+de + "' was succesfully added to your schedule.","Success",JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null,"Please enter a description!","Error!",JOptionPane.ERROR_MESSAGE);			
			yearCombo.setSelectedIndex(114);
			fieldDesc.setText("");// set text fields to empty  after action is performed
		 }
	 });
	 submitButton2.addActionListener(new ActionListener() { // daily adding button,sets fields empty at the end
		 @Override
		 public void actionPerformed(ActionEvent arg0) {	
			 if(!fieldDesc2.getText().isEmpty()){  // checks if there is a description available.
				 de=fieldDesc2.getText();
				 appointments.add(new Daily(0,0,0,de,2));	// adds new daily appointment to the arraylist and prints success message
				 JOptionPane.showMessageDialog(null,"Appointment '"+de + "' was succesfully added to your schedule.","Success",JOptionPane.INFORMATION_MESSAGE);
			 }
			 else
				 JOptionPane.showMessageDialog(null,"Please enter valid inputs!!!\nExample: Project due date.","Error!",JOptionPane.ERROR_MESSAGE);
			fieldDesc2.setText("");
		 }
	 });
	 submitButton3.addActionListener(new ActionListener() { // monthly appointment adding button, sets fields empty when finished
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 if(!fieldDesc3.getText().isEmpty()){ // checks if there is an input in the field		 
				 d=Integer.parseInt(dayCombo.getSelectedItem().toString());					
				 de=fieldDesc3.getText();				
				appointments.add(new Monthly(d,0,0,de,1));	// adds monthly appointment to arraylist and shows success message.		
				JOptionPane.showMessageDialog(null,"Appointment '"+de + "' was succesfully added to your schedule.","Success",JOptionPane.INFORMATION_MESSAGE);
			 }
			 else
				 JOptionPane.showMessageDialog(null,"Please enter a description!","Error!",JOptionPane.ERROR_MESSAGE);
			fieldDesc3.setText("");
		 }
	 });
	 submitButton4.addActionListener(new ActionListener() { // appointment deleting button
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 if(appointments.size()==0){ // checks if the arraylist is empty, if it is shows warning
				 JOptionPane.showMessageDialog(null,"No appointments available!","Warning",JOptionPane.WARNING_MESSAGE);	
				 return;
			 }
			 area1.setText("");
			 int numdel=0;
			 if(!dell.getText().isEmpty()) // checks if the field is empty
				 try{ numdel= Integer.parseInt(dell.getText());	} // checks if the input is an integer otherwise shows error message
			 catch(NumberFormatException ex){
				 JOptionPane.showMessageDialog(null,"Enter a valid number!","Error!",JOptionPane.ERROR_MESSAGE);	
				 for(Appointment app:appointments){
					 if(app.type.equals("One Time"))			 
						 area1.append(((appointments.indexOf(app))+1)+": " +app.day + "/" + app.month + "/" + app.year + " ==> " +app.desc + "   --> " + app.type + "\n");
					 else if(app.type.equals("Monthly"))
						 area1.append(((appointments.indexOf(app))+1)+": " +app.day + " ==> " +app.desc + "   --> " + app.type+ "\n");
					 else if(app.type.equals("Daily"))
						 area1.append(((appointments.indexOf(app))+1)+": " +app.desc + "   --> " + app.type+ "\n");
				 }
				 dell.setText("");
				 return;
			 }
			 if(numdel> appointments.size() || numdel==0){ // checks if number entered is existing in the arraylist or a valid number is entered,otherwise shows error message and prints schedule again
				 JOptionPane.showMessageDialog(null,"Enter a valid number!","Error!",JOptionPane.ERROR_MESSAGE);	
				 for(Appointment app:appointments){
					 if(app.type.equals("One Time"))			 
						 area1.append(((appointments.indexOf(app))+1)+": " +app.day + "/" + app.month + "/" + app.year + " ==> " +app.desc + "   --> " + app.type + "\n");
					 else if(app.type.equals("Monthly"))
						 area1.append(((appointments.indexOf(app))+1)+": " +app.day + " ==> " +app.desc + "   --> " + app.type+ "\n");
					 else if(app.type.equals("Daily"))
						 area1.append(((appointments.indexOf(app))+1)+": " +app.desc + "   --> " + app.type+ "\n");
				 }
				 dell.setText("");
				 return;
			 }
			 if(numdel!=0){ // if everything is ok, deletes the selected appointment and shows success message.
				 JOptionPane.showMessageDialog(null,"Appointment '"+appointments.get(numdel-1).desc + "' was succesfully deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
				 appointments.remove(numdel-1);
			 }
			 for(Appointment app:appointments){ // // fills text area with a list of appointments
				 if(app.type.equals("One Time"))			 
					 area1.append(((appointments.indexOf(app))+1)+": " +app.day + "/" + app.month + "/" + app.year + " ==> " +app.desc + "   --> " + app.type + "\n");
				 else if(app.type.equals("Monthly"))
					 area1.append(((appointments.indexOf(app))+1)+": " +app.day + " ==> " +app.desc  + "   --> " + app.type+ "\n");
				 else if(app.type.equals("Daily"))
					 area1.append(((appointments.indexOf(app))+1)+": " +app.desc  + "   --> " + app.type+ "\n");
			 }
			 
			 dell.setText("");
		 }
	 });
	 submitButton5.addActionListener(new ActionListener() { // see appointments for a day button, sets text fields empty at the end
		 @Override
		 public void actionPerformed(ActionEvent arg0) {	
			 area2.setText("");
			 yearseeCombo.setSelectedIndex(114); // resetting year combobox index
			 d=Integer.parseInt(dayseeCombo.getSelectedItem().toString());		// getting day, month and year from combo boxes		
			 m=Integer.parseInt(monthseeCombo.getSelectedItem().toString());				
			 y=Integer.parseInt(yearseeCombo.getSelectedItem().toString());					
			
			 int counter=0;
			 for(Appointment app:appointments) // goes through the arraylist and adds description of the appointments which are going to happen on the desired date
				 if(app.occursOn(y,m,d))					 				 
						area2.append(++counter + ":" + app.desc + "\n");
			 if(counter==0) // if no appointments are available for that day, fills text area with bo appointments message.
				 area2.setText("You have no appointments for the selected day.");		 
		}
	 });
	 backButton1.addActionListener(new ActionListener() { // shows adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "2");
			 dayCombo.setSelectedIndex(0);
			 monthCombo.setSelectedIndex(0);
			 yearCombo.setSelectedIndex(114);
		 }
	 });
	 backButton2.addActionListener(new ActionListener() { // shows adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "2");
		 }
	 });
	 backButton3.addActionListener(new ActionListener() { // shows adding panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "2");
			 dayCombo2.setSelectedIndex(0);
		 }
	 });
	 loadButton.addActionListener(new ActionListener() { // load button --> adds serialized data to the existing arraylist
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 try{ // uploading one time appointments from Schedule.ser to the ArrayList,shows success message if works,error message otherwise.
					FileInputStream fileIn = new FileInputStream("Schedule.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					while(fileIn.available()>0){
						Appointment apo=(Appointment) in.readObject();
						int counter=0;
						for(Appointment ap:appointments)
							if(ap.desc.equals(apo.desc) && ap.type.equals(apo.type)) // if the appointment already exist, it doesn't add it to  the arraylist
								counter++;
						if(counter==0)
							appointments.add(apo);
					}
					in.close();
					fileIn.close();
					 JOptionPane.showMessageDialog(null,"Your schedule has been loaded.","Notification",JOptionPane.INFORMATION_MESSAGE);	
				}
				catch(IOException i)
				{	
					JOptionPane.showMessageDialog(null,"Schedule.ser not found!","Error!",JOptionPane.ERROR_MESSAGE);
					i.printStackTrace();
					return;
				}
				catch(ClassNotFoundException c)
				{
					 JOptionPane.showMessageDialog(null,"Appointment class not found!","Error!",JOptionPane.ERROR_MESSAGE);	
					 c.printStackTrace();
					 return;
				}	
		 }
	 });
	 saveButton.addActionListener(new ActionListener() { // save button - saves whole arraylist in a file as objects, shows saved message if works, error message otherwise
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 try{
					FileOutputStream fileOut =new FileOutputStream("Schedule.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					
					for(Appointment ap:appointments) // write all the appointments in the serialized file.
						out.writeObject(ap);
					out.close();
					fileOut.close();
					JOptionPane.showMessageDialog(null,"Serialized data is saved in Schedule.ser.","Notification",JOptionPane.INFORMATION_MESSAGE);					
					
				}
				catch(IOException i)
				{
					 JOptionPane.showMessageDialog(null,"Serialization file can not be created!","Error!",JOptionPane.ERROR_MESSAGE);	
					i.printStackTrace();
				}
		 }
	 });
	 howtoButton.addActionListener(new ActionListener() { // how it works button-> shows how it works panel
		 @Override
		 public void actionPerformed(ActionEvent arg0) {
			 cl.show(panelController, "9");			
			 area4.setText("- You can add 3 different types of appointments from the add section.\n      1) Onetime: It occurs only on the date given.\n"
			 		+ "      2) Monthly: It occurs on the same day of every month unless deleted.\n"
			 		+ "      3) Daily: It occurs on every day unless deleted.\n" 
			 		+ "\n- You can delete appointments from your schedule by typing their numbers.\n"
			 		+ "\n- You can see your schedule for a certain day from the see day section.\n"
			 		+ "\n- You can see all your scheduled appointments from see all section.\n"
			 		+ "\n- You can save your schedule and reload it later.\n" ); // filling text area with information
			 		
		 }
	 });
	 frame.add(panelController); // adding panel controller to the frame
	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // setting closing type
	 frame.pack();
	 frame.setVisible(true); // setting frame visible
 }
 /**
  * main method to run a new Scheduler
  * @param args default String for main method
  */
 public static void main(String[] args) {
	 SwingUtilities.invokeLater(new Runnable() {
		 @Override
		 public void run() {  // creates new Scheduler object with everything attached to it's constructor.
			 new Scheduler();
		 }
	 });
	 
		appointments.add(new Onetime(12,9,2014,"Birthday",0)); // adding 2 one time appointments to the arraylist upon starting
		appointments.add(new Onetime(21,10,2014,"Project due date",0));
 }
}