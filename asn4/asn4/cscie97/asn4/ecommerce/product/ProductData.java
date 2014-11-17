package cscie97.asn4.ecommerce.product;

import java.net.*;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import cscie97.asn4.ecommerce.authentication.*;

/**
  * The Class ProductData, stores product data and provide interfaces to import, view, 
  * update, and delete data entries.
  * @author Fanxing Meng
  * @version 3.1 2013/10/30
 */
public class ProductData{

	/** The product map that stores product information. The product ID serves
	  * as the key, while other details are put into a Product class instance
	  * and serve as the value of the map.
	  */
	private static Map<String, Product> productMap = new HashMap<String, Product>();

	/**
	 * Import product method that takes product ID, name, type,
	 * description, author, rating, categories, countries released to, devices
	 * supported, price, languages, an image URL, size, and user password as
	 * arguments and adds the entry to productMap if the key does not duplicate.
	 *
	 * @param newType the new type
	 * @param newId the new id that should not duplicate
	 * @param newName the new name
	 * @param newDescription the new description
	 * @param newAuthor the new author
	 * @param newRating the new rating
	 * @param newCatagories the new categories
	 * @param newCountries the new countries released to
	 * @param newDevices the new devices supported
	 * @param newPrice the new price
	 * @param newLanguages the new languages
	 * @param newImageURL the new image url
	 * @param newSize the new size, -1 if not an application
	 * @param token the password provided by the user from the main function
	 */
	public static void importProduct(String newType, String newId, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, int newSize, UUID token){
		try {
			if (Authentication.getInstance().checkTokenPermission(token, "create_product")) {
				if(productMap.containsKey(newId))
					throw new Exception("Product ID " + newId + " already exists. Use \"updateApplication\" function to update product.");
				else {
					Product thisProduct = new Product(newType, newName, newDescription, newAuthor, newRating, newCatagories, newCountries, newDevices, newPrice, newLanguages, newImageURL, newSize);
					productMap.put(newId, thisProduct);
				}
			} else {
				throw new Exception("Invalid access token, product info not added.");
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	}

	/**
	 * A getInstance method that returns the only instance of the productMap.
	 *
	 * @return productMap instance of ProductData
	 */
	public static Map<String, Product> getInstance(){
		return productMap;
	}

}
