import java.util.ArrayList;

public class Overlap {
	private static ArrayList<String> results = new ArrayList<>();

	public static String checkOverlap() {
		System.out.println("Checking...");
		if (Info.listOfCompounds.size() > 1) {

			for (int x = 0; x < Info.listOfCompounds.size() - 1; x++) {
				for (int y = x + 1; y < Info.listOfCompounds.size(); y++) {
					ArrayList<String> arr1 = Info.listOfCompounds.get(x).getAidList();
					ArrayList<String> arr2 = Info.listOfCompounds.get(y).getAidList();
					for (int z = 0; z < arr1.size(); z++) {
						for (int a = 0; a < arr2.size(); a++) {
							if (arr1.get(z).equals(arr2.get(a))) {
								results.add("The Bioassay AID number: " + arr1.get(z) + " is in common in both "
										+ Info.listOfCompounds.get(x).getName() + " and "
										+ Info.listOfCompounds.get(y).getName());
							}
						}
					}
				}
			}

		}
		if (results.size() == 0)
			return "No Overlaps!";
		else

			return results.toString();
	}
}
