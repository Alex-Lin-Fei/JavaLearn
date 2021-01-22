package com.example.Exercise;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

public class Quiz {
    private Question[] questions;
    private int[] answers = new int[10];

    public Quiz() {
        questions = new Question[10];
        for (int i = 0; i < 10; i++)
            questions[i] = new Question();
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }

    public int[] getAnswers() {
        return answers;
    }

    public static class Question {
        private int addend1;
        private int addend2;
        private int sum;

        public Question() {
            Random random = new Random();
            addend1 = random.nextInt(100);
            addend2 = random.nextInt(100);
            sum = addend1 + addend2;
        }

        public String getAddend1() {
            String val = String.valueOf(addend1);
            return val.length() < 2? val+" " : val;
        }

        public String getAddend2() {
            String val = String.valueOf(addend2);
            return val.length() < 2 ? val + " ": val;
        }

        public int getSum() {
            return sum;
        }
    }
}

