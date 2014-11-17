package cscie97.asn4.ecommerce.product;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import cscie97.asn4.ecommerce.authentication.*;

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
	 * An importCountry method that takes country code, country name, export
	 * status and user password as arguments and adds the entry to countryMap
	 * if the key does not duplicate.
	 *
	 * @param newCode a new country code that should not duplicate
	 * @param newName the new name
	 * @param newStatus the new export status
	 * @param token the token
	 */
	public static void importCountry(String newCode, String newName, String newStatus, UUID token){
		try {
			if (Authentication.getInstance().checkTokenPermission(token, "create_country")) {
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
