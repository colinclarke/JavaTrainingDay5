package com.hcl.day5;

import java.util.HashMap;

import lombok.AllArgsConstructor;

public class App {
	public static void main(String[] args) {
		System.out.println("======== 1. ========");
		System.out.printf("Max character position for \"aaafbbbdeeeda\" is %d\n", maxCharacter("aaafbbbdeeeda"));
		System.out.printf("Max character position for \"eeddfssses\" is %d\n", maxCharacter("eeddfssses"));
	}

	static int maxCharacter(String s) {
		char[] c = s.toCharArray();
		HashMap<Character, Tuple> r = new HashMap<Character, Tuple>();
		int max = 0;
		Tuple temp;
		for (int i = 0; i < c.length; i++) {
			temp = r.putIfAbsent(c[i], new Tuple(0, i));
			if (temp != null) {
				r.replace(c[i], temp.increment());
				if (temp.amount > r.get(c[max]).amount) {
					max = temp.firstIndex;
				}
			}
		}
		return max;
	}
}

@AllArgsConstructor
class Tuple {
	public int amount;
	public int firstIndex;

	public Tuple increment() {
		this.amount++;
		return this;
	}
}
