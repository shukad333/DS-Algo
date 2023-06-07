package com.general.geeks.misc;

public class SentenceScreenFitting {


    public static void main(String[] args) {

        System.out.println(wordsTyping(new String[]{"ab","cd"},2,10));
    }


    /**
     *
     * ab cd ab
     * cd ab cd
     *
     * @param sentence
     * @param rows
     * @param cols
     * @return
     */
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }
}
