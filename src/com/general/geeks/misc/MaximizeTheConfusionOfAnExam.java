package com.general.geeks.misc;

public class MaximizeTheConfusionOfAnExam {

    public static void main(String[] args) {

        MaximizeTheConfusionOfAnExam obj = new MaximizeTheConfusionOfAnExam();
        System.out.println(obj.maxConsecutiveAnswers("TTFFFTTT",2));

    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        return Math.max(max(answerKey,'T',k),max(answerKey,'F',k));
    }

    private int max(String ansKey , char ans,int k) {

        int j=0;
        for(int i=0;i<ansKey.length();i++) {
            k-=ansKey.charAt(i)!=ans?1:0;
            if(k<0) {
                k+=ansKey.charAt(j++)!=ans?1:0;
            }
        }

        return ansKey.length()-j;

    }
}
