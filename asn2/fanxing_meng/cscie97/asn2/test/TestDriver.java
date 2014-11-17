package cscie97.asn2.ecommerce.test;

import cscie97.asn2.ecommerce.product.*;
/**
  * <p>Test Driver</p>
  * <p>Testing the product API service module with four test input files.</p>
  * @author Fanxing Meng
  * @version 2.3 2013/10/08
  */
public class TestDriver{
/**
  * <p>A main function that does not return any value.
  * It takes four command-line arguments specifying the files to be fed into an Importer class
  * and run a QueryEngine to search for products satisfying all search fields.</p>
  *
  * @param args[0]				a country file path to be supplied from command line
  * @param args[1] 				a device file path to be supplied from command line
  * @param args[2]  			a product file path to be supplied from command line
  * @param args[3]  			a query file path to be supplied from command line
  *
  * @return		   				null
  *
  * @see Importer
  * @see QueryEngine
  */
	public static void main(String[] args){
		Importer.importCountryFile(args[0], "pass");
		Importer.importDeviceFile(args[1], "pass");
		Importer.importProductFile(args[2], "pass");
		QueryEngine.executeQueryFile(args[3], CountryData.getInstance(), DeviceData.getInstance(), ProductData.getInstance());
	}
}
