package vaibhao.vk;

import java.util.HashSet;
import java.util.Set;

class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<>();

		int left = 0;
		int maxLength = 0;

		// right pointer moves forward
		for (int right = 0; right < s.length(); right++) {

			// If duplicate character found
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++; // shrink window
			}

			set.add(s.charAt(right));

			// Calculate max length
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(str)); // Output: 3
	}
}
