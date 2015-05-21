
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Test {

	public static void main(String[] args){

		String[] anArray = {"Copenhagen", "Liverpool", "Etc"};
		
		
		List list = new ArrayList<String>();
		for(String cities : anArray){
			list.add(cities);
		}
		
		
		test(list);

	
	
	}

	public static void test(List<String> list){
		try {
			
				PrintWriter writer = new PrintWriter("text.txt", "UTF-16");

			list.remove(1);
			for(String cities : list){
				writer.println(cities);
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		

		
	}

}
