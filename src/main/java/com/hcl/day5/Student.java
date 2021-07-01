package com.hcl.day5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student implements Comparable<Student> {
	int score;
	String name;

	@Override
	public int compareTo(Student o) {
		return this.score - o.getScore();
	}
}
