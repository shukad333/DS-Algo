package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a C++ program, remove comments from it. The program source is an array
 * where source[i] is the i-th line of the source code. This represents the
 * result of splitting the original source code string by the newline character
 * \n.
 * 
 * In C++, there are two types of comments, line comments, and block comments.
 * 
 * @author skadavath
 *
 */
public class RemoveComments {

	public static void main(String[] args) {
		String[] input = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
				"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		List<String> resp = new RemoveComments().removeComments(input);
		System.out.println(resp);
	}

	public List<String> removeComments(String[] source) {

		List<String> resp = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean multiComment = false;
		for (String line : source) {

			for (int i = 0; i < line.length(); i++) {

				if (multiComment) {
					if (line.charAt(i) == '*' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
						multiComment = false;
						i++;
					}
				} else {
					if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
						break;
					}

					else if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '*') {
						multiComment = true;
						i++;

					} else
						sb.append(line.charAt(i) + "");

				}
			}
			if(!multiComment && sb.length()>0) {
			resp.add(sb.toString());
			sb = new StringBuilder();
			}

		}
		return resp;
	}

}
