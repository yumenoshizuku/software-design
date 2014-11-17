package cscie97.asn2.ecommerce.product;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.HashMap;

/**
  * <p>ProductData</p>
  * <p>Stores product data and provide interfaces to import, view, 
  * update, and delete data entries.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class ProductData{
/**
  * <p>A HashMap that stores product information. The product ID serves
  * as the key, while other details are put into a Product class instance
  * and serve as the value of the map.</p>
  */
	private static Map<String, Product> productMap = new HashMap<String, Product>();

/**
  * </p>A check token function that verifies if a user has the privileges 
  * needed to perform maintenance. It takes a string type token and returns
  * true on validation and false if it does not match.</p>
  *
  * @param token	a password that is provided by the user
  *
  * @return	   		true if password valid, false if invalid
  */		
	private static boolean checkToken(String token){
		return true;
	}

/**
  * <p>An importApplication method that takes product ID, name, type,
  * description, author, rating, categories, countries realeased to, devices
  * supported, price, languages, an image URL, size, and user password as
  * arguments and adds the entry to productMap if the key does not duplicate.</p>
  *
  * @param newType					the new product's type
  * @param newId					a new product ID that should not duplicate
  * @param newName					the new product's name
  * @param newDescription			the new product's description
  * @param newAuthor				the new product's author
  * @param newRating				the new product's rating
  * @param newCatagories			the new product's categories
  * @param newCountries				the new product's countries realeased to
  * @param newDevices				the new product's devices supported
  * @param newPrice					the new product's price
  * @param newLanguages				the new product's languages
  * @param newImageURL				the new product's image URL
  * @param newSize					the new product's size
  * @param token 	the password provided by the user from the main function
  *
  * @return		   	null
  *
  * @see productMap
  */
	public static void importApplication(String newType, String newId, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, int newSize, String token){
		if(checkToken(token)){
			if(productMap.containsKey(newId))
				System.out.println("Product ID " + newId + " already exists. Use \"updateApplication\" function to update product.");
			else {
				Product thisProduct = new Product(newType, newName, newDescription, newAuthor, newRating, newCatagories, newCountries, newDevices, newPrice, newLanguages, newImageURL, newSize);
				productMap.put(newId, thisProduct);
			}
		}
		else
			System.out.println("Invalid access token, product info not added.");
	}

/**
  * <p>An importRingWall method that takes product ID, name, type, description,
  * author, rating, categories, countries realeased to, devices supported,
  * price, languages, an image URL, and user password as arguments and
  * adds the entry to productMap if the key does not duplicate.</p>
  *
  * @param newType					the new product's type
  * @param newId					a new product ID that should not duplicate
  * @param newName					the new product's name
  * @param newDescription			the new product's description
  * @param newAuthor				the new product's author
  * @param newRating				the new product's rating
  * @param newCatagories			the new product's categories
  * @param newCountries				the new product's countries realeased to
  * @param newDevices				the new product's devices supported
  * @param newPrice					the new product's price
  * @param newLanguages				the new product's languages
  * @param newImageURL				the new product's image URL
  * @param token 	the password provided by the user from the main function
  *
  * @return		   	null
  *
  * @see productMap
  */	
	public static void importRingWall(String newType, String newId, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, String token){
		if(checkToken(token)){
			if(productMap.containsKey(newId))
				System.out.println("Product ID " + newId + " already exists. Use \"updateRingWall\" function to update product.");
			else {
				Product thisProduct = new Product(newType, newName, newDescription, newAuthor, newRating, newCatagories, newCountries, newDevices, newPrice, newLanguages, newImageURL);
				productMap.put(newId, thisProduct);
			}
		}
		else
			System.out.println("Invalid access token, product info not added.");
	}

/**
  * <p>An updateApplication method that takes product ID, name, type,
  * description, author, rating, categories, countries realeased to, devices
  * supported, price, languages, an image URL, size, and user password as
  * arguments and updates the entry to productMap if the key exists.</p>
  *
  * @param newType					the product's type
  * @param newId					the ID of product to be updated
  * @param newName					the product's updated name
  * @param newDescription			the product's updated description
  * @param newAuthor				the product's updated author
  * @param newRating				the product's updated rating
  * @param newCatagories			the product's updated categories
  * @param newCountries				the product's updated countries realeased to
  * @param newDevices				the product's updated devices supported
  * @param newPrice					the product's updated price
  * @param newLanguages				the product's updated languages
  * @param newImageURL				the product's updated image URL
  * @param newSize					the product's updated size
  * @param token 	the password provided by the user from the main function
  *
  * @return		   	null
  *
  * @see productMap
  */	
	public static void updateApplication(String newType, String newId, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, int newSize, String token){
		if(checkToken(token)){
			if(!productMap.containsKey(newId))
				System.out.println("Product ID " + newId + " does not exists. Use \"importApplication\" function to import product.");
			else {
				Product thisProduct = new Product(newType, newName, newDescription, newAuthor, newRating, newCatagories, newCountries, newDevices, newPrice, newLanguages, newImageURL, newSize);
				productMap.put(newId, thisProduct);
			}
		}
		else
			System.out.println("Invalid access token, product info not updated.");
	}

/**
  * <p>An updateRingWall method that takes product ID, name, type,
  * description, author, rating, categories, countries realeased to, devices
  * supported, price, languages, an image URL, and user password as
  * arguments and updates the entry to productMap if the key exists.</p>
  *
  * @param newType					the product's type
  * @param newId					the ID of product to be updated
  * @param newName					the product's updated name
  * @param newDescription			the product's updated description
  * @param newAuthor				the product's updated author
  * @param newRating				the product's updated rating
  * @param newCatagories			the product's updated categories
  * @param newCountries				the product's updated countries realeased to
  * @param newDevices				the product's updated devices supported
  * @param newPrice					the product's updated price
  * @param newLanguages				the product's updated languages
  * @param newImageURL				the product's updated image URL
  * @param token 	the password provided by the user from the main function
  *
  * @return		   	null
  *
  * @see productMap
  */		
	public static void updateRingWall(String newType, String newId, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, String token){
		if(checkToken(token)){
			if(!productMap.containsKey(newId))
				System.out.println("Product ID " + newId + " does not exists. Use \"importApplication\" function to import product.");
			else {
				Product thisProduct = new Product(newType, newName, newDescription, newAuthor, newRating, newCatagories, newCountries, newDevices, newPrice, newLanguages, newImageURL);
				productMap.put(newId, thisProduct);
			}
		}
		else
			System.out.println("Invalid access token, product info not updated.");
	}

/**
  * <p>A removeProduct method that takes product ID and the user's password
  * as arguments and deletes the product's information in productMap if the
  * key exists.</p>
  *
  * @param newId			the ID of the product to be removed
  * @param token 			the password provided by the user
  *
  * @return		   			null
  *
  * @see productMap
  */		
	public static void removeProduct(String newId, String token){
		if(checkToken(token)){
			if(!productMap.containsKey(newId))
				System.out.println("Product ID " + newId + " does not exists.");
			else 
				productMap.remove(newId);
		}
		else
			System.out.println("Invalid access token, product info not deleted.");
	}

/**
  * <p>A getInstance method that returns the only instance of the productMap.</p>
  *
  * @return productMap
  */	
	public static Map<String, Product> getInstance(){
		return productMap;
	}

}
