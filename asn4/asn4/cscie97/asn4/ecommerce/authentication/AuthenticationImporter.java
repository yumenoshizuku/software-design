package cscie97.asn4.ecommerce.authentication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.UUID;

/**
 * The Class AuthenticationImporter.
 * @author Fanxing Meng
 * @version 1.2 2013/11/20
 */
public class AuthenticationImporter {
	
	/**
	 * Import authentication file.
	 *
	 * @param fileName the file name
	 * @param token the token
	 * @throws ImportException the import exception
	 */
	public static void importAuthenticationFile(String fileName, UUID token) throws ImportException {
        int lineNumber = 0;
        String CurrentLine = "";
		try{
			File inputFile = new File(fileName);
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader reader = new BufferedReader(fileReader);
			String inputText = null;
			while((inputText = reader.readLine()) != null){
                lineNumber++;
				String[] inputLine = inputText.split("[\\n]");
				for(String currentLine : inputLine){
					if(currentLine.length()!=0 && !currentLine.startsWith("#")){
						String[] inputToken = currentLine.split("(?<!\\\\),\\s*", -1);
						if(inputToken[0].equalsIgnoreCase("define_service")) {
							if(inputToken.length == 4) {
								Authentication.getInstance().defineService(inputToken[1], inputToken[2], inputToken[3], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("define_service", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else if(inputToken[0].equalsIgnoreCase("define_permission")) {
							if(inputToken.length == 5) {
								Authentication.getInstance().definePermission(inputToken[1], inputToken[2], inputToken[3], inputToken[4], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("define_permission", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else if(inputToken[0].equalsIgnoreCase("define_role")) {
							if(inputToken.length == 4) {
								Authentication.getInstance().defineRole(inputToken[1], inputToken[2], inputToken[3], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("define_role", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else if(inputToken[0].equalsIgnoreCase("add_entitlement_to_role")) {
							if(inputToken.length == 3) {
								Authentication.getInstance().addEntitlementToRole(inputToken[1], inputToken[2], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("add_entitlement_to_role", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else if(inputToken[0].equalsIgnoreCase("create_user")) {
							if(inputToken.length == 3) {
								Authentication.getInstance().createUser(inputToken[1], inputToken[2], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("create_user", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else if(inputToken[0].equalsIgnoreCase("add_credential")) {
							if(inputToken.length == 4) {
								Authentication.getInstance().addCredential(inputToken[1], inputToken[2], inputToken[3], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("add_credential", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else if(inputToken[0].equalsIgnoreCase("add_entitlement_to_user")) {
							if(inputToken.length == 3) {
								Authentication.getInstance().addEntitlementToUser(inputToken[1], inputToken[2], token, inputToken[0]);
							} else {
								ImportException ie = new ImportException("add_entitlement_to_user", "invalid argument number");
	                            ie.setErrorContent(CurrentLine);
	                            ie.setLineNumber(lineNumber);
	                            throw ie;
							}
						} else {
							throw new ImportException("Undefined action " + inputToken[0]);
						}
					}
				}
			}
			reader.close();
		} catch (Exception e) {
            ImportException ie = new ImportException("authentication", e);
            ie.setErrorContent(CurrentLine);
            ie.setLineNumber(lineNumber);
            throw ie;
        }
	}
}
