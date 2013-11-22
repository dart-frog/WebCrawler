
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class WordCounter {

	/**
	 * counts the number of words in a hashmap
	 * @param list words that you would like to count
	 * @param write a hashmap to store counts
	 * @return a counted hashmap
	 */
	public static HashMap reader(ArrayList<String> list, HashMap write) {
		int noon = 0;
		for (int i = 0; i < list.size(); i++){
			if(write.containsKey(list.get(i))){
				try {
					noon = Integer.parseInt(write.get(list.get(i)).toString());
				} catch(NumberFormatException e) {
					System.out.println("\"" + list.get(i) + "\"");
					throw e;
				}
				noon++;
				write.remove(list.get(i));
				write.put(list.get(i), noon);
			}
			else{
				if(isLegit(list.get(i))){ 
				//String low = list.get(i).toLowerCase();
				String low = list.get(i);
				write.put(low, 1);
				}
			}
		}
		return write;
		
		

	}
	private static boolean isLegit(String input){
		char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
		for	(int j = 0; j< input.length(); j++){
			for (int i = 0; i< nums.length; i++){
				if (input.charAt(j) == nums[i]){
					return false;
				}
				
			}
		}
		if (input.equals("-")){
			return false;
		}
		if (input.equals("")){
			return false;
		}
		
		return true;
		
	}

}
