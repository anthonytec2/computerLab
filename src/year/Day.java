/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package year;
//IMPORTS ALL NECESSARY imports
import java.net.*;
import java.io.*;
import java.util.Date;
import javax.swing.text.Document;
import javax.swing.text.html.parser.Parser;
import org.jsoup.Jsoup; //HTML TO TEXT CONVERTER
import org.w3c.dom.NodeList;
//Figures out odd or even day
public class Day {


    //Gets data for specfied month and year of url
    public String getData(int month,int year) throws IOException{
    	//LOGS onto the commack website calendar with specfied month and year
        URL oracle = new URL("http://www.commackcalendar.org/calendar_events.cfm?ListEvents=1&printpage=0&&cat=6633,2994,2748,2991&location=1081&dir=&themonth="+month+"&theyear="+year+"&buildit=0.961211055903&AddSportingEvents=0");
        //CReates a buffered reader in order to read line by line the HTML file result
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        //Creates two strings in order to write and return data
        String as = "";
        String aux = "";
        //Writes String to as and aux keeps adding more to as until the text is finished
        while ((aux =in.readLine()) != null) {
                as += "\n"+aux;
              }

        in.close();//closes buffered reader
      return as;//returns full text result of the html file
    }
    
    
    
    
    
    
    //HTML to text
    public String parseUrl(String html){
        //Additonal library location 12
        String z=Jsoup.parse(html).text();//Converts HTML input into Text 
   
    	return z;//returns text
    }
    
    
    
    
    
    //Trims the header of text
    public String trims(String text){
    	String s=text.substring(442);//Trims the header of the commack data file to make is a process with less time
    	return s;// returns the results of the trim
    }
    
    
    
    
    
    public String day(String text,int day,int month,int year ){
		//Non working for events that come after date
    	if(month==7||month==8){ //Checks if it is the summer if it is then 
    		return "No School"; //no school is returned and the method is complete

    	}
    	if(text.indexOf(this.month(month)+" "+day+", "+year+" SCHOOL CLOSED")!=-1){//Checks if the school is closed
    		if(text.indexOf(this.month(month)+" "+day+", "+year+" SCHOOL CLOSED K-5")!=-1){ //Checks if the school is closed only for elementary intermediate schools
    			
    		}else{
    			return "No School"; //returns that school is closed
    		}
    	}
    	int x=text.indexOf(this.month(month)+" "+day+", "+year); //looks through the calendar for the date necessart to obtain
    	text=text.substring(x); // deletes all text before the date specfied from month day year
    	int o=text.indexOf(" CHS/CMS Day DAY "); // Looks for the nearest CHS CMS day
    	
		Date r=new Date(year,month,day); // creates a dates object with the paramters obtained through the method
    	@SuppressWarnings("deprecation")
		int l=r.getDay()-this.monthc(month); //Obtains the current Day of the Week
    
    	if(l==0||l==1){ // If the day is Saturday or Sunday then
    		return null; //nothing is returned meaning its a weekend
    	}else{
    	
    	return text.substring(o+17,o+18);// returns the day 1,2,3,4,5,6
    	}
    }
    
	
	

	public String month(int month){//Changes number month to day month
		String months="";
                //Based on which month it is the correct string month is chosen
		 switch (month) {
        case 1:  months = "Jan"; 
                 break;
        case 2:  months = "Feb";
                 break;
        case 3:  months = "Mar";
                 break;
        case 4:  months = "Apr";
                 break;
        case 5:  months = "May";
                 break;
        case 6:  months = "Jun";
                 break;
        case 7:  months = "Jul";
                 break;
        case 8:  months = "Aug";
                 break;
        case 9:  months = "Sep";
                 break;
        case 10: months = "Oct";
                 break;
        case 11: months = "Nov";
                 break;
        case 12: months = "Dec";
                 break;
    }
		
		return months;//returns string month
	}
    //The user method the runs all of the processes in order to find out if its an even or odd day
    public String evenorOdd(int day, int year, int month) throws IOException{
    	
    	String s=this.getData(month, year); //Gets the HTML file of the month and year neccessary
    	s=this.parseUrl(s);//HTML>>>>TEXT
    	s=this.trims(s);//Trims the header off file
        
        try{
            int y=Integer.parseInt(this.day(s, day, month, year));
            return  String.valueOf(y);
        }catch(NumberFormatException e){
            return "No School";
        }
    	// Gets whethers its an even or odd day
    	
        
        
    	
    }
    //Special method in order to shift the Day of the week method to work
    public int monthc(int month){
    	int months=0;
        //Based on the starting day of the month, months must be shifted in order to obtain the correct Day of the Week
    	switch (month){
		case 1:  months = 3;//-3 DONE
        	break;
		case 2:  months = 0;//0 DONE
        	break;
		case 3:  months = 3;//-3 DONE
			break;
		case 4:  months = 2;//-2 DONE
        	break;
		case 5:  months = 3;//-3 DONE
			break;
		case 6:  months = 2;//-2 DONE
        	break;
		case 7:  months = 0;
        	break;
		case 8:  months = 0;
        	break;
		case 9:  months = 2;//-2 DONE
        	break;
		case 10: months = 3;//-3
        	break;
		case 11: months =2;//-2 DONE
			break;
		case 12: months = 3;//-3
        	break;
		
		
	}
		return months;//returns shift
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
   }


