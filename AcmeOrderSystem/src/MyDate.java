/**
 * 
 */

/**
 * @author migui
 *
 */
public class MyDate {
	int day;
	int month;
	int year;

	{
		day = 1;
		month = 1;
		year = 2000;
	}
	
	public MyDate() {
		
	}

	public MyDate(int m, int d, int y) {
		day = d;
		month = m;
		year = y;
	}

	//DONE: return a string with month/day/year like “01/20/1964”  return "";
	public String toString(){  
		String formattedDate;
		
		formattedDate = month + "/" + day + "/" + year;
		return formattedDate;
	}
	
	// DONE: set the MyDate attributes with m, d, and y values here! 
	public void setDate(int m, int d, int y){   
		this.month = m;
		this.day = d;
		this.year = y;
	}  
}
