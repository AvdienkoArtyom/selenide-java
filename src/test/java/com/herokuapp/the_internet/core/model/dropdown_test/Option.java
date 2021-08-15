package com.herokuapp.the_internet.core.model.dropdown_test;

public enum Option {
    OPTION_1(1, "Option 1"),
    OPTION_2(2, "Option 2");

    private final int position;
    private final String text;

    Option(int position, String text) {
        this.position = position;
        this.text = text;
    }

    public int getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Option{" +
                "position=" + position +
                ", text='" + text + '\'' +
                '}';
    }
}
