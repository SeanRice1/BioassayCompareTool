import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Overlap {
	private static HashMap<Integer, String> results = new HashMap<>();

	public static String checkOverlap() {
		System.out.println("Checking...");
		if (Info.listOfCompounds.size() > 1) {

			for (int x = 0; x < Info.listOfCompounds.size() - 1; x++) {
				ArrayList<String> arr1 = Info.listOfCompounds.get(x).getAidList();
				ArrayList<String> arr2 = Info.listOfCompounds.get(x + 1).getAidList();
				for (int z = 0; z < arr1.size(); z++) {
					boolean alreadyDone = false;
					for (int a = 0; a < arr2.size(); a++) {

						if (arr1.get(z).equals(arr2.get(a))) {
							if (!alreadyDone) {

								if (!results.containsKey(Integer.parseInt(arr1.get(z)))) {
									results.put(Integer.parseInt(arr1.get(z)),
											" is mutual between " + Info.listOfCompounds.get(x).getName() + ", "
													+ Info.listOfCompounds.get(x + 1).getName());
								} else {
									String temp = results.get(Integer.parseInt(arr1.get(z)));
									results.remove(Integer.parseInt(arr1.get(z)));
									results.put(Integer.parseInt(arr2.get(a)),
											temp + ", " + Info.listOfCompounds.get(x + 1).getName());
								}

								alreadyDone = true;
							}

							else {
								String temp = results.get(Integer.parseInt(arr1.get(z)));
								results.remove(Integer.parseInt(arr1.get(z)));
								results.put(Integer.parseInt(arr2.get(a)),
										temp + ", " + Info.listOfCompounds.get(x + 1).getName());
							}

						
					}}
				}
			}

		}
		if (results.size() == 0)
			return "No Overlaps!";
		else
			return results.toString();
	}
}
