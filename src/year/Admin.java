
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package year;
//IMPORTS
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author abisulco
 */
//Admin is a class that extends user having all the same methods as user except they can book over any teacher
public class Admin extends User {
    //Method add overides the add found in user and allows a admin to book over a teach
     public void add(int year,int month,int day, int cl, int per, String teacherName) throws FileNotFoundException, IOException{

        
        Calendar caq=Calendar.getInstance(); //creates a calendar object for the current date
	caq.set(year, month-1, day); //creates a calendar object with the paramter specfied above
	int dates=caq.get(Calendar.DAY_OF_YEAR); //Gets the day of year
        bookings[cl][per][dates]=teacherName; //Stores in the array the admin username
        this.setNum(1);  //Sends a response saying the event has been booked
	
        
      
        
    }
}
