package com.hcl.day5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class App {
	public static void main(String[] args) {
		System.out.println("======== 1. ========");
		System.out.printf("Max character position for \"aaafbbbdeeeda\" is %d\n", maxCharacter("aaafbbbdeeeda"));
		System.out.printf("Max character position for \"eeddfssses\" is %d\n", maxCharacter("eeddfssses"));
		System.out.printf("Max character position for \"abcdefghijklmnopqrstuvwxyz\" is %d\n",
				maxCharacter("abcdefghijklmnopqrstuvwxyz"));
		System.out.println("======== 2. ========");
		System.out.printf("Is \"racecar\" a palindrome? %s\n", isPalindrome("racecar") ? "Yes" : "No");
		System.out.println("======== 3. ========");
		System.out.printf("Is (((())))[{<>}] balanced? %s\n", isBalanced("(((())))[{<>}]") ? "Yes" : "No");
		System.out.printf("Is {{{{}}} balanced? %s\n", isBalanced("{{{{}}}") ? "Yes" : "No");
		System.out.printf("Is [[{}])] balanced? %s\n", isBalanced("[[{}])]") ? "Yes" : "No");
		System.out.printf("Is [[]]]]]] balanced? %s\n", isBalanced("[[{}])]") ? "Yes" : "No");
		System.out.println("======== 4. ========");
		System.out.println("Solved on HackerRank");
		System.out.println("======== 5. ========");
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(91, "Jim"));
		students.add(new Student(94, "John"));
		students.add(new Student(85, "Connor"));
		students.add(new Student(80, "Ben"));
		students.add(new Student(55, "Tim"));
		students.add(new Student(97, "Nick"));
		System.out.println("Unsorted students:");
		System.out.println(students);
		System.out.println("Sorted students using overridden comparable interface:");
		Collections.sort(students);
		System.out.println(students);
		System.out.println("======== 6. ========");
		System.out.printf("Sum to 99: %d\n", sumToN(99));
		System.out.printf("Sum to 100: %d\n", sumToN(100));
		System.out.printf("Sum to 101: %d\n", sumToN(101));
	}

	static int maxCharacter(String s) {
		char[] c = s.toCharArray();
		HashMap<Character, Tuple> r = new HashMap<Character, Tuple>();
		Tuple temp;
		for (int i = 0; i < c.length; i++) {
			temp = r.putIfAbsent(c[i], new Tuple(1, i));
			if (temp != null) {
				r.replace(c[i], temp.increment());
			}
		}
		int ret = Tuple.max == null ? 0 : Tuple.max.firstIndex;
		Tuple.max = null;
		return ret;
	}

	static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != c[c.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	static boolean isBalanced(String string) {
		char[] cs = string.toCharArray();
		char open;
		ArrayDeque<Character> deque = new ArrayDeque<Character>();
		for (char c : cs) {
			if (c == '(' || c == '[' || c == '{' || c == '<') {
				deque.addFirst(c);
			} else {
				try {
					open = deque.removeFirst();
				} catch (Exception e) {
					return false;
				}
				if (open == '(') {
					if (c == ')') {
						continue;
					}
					return false;
				} else {
					if (c != open + 2) {
						return false;
					}
				}
			}
		}
		return deque.isEmpty() ? true : false;
	}

	static int sumToN(int n) {
		return (n * (n + 1)) / 2;
	}
}

@AllArgsConstructor
@NoArgsConstructor
class Tuple {
	public static Tuple max;
	public int amount;
	public int firstIndex;

	public Tuple increment() {
		this.amount++;
		if (max == null || this.amount > max.amount) {
			max = this;
		}
		return this;
	}
}
