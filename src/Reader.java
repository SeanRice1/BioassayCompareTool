import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	private ArrayList<String> listOfBioassays = new ArrayList<>();
	private StringBuilder json = new StringBuilder();

	public void parseData(String input, String name) {

		File folder = new File(input);

		for (File fileEntry : folder.listFiles()) {
			listOfBioassays.add(readFiles(fileEntry.getAbsolutePath()));
		}

		makeObj(name, listOfBioassays);
	}

	private String readFiles(String location) {

		String aid = "";

		try {
			FileReader filereader = new FileReader(location);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			String temp = "";
			int count = 0;
			while ((temp = bufferedReader.readLine()) != null) {

				json.append(temp);
				json.append(System.lineSeparator());
				
				/*
				 * Not actually parsing the JSON because its too hard to parse 
				 * each entire file and as a result the JSON is being truncated 
				 * and not using proper syntax. I will find a solution to this eventually 
				 * but for now, this program only finds and compares id numbers from the 
				 * JSON files.
				 */
				if (temp.contains("id")) {
					count++;
					if (count == 2) {
						aid = temp.substring(16, temp.length() - 1);
						break;
					}
				}
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return aid;

	}

	private void makeObj(String name, ArrayList<String> bioassays) {
		Info.listOfCompounds.add(new RelatedCompoundObject(name, bioassays));

	}
}
