import java.util.ArrayList;
import java.util.List;


public class LoopTest {

	public static void main(String[] args) {

		int[] anArray = {1,2,3,4,5,6,7,8,9,10};
		
		
		List list1 = new ArrayList<Integer>();
		List list2 = new ArrayList<Integer>();

		for(Integer numbers : anArray){
			list1.add(numbers);
			list2.add(numbers);
		}
		
		List list1and2 = new ArrayList<Integer>();
		for(int i = 0; i < list1.size(); i++){
		
			//list1.add(i, 100);
			
			list1and2.add(list1.get(i));
			list1and2.add(list2.get(i));
			
			list1.remove(i);
			
			list1.add(i, 1);
		}
		System.out.println(list1and2);
	}

}
