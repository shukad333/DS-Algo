package com.general.geeks.misc;

/**
 * We are given a personal information string S, which may represent either an
 * email address or a phone number.
 * 
 * We would like to mask this personal information according to the following
 * rules:
 * 
 * 
 * 1. Email address:
 * 
 * We define a name to be a string of length ≥ 2 consisting of only lowercase
 * letters a-z or uppercase letters A-Z.
 * 
 * An email address starts with a name, followed by the symbol '@', followed by
 * a name, followed by the dot '.' and followed by a name.
 * 
 * All email addresses are guaranteed to be valid and in the format of
 * "name1@name2.name3".
 * 
 * To mask an email, all names must be converted to lowercase and all letters
 * between the first and last letter of the first name must be replaced by 5
 * asterisks '*'.
 * 
 * 
 * 2. Phone number:
 * 
 * A phone number is a string consisting of only the digits 0-9 or the
 * characters from the set {'+', '-', '(', ')', ' '}. You may assume a phone
 * number contains 10 to 13 digits.
 * 
 * The last 10 digits make up the local number, while the digits before those
 * make up the country code. Note that the country code is optional. We want to
 * expose only the last 4 digits and mask all other digits.
 * 
 * The local number should be formatted and masked as "***-***-1111", where 1
 * represents the exposed digits.
 * 
 * To mask a phone number with country code like "+111 111 111 1111", we write
 * it in the form "+***-***-***-1111". The '+' sign and the first '-' sign
 * before the local number should only exist if there is a country code. For
 * example, a 12 digit phone number mask should start with "+**-".
 * 
 * Note that extraneous characters like "(", ")", " ", as well as extra dashes
 * or plus signs not part of the above formatting scheme should be removed.
 * 
 * 
 * 
 * Return the correct "mask" of the information provided.
 * 
 * @author skadavath
 *
 */
public class MaskingPersonalInformation {
	
	public static void main(String[] args) {
		
		System.out.println(new MaskingPersonalInformation().maskPII("1(234)567-890"));
	}

	 public String maskPII(String S) {
	        if (isEmail(S))
	            return maskEmail(S);
	        else
	            return maskPhone(S);
	    }
	    
	    private boolean isEmail(String s) {
	        for (char c : s.toCharArray()) {
	            if (c == '@') {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    private String maskEmail(String S) {
	        StringBuilder stringBuilder = new StringBuilder();
	        stringBuilder.append(S.toLowerCase().charAt(0));
	        for (int i = 0; i < 5; i++) {
	            stringBuilder.append('*');
	        }
	        boolean beforeAt = true;
	        for (int i = 0; i < S.length(); i++) {
	            if (beforeAt) {
	                if (S.charAt(i + 1) == '@') {
	                    stringBuilder.append(S.toLowerCase().charAt(i));
	                    beforeAt = false;
	                }
	            } else {
	                stringBuilder.append(S.toLowerCase().charAt(i));
	            }
	        }
	        return stringBuilder.toString();
	    }

	    private String maskPhone(String S) {
	        String pureNumbers = getNumbers(S);
	        StringBuilder res = new StringBuilder();
	        int i = 0;
	        if (pureNumbers.length() > 10) {
	            res.append('+');
	            for (; i < pureNumbers.length() - 10; i++) {
	                res.append('*');
	            }
	            res.append('-');
	        }

	        int count = 0;
	        for (; i < pureNumbers.length(); i++) {
	            if (count < 2) {
	                for (int j = 0; j < 3; j++) {
	                    res.append('*');
	                    ++i;
	                }
	                res.append('-');
	                --i;
	                ++count;
	            } else {
	                res.append(pureNumbers.charAt(i));
	            }
	        }
	        return  res.toString();
	    }

	    private String getNumbers(String S) {
	        StringBuilder stringBuilder = new StringBuilder();
	        for (int i = 0; i < S.length(); i++) {
	            char c = S.charAt(i);
	            if (c >= 48 && c <= 57)
	                stringBuilder.append(c);
	        }
	        return stringBuilder.toString();
	    }

}
