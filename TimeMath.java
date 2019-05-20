/*Sathya Gadhiraju
 10-2-13
 This class calculates the time zones for Dallas and Tampa.*/
 
 public class TimeMath{ // class header
 
  public TimeMath() // constructor
  {
  }
 
  public int makeDallasTime(int inTime) // method to calculate Dallas time
  {
   int dallasTime = inTime+ 2; // add two to calculate
   dallasTime = dallasTime % 24; // use modulus to handle issue of conversions that exceed 24
   return dallasTime; // return value
  }
 
  public int makeTampaTime(int inTime) // method to calculate Tampa time
  {
   int tampaTime = inTime + 3; // add three to calculate
   tampaTime = tampaTime % 24; // use modulus to handle issue of conversions that exceed 24
   return tampaTime; // return value
  }
 }

