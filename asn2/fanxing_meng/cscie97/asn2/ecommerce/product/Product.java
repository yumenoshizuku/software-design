package cscie97.asn2.ecommerce.product;

import java.io.*;
import java.net.*;

/**
  * <p>Product</p>
  * <p>Stores each product's data and provide interfaces to create and view
  * data entries.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class Product{
	private String type;
	private String name;
	private String description;
	private String author;
	private int rating;
	private String catagories;
	private String countries;
	private String devices;
	private float price;
	private String languages;
	private URL imageURL;
	private int size;

/**
  * <p>A Product constructor that that takes product ID, name, type, description,
  * author, rating, categories, countries realeased to, devices supported,
  * price, languages, an image URL and size as parameters.</p>
  *
  * @see ProductData
  */
	public Product(String newType, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, int newSize){
				type = newType;
				name = newName;
				description = newDescription;
				author = newAuthor;
				rating = newRating;
				catagories = newCatagories;
				countries = newCountries;
				devices = newDevices;
				price = newPrice;
				languages = newLanguages;
				imageURL = newImageURL;
				size = newSize;
	}

/**
  * <p>A Product constructor that that takes product ID, name, type, description,
  * author, rating, categories, countries realeased to, devices supported,
  * price, languages, and an image URL as parameters.</p>
  *
  * @see ProductData
  */	
	public Product(String newType, String newName, String newDescription, String newAuthor, int newRating, String newCatagories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL){
				type = newType;
				name = newName;
				description = newDescription;
				author = newAuthor;
				rating = newRating;
				catagories = newCatagories;
				countries = newCountries;
				devices = newDevices;
				price = newPrice;
				languages = newLanguages;
				imageURL = newImageURL;
				size = -1;
	}

/**
  * <p>A getType method that returns the type of the current product.</p>
  *
  * @return type
  */		
	public String getType(){
		return type;
	}

/**
  * <p>A getName method that returns the name of the current product.</p>
  *
  * @return name
  */		
	public String getName(){
		return name;
	}

/**
  * <p>A getDescription method that returns the description of the current product.</p>
  *
  * @return description
  */		
	public String getDescription(){
		return description;
	}
	
/**
  * <p>A getAuthor method that returns the author of the current product.</p>
  *
  * @return author
  */	
	public String getAuthor(){
		return author;
	}
	
/**
  * <p>A getRating method that returns the rating of the current product.</p>
  *
  * @return rating
  */	
	public int getRating(){
		return rating;
	}
	
/**
  * <p>A getCatagories method that returns the catagories of the current product.</p>
  *
  * @return catagories
  */	
	public String getCatagories(){
		return catagories;
	}

/**
  * <p>A getCountries method that returns the countries of the current product.</p>
  *
  * @return countries
  */	
	public String getCountries(){
		return countries;
	}
	
/**
  * <p>A getDevices method that returns the devices of the current product.</p>
  *
  * @return devices
  */	
	public String getDevices(){
		return devices;
	}

/**
  * <p>A getPrice method that returns the price of the current product.</p>
  *
  * @return price
  */	
	public float getPrice(){
		return price;
	}
	
/**
  * <p>A getLanguages method that returns the languages of the current product.</p>
  *
  * @return languages
  */	
	public String getLanguages(){
		return languages;
	}
	
/**
  * <p>A getImageURL method that returns the image URL of the current product.</p>
  *
  * @return imageURL
  */	
	public URL getImageURL(){
		return imageURL;
	}
	
/**
  * <p>A getSize method that returns the size of the current product.
  * For ringtone or wallpapers it would return -1.</p>
  *
  * @return size
  */	
	public int getSize(){
		return size;
	}
	
/**
  * <p>A getText method that returns the text information of the current product.</p>
  *
  * @return a combined string of product name and description
  */	
	public String text(){
		return name + " " + description;
	}
	
/**
  * <p>A show method that returns a formatted string of the current product.</p>
  *
  * @return a combined string of product type, name, description, author, categories, rating, price, countries, languages, and devices
  */	
	public String show(){
		return "Content type: " + type + "\nName: " + name + "\nDescription: " + description + "\nAuthor: " + author +  "\nCategory: " + catagories + "\nRating: " + rating + "\nPrice: " + price + "\nCountries: " + countries + "\nLanguages: " + languages + "\nDevices: " + devices;
	}
}
