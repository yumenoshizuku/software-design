package cscie97.asn3.ecommerce.product;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The Class CountryData stores country data and provide interfaces to import, view, 
  * update, and delete data entries.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class CountryData{

	/**
	 * A HashMap that stores country information. The country code serves
	 * as the key, while name and export status are put into a list of strings
	 * and serve as the value of the map.
	 */
	private static Map<String, List<String>> countryMap = new HashMap<String, List<String>>();

	/**
	 * A check token function that verifies if a user has the privileges 
	 * needed to perform maintenance. It takes a string type token and returns
	 * true on validation and false if it does not match.
	 *
	 * @param token a password that is provided by the user
	 * @return true, if password valid; false, if invalid
	 */
	private static boolean checkToken(String token){
		return true;
	}

	/**
	 * An importCountry method that takes country code, country name, export
	 * status and user password as arguments and adds the entry to countryMap
	 * if the key does not duplicate.
	 *
	 * @param newCode a new country code that should not duplicate
	 * @param newName the new name
	 * @param newStatus the new export status
	 * @param token the token
	 */
	public static void importCountry(String newCode, String newName, String newStatus, String token){
		try {
			if(checkToken(token)){
				if(!countryMap.containsKey(newCode)){
					if(newStatus.toLowerCase().equals("open") || newStatus.toLowerCase().equals("closed")){
						List<String> thisCountry = new ArrayList<String>();
						thisCountry.add(newName);
						thisCountry.add(newStatus);
						countryMap.put(newCode, thisCountry);
					} else {
						throw new Exception("Invalid export status: " + newStatus + ".");
					}
				} else {
					throw new Exception("Country code " + newCode + " already exists. Use \"updateCountry\" function to update name or export status.");
				}
			} else {
				throw new Exception("Invalid access token, country info not added.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}

	/**
	 * An updateCountry method that takes country code, (updated) country name,
	 * (updated) export status and user password as arguments and updates the
	 * country's information to countryMap if the key exists.
	 *
	 * @param newCode the country code of the country to be updated
	 * @param newName the new name
	 * @param newStatus the new export status
	 * @param token the password provided by the user
	 */
	public static void updateCountry(String newCode, String newName, String newStatus, String token){
		try {
			if(checkToken(token)){
				if(!countryMap.containsKey(newCode)){
					List<String> thisCountry = new ArrayList<String>();
					thisCountry.add(newName);
					thisCountry.add(newStatus);
					countryMap.put(newCode, thisCountry);
				} else {
					throw new Exception("Country code " + newCode + " does not exists. Use \"importCountry\" function to import this country.");
				}
			} else {
				throw new Exception("Invalid access token, country info not updated.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/**
	 * A removeCountry method that takes country code and the user's password
	 * as arguments and deletes the country's information in countryMap if the
	 * key exists.
	 *
	 * @param newCode the code of the country to be removed
	 * @param token the password provided by the user
	 */
	public static void removeCountry(String newCode, String token){
		try {
			if(checkToken(token)){
				if(countryMap.containsKey(newCode)) {
					countryMap.remove(newCode);
				} else {
					throw new Exception("Country code " + newCode + " does not exists.");
				}
			} else {
				throw new Exception("Invalid access token, country info not deleted.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}

	/**
	 * Gets the single instance of CountryData.
	 *
	 * @return countryMap single instance of CountryData
	 */
	public static Map<String, List<String>> getInstance(){
		return countryMap;
	}

	/**
	 * Gets the name.
	 *
	 * @param code the code
	 * @return the name
	 */
	public static String getName(String code){
		try {
			if(countryMap.containsKey(code)) {
				return countryMap.get(code).get(0);
			} else {
				throw new Exception("Invalid country code " + code + " .");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
			return null;
		}
	}
	
	/**
	 * Gets the export status.
	 *
	 * @param code the code
	 * @return the export status
	 */
	public static String getStatus(String code){
		try {
			if(countryMap.containsKey(code)) {
				return countryMap.get(code).get(1);
			} else {
				throw new Exception("Invalid country code " + code + " .");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
			return null;
		}
	}
}