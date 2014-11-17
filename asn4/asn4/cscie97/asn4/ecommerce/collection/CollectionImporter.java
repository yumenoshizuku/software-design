/**
 * 
 */
package cscie97.asn4.ecommerce.collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.UUID;

/**
 * @author albert
 * @date Nov 12, 2013
 */
public class CollectionImporter {
	
	/**
	 * An importCollectionFile method that takes collections' data file's path
	 * and user password as arguments and breaks down each line of valid data
	 * and calls CollectionData.defineCollection or CollectionData.addCollectionContent
	 * or CollectionData.setDynamicCriteria method depending on collection type.
	 *
	 * @param fileName collections' data file in csv format
	 * @param pass the password provided by the user from the main function
	 */
	public static void importCollectionFile(String fileName, UUID token){
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length()!=0 && !currentLine.startsWith("#")){
						String[] inputToken = currentLine.split("(?<!\\\\),\\s*", -1);
						if(inputToken[0].equalsIgnoreCase("define_collection") && inputToken[1]!=null && inputToken[2]!=null && inputToken[3]!=null && inputToken[4]!=null) {
							CollectionData.defineCollection(inputToken[1], inputToken[2], inputToken[3], inputToken[4], token);
						} else if(inputToken[0].equalsIgnoreCase("add_collection_content") && inputToken[1]!=null && inputToken[2]!=null && inputToken[3]!=null) {
							CollectionData.addCollectionContent(inputToken[1], inputToken[2], inputToken[3], token);
						} else if(inputToken[0].equalsIgnoreCase("set_dynamic_criteria") && inputToken[1]!=null && inputToken[2]!=null && inputToken[3]!=null && inputToken[4]!=null && inputToken[5]!=null && inputToken[6]!=null && inputToken[7]!=null && inputToken[8]!=null && inputToken[9]!=null) {
							CollectionData.setDynamicCriteria(inputToken[1], inputToken[2] + ", " + inputToken[3] + ", " + inputToken[4] + ", " + inputToken[5] + ", " + inputToken[6] + ", " + inputToken[7] + ", " + inputToken[8] + ", " + inputToken[9], token);
						} else if(inputToken[0].equalsIgnoreCase("search_collection") && inputToken[1]!=null) {
							CollectionData.searchCollections(inputToken[1]);
						}else {
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
