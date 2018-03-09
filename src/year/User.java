
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package year;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author abisulco
 */
public class User {
    //ARRAY USE LOCATION 1
    public static String[][][] bookings= new String[7][9][364];
    private static int p;
    private String teacher;
    private String last;
    
    //User defined method paramters location 7
    public void add(int year,int month,int day, int cl, int per, String teacherName) throws FileNotFoundException, IOException{
        System.out.println(year);
         System.out.println(month);
         System.out.println(day);
         System.out.println(cl);
         System.out.println(per);
         System.out.println(teacherName);
                
        int y;
        Calendar caq=Calendar.getInstance();
	caq.set(year, month-1, day);
	int dates=caq.get(Calendar.DAY_OF_YEAR);
        int x=this.recheck(dates, cl, per);
        
        if((bookings[cl][per][dates]==null||bookings[cl][per][dates].equals(""))&&x==1){
	 //ARRAY USE LOCATION 1	
              bookings[cl][per][dates]=teacherName;
              this.setNum(1);  
	}else{
              this.setNum(0);
        }
        
      
        
    }
    
    
    
    
    
    public void setNum(int y){
        p=y;
    }
    
    
    
    
    //User defined method with return location 8
    public int getNum(){
        return p;
        
    }
    
    
    
    
    public String[][][] returnArray(){
        return bookings;
    }
    
    
    
    
    //Searching location 10
    public ArrayList<String> find(String teacherName){
        ArrayList<String> al=new ArrayList<String>();
		for(int x=0;x<7;x=x+1){
			for(int y=0;y<9;y=y+1){
			
                            for(int z=0;z<364;z=z+1){
					if(bookings[x][y][z]!=null&&bookings[x][y][z].equals(teacherName)){
						al.add(String.valueOf(x)+String.valueOf(y)+String.valueOf(z));
					}else{
						
					}
				}
			}
		}
                
                
      
        return al;
}
    
    
    
 public void delete(String teacherName, int d){
     ArrayList<String> al=this.find(teacherName);
     bookings[Integer.parseInt(al.get(d).substring(0,1))][Integer.parseInt(al.get(d).substring(1,2))][Integer.parseInt(al.get(d).substring(2))]=null;
 }   
 public void storeTeacher(String s){
     teacher=s;
 }
 //User defined method location 9
 public String getTeacher(){
     return teacher;
 }
 public void load() throws FileNotFoundException, IOException{

     FileReader j=new FileReader("r.txt");
     BufferedReader br = new BufferedReader(j); 
       for(int x=0;x<7;x=x+1){
			for(int y=0;y<9;y=y+1){
				for(int z=0;z<364;z=z+1){
					bookings[x][y][z]= br.readLine();
				}
			}
		}
       
    j.close(); 
    
     
 }
 //FIlE IO location 11
 public void write() throws IOException{
     FileWriter e=new FileWriter("r.txt");
    
       for(int x=0;x<7;x=x+1){
			for(int y=0;y<9;y=y+1){
				for(int z=0;z<364;z=z+1){
                                    if(bookings[x][y][z]==null){
                                        e.write("\n");
                                    }else{
                                        e.write(bookings[x][y][z]+"\n");
                                    }
				}
			}
		}
       
    e.close(); 
 }
 public int recheck(int day, int cl, int per) throws FileNotFoundException, IOException{
     FileReader j=new FileReader("r.txt");
     BufferedReader br = new BufferedReader(j); 
     for(int x=0;x<7;x=x+1){
			for(int y=0;y<9;y=y+1){
				for(int z=0;z<364;z=z+1){
                                    if(y==per&&x==cl&&day==z){
                                        if(br.readLine().equals(null)||br.readLine().equals("")){
                                            return 1;
                                        }else{
                                            return 0;
                                        }
                                    }
				}
			}
		}
     
 return 4;
 }
 public String returnCl(int clNum){
  if(clNum==0) { 
     
     return ". CL1";
 }else if(clNum==1){
    return ". CL2/3";
}else if(clNum==2){
    return ". CL5";
}else if(clNum==3){
    return ". CL149";
}else if(clNum==4){
    return ". CL248";
}else if(clNum==5){
    return ". CL252";
}else if(clNum==6){
    return ". CL6";
}else {
    return null;
}
}
public void storeLast(String l){
last=l;
}
public String returnLast(){
return last;
}

}
