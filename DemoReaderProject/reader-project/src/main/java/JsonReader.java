import java.io.InputStream;
import java.util.Scanner;

public class JsonReader {
	
    public static String readFile(String fileLocation) {
		InputStream in = JsonReader.class.getClassLoader().getResourceAsStream(fileLocation);
		String content = "";
		try (Scanner scanner = new Scanner(in)) {
			content = scanner.useDelimiter("\\Z").next();
		}
		return content;
    }
    

}
