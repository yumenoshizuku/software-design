package cscie97.asn4.ecommerce.product;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * The Class QueryEngine queries information of products on category list, text search, minimum
  * rating, max price, language list, country code, device id, and content
  * type list. The query can be an input string or string in a .csv file.</p>
  * 
  * @author Fanxing Meng
  * @version 3.1 2013/10/30
 */
public class QueryEngine{

	/**
	 * An executeQuery method that takes a query line and all instances of
	 * data maps as argument. Returns a map of products that satisfy all search
	 * criteria.
	 *
	 * @param queryLine		a line of csv format query string in which non-empty fields denote search criteria
	 * @return result	   	a product map that contains only products that satisfy all search fields
	 */
	public static Map<String, Product> executeQuery(String queryLine){
		Map<String, Product> result = new HashMap<String, Product>(ProductData.getInstance());
		Iterator<Map.Entry<String, Product>> iter = result.entrySet().iterator();
		String[] inputToken = queryLine.split("\\,\\s|\\,", -1);
		try {
			for(int i = 0; i < inputToken.length; i++){
				if(!inputToken[i].isEmpty()){
					switch(i){
						case 0:
							iter = result.entrySet().iterator();
							while (iter.hasNext()){
								Map.Entry<String, Product> entry = iter.next();
								String[] options = inputToken[0].split("\\|");
								for(int j = 0; j < options.length; j++) {
									if(entry.getValue().getCategories().toLowerCase().contains(options[j].toLowerCase()))
										break;
									else if(j == options.length - 1)
										iter.remove();
								}
							}
							break;
						case 1:
							iter = result.entrySet().iterator();
							while (iter.hasNext()){
								Map.Entry<String, Product> entry = iter.next();
								String[] options = inputToken[1].split("\\|");
								for(int j = 0; j < options.length; j++) {
									if(entry.getValue().text().toLowerCase().contains(options[j].toLowerCase()))
										break;
									else if(j == options.length - 1)
										iter.remove();
								}
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
								String[] options = inputToken[4].split("\\|");
								for(int j = 0; j < options.length; j++) {
									if(entry.getValue().getLanguages().toLowerCase().contains(options[j].toLowerCase()))
										break;
									else if(j == options.length - 1)
										iter.remove();
								}
							}
							break;
						case 5:
							iter = result.entrySet().iterator();
							while (iter.hasNext()){
								Map.Entry<String, Product> entry = iter.next();
								String[] options = inputToken[5].split("\\|");
								for(int j = 0; j < options.length; j++) {
									if(entry.getValue().getCountries().toLowerCase().contains(options[j].toLowerCase()))
										break;
									else if(j == options.length - 1)
										iter.remove();
								}
							}
							break;
						case 6:
							iter = result.entrySet().iterator();
							while (iter.hasNext()){
								Map.Entry<String, Product> entry = iter.next();
								String[] options = inputToken[6].split("\\|");
								for(int j = 0; j < options.length; j++) {
									if(entry.getValue().getDevices().toLowerCase().contains(options[j].toLowerCase()))
										break;
									else if(j == options.length - 1)
										iter.remove();
								}
							}
							break;
						case 7:
							iter = result.entrySet().iterator();
							while (iter.hasNext()){
								Map.Entry<String, Product> entry = iter.next();
								String[] options = inputToken[7].split("\\|");
								for(int j = 0; j < options.length; j++) {
									if(entry.getValue().getType().toLowerCase().contains(options[j].toLowerCase()))
										break;
									else if(j == options.length - 1)
										iter.remove();
								}
							}
							break;
						default:
							throw new Exception("Invalid number of query fields.");
					}
				}
			}
		} catch(Exception ex){
			System.out.println("Exception: " + ex);
		}
	return result;
	}

	/**
	 * An executeQueryFile method that takes a query file and all instances of
	 * data maps as argument. Calls executeQuery method on each valid line of
	 * query and prints the results together with its query line.
	 *
	 * @param fileName		a csv format query file containing multiple query string in which non-empty fields denote search criteria
	 */
	public static void executeQueryFile(String fileName){
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
						foundMap = executeQuery(currentLine);
						Iterator<Map.Entry<String, Product>> iter = foundMap.entrySet().iterator();
						while (iter.hasNext()){
							Map.Entry<String, Product> entry = iter.next();
							System.out.println(currentLine);
							System.out.println("Product ID: " + entry.getKey());
							entry.getValue().print();
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
