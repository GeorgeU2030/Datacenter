package model;

public class Date{
    private int day;
    private int month;
    private int year;
    /**
     * Constructor of the Date Class, empty 
     */
    public Date(){}
    /**
     * Constructor of the Date Class, initialize the date 
     * @param day int is the day to register
     * @param month int is the month to register
     * @param year int is the year to register
     */
    public Date(int day, int month, int year) {
		this.day= day;
		this.month= month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	/**
 * Method toString of the Date class
 * Show of the date , without parameters
 * @return String is the information date
 */ 
	public String toString() {
		return day +"/" + month + "/" + year;
	}

}