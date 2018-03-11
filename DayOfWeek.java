/* Name: Nicholas Keen
 * Course: Computer Science - CIS I
 * Section: 003
 * Assignment 7
 */
import java.util.*;
//This program allows you to input a date
//and outputs what day of the week it falls on.
public class DayOfWeek {
    
    //prompts the user for a date and 
    //calls the other methods.
    public static void main(String[] args) {
	System.out.println("This program will tell you " +
			   "what day of the week\na certain " +
			   "date falls on.\n");
	Scanner sc = new Scanner(System.in);
	dayOfWeek(totalDays(fullMonths(date("month (1 to 12)", sc)), +
		  date("day (1 to 31)", sc), +
		  leapYears(fullYears(date("year (e.g., 2007)", sc)))));
    }
    //asks the user for the date and
    //reads their input.
    public static int date(String s, Scanner sc) {
	System.out.print("What is the " + s + "? ");
	return sc.nextInt();
    }
    //takes the user's input for 'years'
    //and calculates and returns the number 
    //of non-leap year days up to but not 
    //including the year entered.
    public static int fullYears(int years) {
	years = years * 365 - 365;
	return years;
    }
    //calculates the number of leap years
    //and adds one day per leap year to the
    //total number of 'normal year' days, then
    //returns the new value for 'years.'
    public static int leapYears(int years) {
	int leap = (((years+365)/365)-1)/4 - 
		   (((years+365)/365)-1)/100 + 
		   (((years+365)/365)-1)/400;
	years = years + leap;
	return years;
    }
    //takes the user input for the month
    //and returns the number of days in all
    //the months up to but not including the
    //month entered.
    public static int fullMonths(int month) {
	if(month == 1) {
	    month = 0;
	}else if(month == 2) {
	    month = 31; 
	}else if(month == 3) {
	    month = 31 + 28;
	}else if(month == 4) {
	    month = 59 + 31;
	}else if(month == 5) {
	    month = 90 + 30;
	}else if(month == 6) {
	    month = 120 + 31;
	}else if(month == 7) {
	    month = 151 + 30;
	}else if(month == 8) {
	    month = 181 + 31;
	}else if(month == 9) {
	    month = 212 + 31;
	}else if(month == 10) {
	    month = 243 + 30;
	}else if(month == 11) {
	    month = 273 + 31;
	}else if(month == 12) {
	    month = 304 + 30;
	}
	return month;
    }
    //adds together all the days and returns the value.
    public static int totalDays(int months, int days, int years) {
	int totalDays;
	int currentYear = (((years+365)/365));
	//fixes a math issue that caused the value
	//for current year to increase by one
	//after 1508.
	if(currentYear < 1509) {
	    currentYear = (((years+365)/365));
	}else if(currentYear > 1509) {
	    currentYear = (((years+365)/365)-1);
	}else if(currentYear == 1509) {
	    currentYear = 1509;
	}
	//looks at the current year and figures
	//out if its a leap year, and if its after
	//February, and if both cases are true, adds one day.
	if(currentYear % 4 == 0 && currentYear % 100 == 0 && +
	    currentYear % 400 == 0 && months >= 59) {
	    totalDays = months + days + years + 1;
	}else if(currentYear % 4 == 0 && +
	    currentYear % 100 != 0 && months >= 59) {
	    totalDays = months + days + years + 1;
	}else {
	    totalDays = months + days + years;
	}
	return totalDays;
    }
    //finds the remainder when the total
    //number of days is divided by seven
    //and prints out the day of the week
    //accordingly.
    public static void dayOfWeek(int totalDays) {
	System.out.print("Your date falls on a ");
	if(totalDays % 7 == 0) {
	    System.out.println("Sunday");
	}else if(totalDays % 7 == 1) {
	    System.out.println("Monday");
	}else if(totalDays % 7 == 2) {
	    System.out.println("Tuesday");
	}else if(totalDays % 7 == 3) {
	    System.out.println("Wednesday");
	}else if(totalDays % 7 == 4) {
	    System.out.println("Thursday");
	}else if(totalDays % 7 == 5) {
	    System.out.println("Friday");
	}else {
	    System.out.println("Saturday");
	}
    }
}

