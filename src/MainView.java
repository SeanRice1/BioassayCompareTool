import java.io.File;
import java.util.Scanner;

public class MainView {
	static boolean tryAgain = true;

	public static void main(String[] args) {

		Overlap overlap = new Overlap();

		// test example: C:/Users/Sean Rice/Downloads/bioassays - F2019-1234

		addNewBioassays();
		getAIDs();
		runOverlaps();

	}

	public static void runOverlaps(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to find the overlap between these folders? (Y/N)");

		if (scanner.nextLine().equalsIgnoreCase("y")) {
			System.out.println(Overlap.checkOverlap());
		}
	}
	public static void addNewBioassays() {
		System.out.println("Consolidate all of the JSON bioassay files into folders named by the "
				+ "the compound they are show active in, and the put all of the folders into a main folder");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the location of the main folder");
		String loc1 = scanner.nextLine();

		parseFolders(loc1);

	}

	public static void parseFolders(String mainFolderLocationString) {

		File mainFolderLocation = new File(mainFolderLocationString);

		for (File folder : mainFolderLocation.listFiles()) {
			String location = folder.getAbsolutePath();
			new Reader().parseData(location);
		}
	}

	public static void getAIDs() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to get the number of bioassay IDs for each of these compounds (Y/N)");
		String input = scan.nextLine();
		if (input.equalsIgnoreCase("y")) {
			for (RelatedCompoundObject obj : Info.listOfCompounds) {
					System.out.println(obj.getName() + " contains the following number of Bioassays: " + obj.getAidList().size());
			}
		}
	}


}
