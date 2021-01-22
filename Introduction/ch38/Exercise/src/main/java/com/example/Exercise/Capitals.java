package com.example.Exercise;

public class Capitals {
    private String[] countries;
    private String[] capitals;
    private String answer;

    private int idx;

    public Capitals(){
        countries = new String[]{"China", "American", "France"};
        capitals = new String[]{"Beijing", "Washington", "Paris"};
        idx = 0;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getCapitals() {
        return capitals;
    }

    public String[] getCountries() {
        return countries;
    }

    public int getIdx() {
        return idx;
    }

    public String judge() {
        int pre = idx;
        idx = (idx+1)%capitals.length;
        return answer.equals(capitals[pre]) ? "Yes, you are right":
                "No, the capital of " + countries[pre] + " is " + capitals[pre];
    }
}
