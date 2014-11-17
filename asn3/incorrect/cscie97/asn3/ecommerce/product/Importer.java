package cscie97.asn3.ecommerce.product;

import java.io.*;
import java.net.*;

import cscie97.asn3.ecommerce.collection.CollectionData;

/**
 * The Class Importer imports country, device, and product files by reading from files and
 * feed data into importer functions in each data class.
 * @author Fanxing Meng
 * @version 3.0 2013/10/28
 */
public class Importer{

	/**
	 * An importCountryFile method that takes a country data file's path
	 * and user password as arguments and breaks down each line of valid data
	 * and calls CountryData.importCountry method to save them into a HashMap.
	 *
	 * @param fileName a country data file in csv format
	 * @param pass the password provided by the user from the main function
	 */
	public static void importCountryFile(String fileName, String pass){
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length()!=0 && !currentLine.startsWith("#")){
						String formatted = currentLine.replace("\\,", "");					
						String[] inputToken = formatted.split("\\,\\s|\\,");
						if(inputToken[0].length() == 2)
							CountryData.importCountry(inputToken[0], inputToken[1], inputToken[2], pass);
						else
							throw new Exception("Invalid country code: " + inputToken[0]);
					}
				}
			}
			reader.close();
		}	catch(Exception ex){
				System.out.println("Exception: " + ex);
			}
	}

	/**
	 * An importDeviceFile method that takes a device data file's path
	 * and user password as arguments and breaks down each line of valid data
	 * and calls DeviceData.importDevice method to save them into a HashMap.
	 *
	 * @param fileName a device data file in csv format
	 * @param pass the password provided by the user from the main function
	 */
	public static void importDeviceFile(String fileName, String pass){
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length()!=0 && !currentLine.startsWith("#")){
						String[] inputToken = currentLine.split("\\,\\s|\\,|\\t");
						for(int i = 0; i < 3; i++)
							if(inputToken[i] == null || inputToken[i].isEmpty())
								throw new Exception("Input parameter of field " + i + "is empty.");
						DeviceData.importDevice(inputToken[0], inputToken[1], inputToken[2], pass);
					}
				}
			}
			reader.close();
		}	catch(Exception ex){
				System.out.println("Exception: " + ex);
			}
	}

	/**
	 * An importProductFile method that takes a product data file's path
	 * and user password as arguments and breaks down each line of valid data
	 * and calls ProductData.importApplication or ProductData.importRingWall
	 * method depending on product type to save them into a HashMap.
	 *
	 * @param fileName a product data file in csv format
	 * @param pass the password provided by the user from the main function
	 */
	public static void importProductFile(String fileName, String pass){
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length()!=0 && !currentLine.startsWith("#")){
						String[] inputToken = currentLine.split("\\,\\s|\\,|\\t");
						for(int i = 0; i < 12 && i != 6; i++)
							if(inputToken[i] == null || inputToken[i].isEmpty())
								throw new Exception("Input parameter of field " + i + "is empty.");
						String[] exportCountries = inputToken[7].split("\\|");
						for(int i = 0; i < exportCountries.length; i++)
							if(CountryData.getInstance().get(exportCountries[i]).get(1).toLowerCase().equals("closed"))
								throw new Exception("Cannot export to this country: " + CountryData.getInstance().get(exportCountries[i]).get(0) + ".");
						if(inputToken[0].equalsIgnoreCase("application") && Integer.parseInt(inputToken[5]) >= 0 && Integer.parseInt(inputToken[5]) <= 5 && inputToken[12] != null && inputToken[12].matches("\\d+"))
							ProductData.importProduct(inputToken[0], inputToken[1], inputToken[2], inputToken[3], inputToken[4], Integer.parseInt(inputToken[5]), inputToken[6], inputToken[7], inputToken[8], Float.parseFloat(inputToken[9]), inputToken[10], new URL(inputToken[11]), Integer.parseInt(inputToken[12]), pass);
						else if((inputToken[0].equalsIgnoreCase("ringtone") || inputToken[0].equalsIgnoreCase("wallpaper")) && Integer.parseInt(inputToken[5]) >= 0 && Integer.parseInt(inputToken[5]) <= 5)
							ProductData.importProduct(inputToken[0], inputToken[1], inputToken[2], inputToken[3], inputToken[4], Integer.parseInt(inputToken[5]), inputToken[6], inputToken[7], inputToken[8], Float.parseFloat(inputToken[9]), inputToken[10], new URL(inputToken[11]), -1, pass);
						else
							throw new Exception("Invalid product type " + inputToken[0] + " for the arguments given.");
					}
				}
			}
			reader.close();
		}	catch(Exception ex){
				System.out.println("Exception: " + ex);
			}
	}
	
	/**
	 * An importCollectionFile method that takes collections' data file's path
	 * and user password as arguments and breaks down each line of valid data
	 * and calls CollectionData.defineCollection or CollectionData.addCollectionContent
	 * or CollectionData.setDynamicCriteria method depending on collection type.
	 *
	 * @param fileName collections' data file in csv format
	 * @param pass the password provided by the user from the main function
	 */
	public static void importCollectionFile(String fileName, String pass){
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length()!=0 && !currentLine.startsWith("#")){
						String formatted = currentLine.replace("\\,", "");					
						String[] inputToken = formatted.split("\\,\\s|\\,", -1);
						if(inputToken[0].equalsIgnoreCase("define_collection") && inputToken[1]!=null && inputToken[2]!=null && inputToken[3]!=null && inputToken[4]!=null) {
							CollectionData.defineCollection(inputToken[1], inputToken[2], inputToken[3], inputToken[4], pass);
						} else if(inputToken[0].equalsIgnoreCase("add_collection_content") && inputToken[1]!=null && inputToken[2]!=null && inputToken[3]!=null) {
							CollectionData.addCollectionContent(inputToken[1], inputToken[2], inputToken[3], pass);
						} else if(inputToken[0].equalsIgnoreCase("set_dynamic_criteria") && inputToken[1]!=null && inputToken[2]!=null && inputToken[3]!=null && inputToken[4]!=null && inputToken[5]!=null && inputToken[6]!=null && inputToken[7]!=null && inputToken[8]!=null && inputToken[9]!=null) {
							CollectionData.setDynamicCriteria(inputToken[1], inputToken[2] + ", " + inputToken[3] + ", " + inputToken[4] + ", " + inputToken[5] + ", " + inputToken[6] + ", " + inputToken[7] + ", " + inputToken[8] + ", " + inputToken[9], pass);
						} else {
							throw new Exception("Undefined action " + inputToken[0]);
						}
					}
				}
			}
			reader.close();
		}	catch(Exception ex){
				System.out.println("Exception: " + ex);
			}
	}
}