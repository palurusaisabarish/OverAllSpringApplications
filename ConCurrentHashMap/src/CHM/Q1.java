package CHM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q1 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new ConcurrentHashMap<>();
		
		map.put("A",1);
		map.put("B", 2);
		map.put("C", 3);
		
		for(Map.Entry<String,Integer> m : map.entrySet()) {
			
			System.out.println(m.getKey()+" "+m.getValue());
			map.remove("B");
		}
		
//		        List<String> list = new CopyOnWriteArrayList<>();
//		        list.add("A");
//		        list.add("B");
//		        list.add("C");
//
//		        // Trying to modify the list while iterating over it
//		        for (String item : list) {
//		            System.out.println(item);
//		            // Modifying the list during iteration
//		            list.remove("B");  // This will throw ConcurrentModificationException
//		        }
		 

	}

}
