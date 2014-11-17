package cscie97.asn4.ecommerce.product;
import cscie97.asn4.ecommerce.collection.*;

import java.net.*;
import java.util.Iterator;

/**
 * The Class Product stores each product's data and provide interfaces to create and view
 * data entries.
 * @author Fanxing Meng
 * @version 3.3 2013/10/30
 */
public class Product extends Collectable{
	
	/** The type. */
	private String type;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The author. */
	private String author;
	
	/** The rating. */
	private int rating;
	
	/** The categories. */
	private String categories;
	
	/** The countries. */
	private String countries;
	
	/** The devices. */
	private String devices;
	
	/** The price. */
	private float price;
	
	/** The languages. */
	private String languages;
	
	/** The image url. */
	private URL imageURL;
	
	/** The size. */
	private int size;

	/**
	 * Instantiates a new product.
	 *
	 * @param newType the new type
	 * @param newName the new name
	 * @param newDescription the new description
	 * @param newAuthor the new author
	 * @param newRating the new rating
	 * @param newCategories the new categories
	 * @param newCountries the new countries
	 * @param newDevices the new devices
	 * @param newPrice the new price
	 * @param newLanguages the new languages
	 * @param newImageURL the new image url
	 * @param newSize the new size
	 */
	public Product(String newType, String newName, String newDescription, String newAuthor, int newRating, String newCategories, String newCountries, String newDevices, float newPrice, String newLanguages, URL newImageURL, int newSize){
				type = newType;
				name = newName;
				description = newDescription;
				author = newAuthor;
				rating = newRating;
				categories = newCategories;
				countries = newCountries;
				devices = newDevices;
				price = newPrice;
				languages = newLanguages;
				imageURL = newImageURL;
				size = newSize;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getType()
	 */
	public String getType(){
		return type;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getName()
	 */
	public String getName(){
		return name;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getDescription()
	 */
	public String getDescription(){
		return description;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getAuthor()
	 */
	public String getAuthor(){
		return author;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getRating()
	 */
	public int getRating(){
		return rating;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getCategories()
	 */
	public String getCategories(){
		return categories;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getCountries()
	 */
	public String getCountries(){
		return countries;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getDevices()
	 */
	public String getDevices(){
		return devices;
	}

	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getPrice()
	 */
	public float getPrice(){
		return price;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getLanguages()
	 */
	public String getLanguages(){
		return languages;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getImageURL()
	 */
	public URL getImageURL(){
		return imageURL;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getSize()
	 */
	public int getSize(){
		return size;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#text()
	 */
	public String text(){
		return name + " " + description;
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#print()
	 */
	public void print(){
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Author: " + author);
		System.out.println("Content type: " + type);
		System.out.println("Category: " + categories);
		System.out.println("Rating: " + rating);
		System.out.println("Price: " + price);
		System.out.println("Countries: " + countries);
		System.out.println("Languages: " + languages);
		System.out.println("Devices: " + devices + "\n");
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#printCascade()
	 */
	public void printCascade() {
		print();
	}
	
	/* (non-Javadoc)
	 * @see cscie97.asn3.ecommerce.collection.Collectable#getIterator()
	 */
	public Iterator getIterator() {
		return new NullIterator();
	}
}
