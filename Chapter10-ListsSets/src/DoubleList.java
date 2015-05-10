import java.util.ArrayList;
import java.util.List;


public class DoubleList {
	public void doubleList(List<String> input){
		List<String > copyList = new ArrayList<String> (); 
		for (int i = 0; i < input.size(); i++) {
			 
			String copy  =  input.get(i);
			copyList.add(copy);
			copyList.add(copy);
		}
		System.out.println(copyList);
	}
}
