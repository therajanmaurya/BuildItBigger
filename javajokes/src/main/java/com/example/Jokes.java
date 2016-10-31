package com.example;

import java.util.ArrayList;

public class Jokes {

    private String joke = "This is awesome java joke, It's funny joke ohhh";
    private final int totalJokes;
    private ArrayList<String> jokes = new ArrayList<String>();
    public Jokes() {
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        jokes.add("This is awesome java joke, It's funny joke ohhh");
        jokes.add("This is awesome java joke, It's funny joke ohhhe");
        totalJokes = jokes.size();
    }


    public String getJoke() {
        int rand = (int) Math.ceil((totalJokes - 1) * Math.random());
        return jokes.get(rand);
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
