package cscie97.asn2.ecommerce.product;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
  * <p>CountryData</p>
  * <p>Stores country data and provide interfaces to import, view, 
  * update, and delete data entries.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class CountryData{
/**
  * <p>A HashMap that stores country information. The country code serves
  * as the key, while name and export status are put into a list of strings
  * and serve as the value of the map.</p>
  */
	private static Map<String, List<String>> countryMap = new HashMap<String, List<String>>();

/**
  * </p>A check token function that verifies if a user has the privileges 
  * needed to perform maintenance. It takes a string type token and returns
  * true on validation and false if it does not match.</p>
  *
  * @param token		a password that is provided by the user
  *
  * @return	   			true if password valid, false if invalid
  */
	private static boolean checkToken(String token){
		return true;
	}

/**
  * <p>An importCountry method that takes country code, country name, export
  * status and user password as arguments and adds the entry to countryMap
  * if the key does not duplicate.</p>
  *
  * @param newCode		a new country code that should not duplicate
  * @param newName		the new country's name
  * @param newStatus	the new country's export status
  * @param token 		the password provided by the user from the main function
  *
  * @return		   		null
  *
  * @see countryMap
  */
	public static void importCountry(String newCode, String newName, String newStatus, String token){
		if(checkToken(token)){
			if(!countryMap.containsKey(newCode)){
				if(newStatus.toLowerCase().equals("open") || newStatus.toLowerCase().equals("closed")){
					List<String> thisCountry = new ArrayList<String>();
					thisCountry.add(newName);
					thisCountry.add(newStatus);
					countryMap.put(newCode, thisCountry);
				}
				else
					System.out.println("Invalid export status: " + newStatus + ".");
			}
			else
				System.out.println("Country code " + newCode + " already exists. Use \"updateCountry\" function to update name or export status.");
		}
		else
			System.out.println("Invalid access token, country info not added.");
	}

/**
  * <p>An updateCountry method that takes country code, (updated) country name,
  * (updated) export status and user password as arguments and updates the
  * country's information to countryMap if the key exists.</p>
  *
  * @param newCode			the country code of the country to be updated
  * @param newName			the country's updated name
  * @param newStatus		the country's updated export status
  * @param token 			the password provided by the user
  *
  * @return		   			null
  *
  * @see countryMap
  */	
	public static void updateCountry(String newCode, String newName, String newStatus, String token){
		if(checkToken(token)){
			if(!countryMap.containsKey(newCode)){
				List<String> thisCountry = new ArrayList<String>();
				thisCountry.add(newName);
				thisCountry.add(newStatus);
				countryMap.put(newCode, thisCountry);
			}
			else
				System.out.println("Country code " + newCode + " does not exists. Use \"importCountry\" function to import this country.");
		}
		else
			System.out.println("Invalid access token, country info not updated.");
	}

/**
  * <p>A removeCountry method that takes country code and the user's password
  * as arguments and deletes the country's information in countryMap if the
  * key exists.</p>
  *
  * @param newCode			the code of the country to be removed
  * @param token 			the password provided by the user
  *
  * @return		   			null
  *
  * @see countryMap
  */		
	public static void removeCountry(String newCode, String token){
		if(checkToken(token)){
			if(countryMap.containsKey(newCode))
				countryMap.remove(newCode);
			else
				System.out.println("Country code " + newCode + " does not exists.");
		}
		else
			System.out.println("Invalid access token, country info not deleted.");
	}

/**
  * <p>A getInstance method that returns the only instance of the countryMap.</p>
  *
  * @return countryMap
  */	
	public static Map<String, List<String>> getInstance(){
		return countryMap;
	}

/**
  * <p>A getName method that returns the name of the country given a valid
  * country code.</p>
  *
  * @return countryMap.get(code).get(0) as the name, and null if the code is invalid
  */	
	public static String getName(String code){
		if(countryMap.containsKey(code))
			return countryMap.get(code).get(0);
		else {
			System.out.println("Invalid country code " + code + " .");
			return null;
		}
	}

/**
  * <p>A getStatus method that returns the export status of the country given
  * a valid country code.</p>
  *
  * @return countryMap.get(code).get(1) as the status, and null if the code is invalid
  */		
	public static String getStatus(String code){
		if(countryMap.containsKey(code))
			return countryMap.get(code).get(1);
		else {
			System.out.println("Invalid country code " + code + " .");
			return null;
		}
	}
}
