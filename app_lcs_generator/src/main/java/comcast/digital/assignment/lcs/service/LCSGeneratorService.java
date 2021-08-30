package comcast.digital.assignment.lcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import comcast.digital.assignment.lcs.model.LCS;
import comcast.digital.assignment.lcs.model.LCSResponse;

@Service
public class LCSGeneratorService {

	public LCSResponse getLongestCommonString(Set<String> uniqueSet) {
		
        String array[] = uniqueSet.toArray(new String[0]);
		String result = findLongestCommonString(array);
		LCS lcs = new LCS();
		lcs.setValue(result);
		List<LCS> list = new ArrayList<LCS>();
		list.add(lcs);
		return new LCSResponse(list);
	}

	public static String findLongestCommonString(String arr[]) {
		// Determine size of the array
		int n = arr.length;
		// Take first word from array as reference
		String s = arr[0];
		int len = s.length();
		String res = "";
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				/*
				 * generating all possible substrings of our reference string arr[0] i.e s
				 */
				String str = s.substring(i, j);
				int k = 1;
				for (k = 1; k < n; k++)
					// Check if the generated stem is common to all words
					if (!arr[k].contains(str))
						break;
				/*
				 * If current substring is present in all strings and its length is greater than
				 * current result
				 */
				if (k == n && res.length() < str.length())
					res = str;
			}
		}
		return res;
	}
}
