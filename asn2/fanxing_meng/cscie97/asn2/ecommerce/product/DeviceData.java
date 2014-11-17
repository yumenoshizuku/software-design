package cscie97.asn2.ecommerce.product;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
  * <p>DeviceData</p>
  * <p>Stores device data and provide interfaces to import, view, 
  * update, and delete data entries.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class DeviceData{
/**
  * <p>A HashMap that stores device information. The device ID serves
  * as the key, while name and manufacturer are put into a list of strings
  * and serve as the value of the map.</p>
  */
	private static Map<String, List<String>> deviceMap = new HashMap<String, List<String>>();

/**
  * </p>A check token function that verifies if a user has the privileges 
  * needed to perform maintenance. It takes a string type token and returns
  * true on validation and false if it does not match.</p>
  *
  * @param token				a password that is provided by the user
  *
  * @return	   					true if password valid, false if invalid
  */	
	private static boolean checkToken(String token){
		return true;
	}

/**
  * <p>An importDevice method that takes device ID, device name, manufacturer
  * and user password as arguments and adds the entry to deviceMap
  * if the key does not duplicate.</p>
  *
  * @param newId				a new device ID that should not duplicate
  * @param newName				the new device's name
  * @param newManufacturer		the new device's manufacturer
  * @param token 				the password provided by the user from the main function
  *
  * @return		   				null
  *
  * @see deviceMap
  */
	public static void importDevice(String newId, String newName, String newManufacturer, String token){
		if(checkToken(token)){
			if(deviceMap.containsKey(newId))
				System.out.println("Device ID " + newId + " already exists. Use \"updateDevice\" function to update name or manufacturer.");
			else {
				List<String> thisDevice = new ArrayList<String>();
				thisDevice.add(newName);
				thisDevice.add(newManufacturer);
				deviceMap.put(newId, thisDevice);
			}
		}
		else
			System.out.println("Invalid access token, device info not added.");
	}

/**
  * <p>An updateDevice method that takes device ID, (updated) device name,
  * (updated) manufacturer and user password as arguments and updates the
  * entry in deviceMap if the key exists.</p>
  *
  * @param newId					device ID of the device to be updated
  * @param newName					the device's updated name
  * @param newManufacturer			the device's updated manufacturer
  * @param 							token the password provided by the user
  *
  * @return		   					null
  *
  * @see deviceMap
  */
	public static void updateDevice(String newId, String newName, String newManufacturer, String token){
		if(checkToken(token)){
			if(!deviceMap.containsKey(newId))
				System.out.println("Device ID " + newId + " does not exists. Use \"importDevice\" function to import this device.");
			else {
				List<String> thisDevice = new ArrayList<String>();
				thisDevice.add(newName);
				thisDevice.add(newManufacturer);
				deviceMap.put(newId, thisDevice);
			}
		}
		else
			System.out.println("Invalid access token, device info not updated.");
	}

/**
  * <p>A removeDevice method that takes device ID and the user's password
  * as arguments and deletes the device's information in deviceMap if the
  * key exists.</p>
  *
  * @param newId			the ID of the device to be removed
  * @param token 			the password provided by the user
  *
  * @return		   			null
  *
  * @see deviceMap
  */			
	public static void removeDevice(String newId, String token){
		if(checkToken(token)){
			if(!deviceMap.containsKey(newId))
				System.out.println("Device ID " + newId + " does not exists.");
			else 
				deviceMap.remove(newId);
		}
		else
			System.out.println("Invalid access token, device info not deleted.");
	}

/**
  * <p>A getInstance method that returns the only instance of the deviceMap.</p>
  *
  * @return deviceMap
  */		
	public static Map<String, List<String>> getInstance(){
		return deviceMap;
	}

/**
  * <p>A getName method that returns the name of the device given a valid
  * device ID.</p>
  *
  * @return deviceMap.get(id).get(0) as the name, and null if the code is invalid
  */	
	public static String getName(String id){
		if(deviceMap.containsKey(id))
			return deviceMap.get(id).get(0);
		else {
			System.out.println("Invalid device ID " + id + " .");
			return null;
		}
	}

/**
  * <p>A getManufacturer method that returns the manufacturer of the device given
  * a valid device ID.</p>
  *
  * @return deviceMap.get(id).get(1) as the manufacturer, and null if the code is invalid
  */	
	public static String getManufacturer(String id){
		if(deviceMap.containsKey(id))
			return deviceMap.get(id).get(1);
		else {
			System.out.println("Invalid device ID " + id + " .");
			return null;
		}
	}
}
