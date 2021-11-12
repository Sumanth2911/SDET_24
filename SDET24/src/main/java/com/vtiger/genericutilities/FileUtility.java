package com.vtiger.genericutilities;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Sumantha
 *
 */

public class FileUtility {
	
		/**
		 *  used to get the data from properties File based on key
		 * @param key
		 * @return the value of the key is in the form of String
		 * @throws Exception
		 */
	   public String getPropertyKeyValue(String key)throws Exception
	   {
		   FileInputStream fis=new FileInputStream("./Excel/commondata.property");
		   Properties pObj=new Properties();
		   pObj.load(fis);
		   String value = pObj.getProperty(key);
		   return value;
	   }

		}


