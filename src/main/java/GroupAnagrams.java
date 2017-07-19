/**
 * TODO: comment here
 */

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49- Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class GroupAnagrams {


	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String,List<String>> anaGramsMap = new HashMap<String, List<String>>();

		List<List<String>> result = new ArrayList<List<String>>();

		for (String s : strs) {


			String normalized = normalize(s);

			List<String> anas = anaGramsMap.get(normalized);

			if (anas == null) {

				anas = new ArrayList<String>();
				anaGramsMap.put(normalized,anas);

			}

			anas.add(s);

		}

		result.addAll(anaGramsMap.values());

		return result;

	}

	private static String normalize(String original) {

		char[] chars = original.toCharArray();

		Arrays.sort(chars);

		return new String(chars);
	}

	public static void main(String[] args) {

		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};


		System.out.println(groupAnagrams(strs));


	}


}
