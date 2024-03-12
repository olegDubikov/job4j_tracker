package ru.job4j.tracker.input;

public class Stub implements Input {
    private String[] answer;
    private int position = 0;

    public Stub(String[] answer) {
        this.answer = answer;
    }

    @Override
    public String askStr(String question) {
        return answer[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}