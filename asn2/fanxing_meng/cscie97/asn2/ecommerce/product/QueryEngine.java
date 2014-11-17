package cscie97.asn2.ecommerce.product;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
  * <p>QueryEngine</p>
  * <p>Queries information of products on catgory list, text search, minimum
  * rating, max price, language list, country code, device id, and content
  * type list. The query can be an input string or string in a csv file.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class QueryEngine{
/**
  * <p>An executeQuery method that takes a query line and all instances of
  * data maps as argument. Returns a map of products that satisfy all search
  * criteria.
  *
  * @param queryLine	a line of csv format query string in which non-empty fields denote search criteria
  * @param country 		the instance of countryMap
  * @param device 		the instance of deviceMap
  * @param product 		the instance of productMap
  *
  * @return	result	   	a product map that contains only products that satisfy all search fields
  *
  * @see executeQueryFile
  */
	public static Map<String, Product> executeQuery(String queryLine, Map<String, List<String>> country, Map<String, List<String>> device, Map<String, Product> product){
		Map<String, Product> result = new HashMap<String, Product>(product);
		Iterator<Map.Entry<String, Product>> iter = result.entrySet().iterator();
		String[] inputToken = queryLine.split("\\,\\s|\\,");
		for(int i = 0; i < inputToken.length; i++){
			if(!inputToken[i].isEmpty()){
				switch(i){
					case 0:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(!entry.getValue().getCatagories().toLowerCase().contains(inputToken[0].toLowerCase()))
								iter.remove();
						}
						break;
					case 1:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(!entry.getValue().text().toLowerCase().contains(inputToken[1].toLowerCase()))
								iter.remove();
						}
						break;
					case 2:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(entry.getValue().getRating() < Integer.parseInt(inputToken[2]))
								iter.remove();
						}
						break;
					case 3:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(entry.getValue().getPrice() > Float.parseFloat(inputToken[3]))
								iter.remove();
						}
						break;
					case 4:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(!entry.getValue().getLanguages().toLowerCase().contains(inputToken[4].toLowerCase()))
								iter.remove();
						}
						break;
					case 5:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(!entry.getValue().getCountries().toLowerCase().contains(inputToken[5].toLowerCase()))
								iter.remove();
						}
						break;
					case 6:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(!entry.getValue().getDevices().toLowerCase().contains(inputToken[6].toLowerCase()))
								iter.remove();
						}
						break;
					case 7:
						iter = result.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							if(!entry.getValue().getType().toLowerCase().contains(inputToken[7].toLowerCase()))
								iter.remove();
						}
						break;
					default:
						System.out.println("Invalid number of query fields.");
				}
			}
		}
	return result;
	}

/**
  * <p>An executeQueryFile method that takes a query file and all instances of
  * data maps as argument. Calls executeQuery method on each valid line of
  * query and prints the results together with its query line.
  *
  * @param fileName		a csv format query file containing multiple query string in which non-empty fields denote search criteria
  * @param country 		the instance of countryMap
  * @param device 		the instance of deviceMap
  * @param product 		the instance of productMap
  *
  * @return	null
  *
  * @see executeQuery
  */	
	public static void executeQueryFile(String fileName, Map<String, List<String>> country, Map<String, List<String>> device, Map<String, Product> product){
		Map<String, Product> foundMap = new HashMap<String, Product>();
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length() != 0 && !currentLine.startsWith("#")){
						foundMap = executeQuery(currentLine, country, device, product);
						Iterator<Map.Entry<String, Product>> iter = foundMap.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							System.out.println(currentLine);
							System.out.println("Product ID: " + entry.getKey() + "\n" + entry.getValue().show());
							System.out.println();
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
