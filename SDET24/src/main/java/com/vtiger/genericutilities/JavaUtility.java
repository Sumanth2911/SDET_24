package com.vtiger.genericutilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

		/**
		 * returns the random integer number in the form of String 
		 * @return
		 */
	   public String getRandomNum()
	   {
		   Random ran=new Random();
		   int randnum=ran.nextInt(1000);
		   return "_"+randnum;
	   }
	   
	   /**
	    * returns the current date in the form of String
	    * @return
	    */
	   public String getDate()
	   {
		   Date dat=new Date();
		   String date1=dat.toString();
		   String date=date1.replaceAll(":", "-");
		   return date;
	   }
	}
	

