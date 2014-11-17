package cscie97.asn3.test;

import cscie97.asn3.ecommerce.product.*;
import cscie97.asn3.ecommerce.collection.*;
import java.util.Iterator;

/**
 * Test Driver class, testing the collection service module with five test input files.</p>
 * @author Fanxing Meng
 * @version 3.3 2013/10/30
 */
public class TestDriver{

	/**
	  * The main method that takes five command-line arguments specifying the files to be fed into an Importer class
	  * and run several searches and iterations over existing collections
	 *
	 * @param args command-line arguments specifying country file, device file, product file, query file, and collection file
	 */
	public static void main(String[] args){
		Importer.importCountryFile(args[0], "pass");
		Importer.importDeviceFile(args[1], "pass");
		Importer.importProductFile(args[2], "pass");
		QueryEngine.executeQueryFile(args[3]);
		Importer.importCollectionFile(args[4], "pass");
		CollectionData.searchCollections("sport");
		iterateAll();
		iterateCollection("sports_collection");
		printCollection("sports_collection");
	}
	
	/**
	 * Iterate through all collections using a default iterator. This is not a depth-first traversal
	 * but going through the entire list of collections.
	 */
	public static void iterateAll() {
		System.out.println("Going over all collections:");
		Iterator iter = CollectionData.getIterator();
		while (iter.hasNext()) {
			Collectable coll = (Collectable)iter.next();
					coll.print();
		}
	}
	
	/**
	 * Iterate within a collection, using depth-first traversal.
	 *
	 * @param collectionId the id of collection that is to be traversed 
	 */
	public static void iterateCollection(String collectionId) {
		System.out.println("Iterating through " + collectionId + ":");
		Iterator iter = CollectionData.getInstance().get(collectionId).getIterator();
		while (iter.hasNext()) {
			Collectable coll = (Collectable)iter.next();
					coll.print();
		}
	}
	
	/**
	 * Prints a collection and all its child products and collections, using printCascade()
	 * which has an iterator built in that traverses within this collection.
	 *
	 * @param collectionId the id of collection that is to be printed recursively 
	 */
	public static void printCollection(String collectionId) {
		System.out.println("Printing all children of " + collectionId + ":");
		CollectionData.getInstance().get(collectionId).printCascade();
	}
}