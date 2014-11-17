package cscie97.asn3.ecommerce.product;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The Class DeviceData stores device data and provide interfaces to import, view, 
 * update, and delete data entries.</p>
 * @author Fanxing Meng
 * @version 2.3 2013/10/08
 */
public class DeviceData{

	/**
	 * A HashMap that stores device information. The device ID serves
	 * as the key, while name and manufacturer are put into a list of strings
	 * and serve as the value of the map.
	 */
	private static Map<String, List<String>> deviceMap = new HashMap<String, List<String>>();
	
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
	 * An importDevice method that takes device ID, device name, manufacturer
	 * and user password as arguments and adds the entry to deviceMap
	 * if the key does not duplicate.
	 *
	 * @param newId the new device ID that should not duplicate
	 * @param newName the new name
	 * @param newManufacturer the new manufacturer
	 * @param token the password provided by the user from the main function
	 */
	public static void importDevice(String newId, String newName, String newManufacturer, String token){
		try {
			if(checkToken(token)){
				if(deviceMap.containsKey(newId)) {
					throw new Exception("Device ID " + newId + " already exists. Use \"updateDevice\" function to update name or manufacturer.");
				} else {
					List<String> thisDevice = new ArrayList<String>();
					thisDevice.add(newName);
					thisDevice.add(newManufacturer);
					deviceMap.put(newId, thisDevice);
				}
			} else {
				throw new Exception("Invalid access token, device info not added.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}

	/**
	 * An updateDevice method that takes device ID, (updated) device name,
	 * (updated) manufacturer and user password as arguments and updates the
	 * entry in deviceMap if the key exists.
	 *
	 * @param newId device ID of the device to be updated
	 * @param newName the new name
	 * @param newManufacturer the new manufacturer
	 * @param token the password provided by the user
	 */
	public static void updateDevice(String newId, String newName, String newManufacturer, String token){
		try {
			if(checkToken(token)){
				if(!deviceMap.containsKey(newId)) {
					throw new Exception("Device ID " + newId + " does not exists. Use \"importDevice\" function to import this device.");
				} else {
					List<String> thisDevice = new ArrayList<String>();
					thisDevice.add(newName);
					thisDevice.add(newManufacturer);
					deviceMap.put(newId, thisDevice);
				}
			} else {
				throw new Exception("Invalid access token, device info not updated.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/**
	 * A removeDevice method that takes device ID and the user's password
	 * as arguments and deletes the device's information in deviceMap if the
	 * key exists.
	 *
	 * @param newId the ID of the device to be removed
	 * @param token the password provided by the user
	 */
	public static void removeDevice(String newId, String token){
		try {
			if(checkToken(token)){
				if(!deviceMap.containsKey(newId)) {
					throw new Exception("Device ID " + newId + " does not exists.");
				} else { 
					deviceMap.remove(newId);
				}
			} else {
				throw new Exception("Invalid access token, device info not deleted.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}
	
	/**
	 * Gets the single instance of DeviceData.
	 *
	 * @return deviceMap single instance of DeviceData
	 */
	public static Map<String, List<String>> getInstance(){
		return deviceMap;
	}

	/**
	 * Gets the name.
	 *
	 * @param id the id
	 * @return the name
	 */
	public static String getName(String id){
		try {
			if(deviceMap.containsKey(id)) {
				return deviceMap.get(id).get(0);
			} else {
				throw new Exception("Invalid device ID " + id + " .");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
			return null;
		}
	}

	/**
	 * Gets the manufacturer.
	 *
	 * @param id the id
	 * @return the manufacturer
	 */
	public static String getManufacturer(String id){
		try {
			if(deviceMap.containsKey(id)) {
				return deviceMap.get(id).get(1);
			} else {
				throw new Exception("Invalid device ID " + id + " .");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
			return null;
		}
	}
}