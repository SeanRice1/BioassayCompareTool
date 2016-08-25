import java.util.Scanner;

public class MainView {
	static boolean tryAgain = true;
	
	public static void main(String[] args) {
		
		Reader reader = new Reader();
		Overlap overlap = new Overlap();
		
		
		//C:/Users/Sean Rice/Downloads/F2019-1326/686970.json/	-	F2019-1234

		while(tryAgain){
			addNewBioassays();
			getAIDs();
			tryAgain();
			
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to find the overlap between these two folders? (Y/N)");
		
		if(scanner.nextLine().equalsIgnoreCase("y")){
			System.out.println(Overlap.checkOverlap());
		}
		
	}
	public static void addNewBioassays(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the location of the folder with the JSON files");
		String loc1 = scanner.nextLine();
		System.out.println("Enter the name of the compound that these bioassays belong to");
		String name1 = scanner.nextLine();
		Reader.parseData(loc1, name1);
		
	}
	public static void getAIDs(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to get all the bioassay IDs for this compound (Y/N)");
		String input = scan.nextLine();
		if(input.equalsIgnoreCase("y")){
			System.out.println(Info.listOfCompounds
					.get(Info.listOfCompounds.size()-1).getAidList().toString());
		}
	}
	public static void tryAgain(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to add another set of Bioassays? (Y/N)");
		String input = scan.nextLine();
		if(input.equalsIgnoreCase("n")){
			tryAgain = false;
		}
	}

}
