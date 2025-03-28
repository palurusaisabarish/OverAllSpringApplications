package CHM;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Q2 {

	public static void main(String[] args) {
	
		HashMap<Integer,Integer> hs = new HashMap<>();
		
		hs.put(1, 40);
		hs.put(2, 10);
		hs.put(3, 30);
		
		Map<Integer, Integer> map = hs.entrySet().stream().sorted(Map.Entry.comparingByValue()).
				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e2,LinkedHashMap::new));
		
		System.out.println(map);
		
		List<Integer> list = Arrays.asList(9,2,21,3,4,4,5,6,1,8,9);
		
		list.stream().distinct().sorted().forEach((e) -> System.out.print(e+" "));
		System.out.println();
		list.stream().distinct().sorted(Collections.reverseOrder()).forEach((e) -> System.out.print(e+" "));
		System.out.println();
		list.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);;
	}

}
