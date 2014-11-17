package cscie97.asn4.ecommerce.product;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

import cscie97.asn4.ecommerce.authentication.*;

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
	 * An importDevice method that takes device ID, device name, manufacturer
	 * and user password as arguments and adds the entry to deviceMap
	 * if the key does not duplicate.
	 *
	 * @param newId the new device ID that should not duplicate
	 * @param newName the new name
	 * @param newManufacturer the new manufacturer
	 * @param token the password provided by the user from the main function
	 */
	public static void importDevice(String newId, String newName, String newManufacturer, UUID token){
		try {
			if (Authentication.getInstance().checkTokenPermission(token, "create_device")) {
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
