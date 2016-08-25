import java.util.ArrayList;

public class RelatedCompoundObject {

	private String nameOfCompound;
	private ArrayList<String> aidList;

	public RelatedCompoundObject(String name, ArrayList<String> aidList) {
		nameOfCompound = name;
		this.aidList = aidList;
	}

	public String getName() {
		return nameOfCompound;
	}

	public ArrayList<String> getAidList() {
		return aidList;
	}
}
