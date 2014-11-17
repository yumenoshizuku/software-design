package cscie97.asn4.test;

import cscie97.asn4.ecommerce.product.*;
import cscie97.asn4.ecommerce.authentication.*;
import cscie97.asn4.ecommerce.collection.*;

import java.util.UUID;

/**
 * Test Driver class, testing the authentication service module with five test input files.</p>
 * @author Fanxing Meng
 * @version 4.3 2013/11/20
 */
public class TestDriver{

	/**
	 * The main method that takes five command-line arguments specifying the files to be fed into different Importer classes
	 *
	 * @param args command-line arguments specifying authentication file, country file, device file, product file, and collection file
	 */
	public static void main(String[] args){
		
		UUID token;
		try {	
			token = Authentication.getInstance().login("admin", "admin");
			Authentication.getInstance().changePassword(token, "newStrongPassword");
			AuthenticationImporter.importAuthenticationFile(args[0], token);
			Authentication.getInstance().logout("admin");
			
			token = Authentication.getInstance().login("sam", "secret");
			ProductImporter.importCountryFile(args[1], token);
			ProductImporter.importDeviceFile(args[2], token);
			Authentication.getInstance().logout("sam");
			
			token = Authentication.getInstance().login("joe", "1234");
			ProductImporter.importProductFile(args[3], token);
			Authentication.getInstance().logout("joe");
			
			token = Authentication.getInstance().login("lucy", "4567");
			CollectionImporter.importCollectionFile(args[4], token);
			Authentication.getInstance().logout("lucy");
			
			UserData.getInstance().accept(new PrintVisitor());
			ServiceData.getInstance().accept(new PrintVisitor());
			EntitlementData.getInstance().accept(new PrintVisitor());
		} catch (ImportException ex) {
			System.out.println(ex);
			System.exit(1);
		} catch(InvalidAccessTokenException ex) {
			System.out.println(ex);
		} catch(AccessDeniedException ex) {
			System.out.println(ex);
		}
	}
}
