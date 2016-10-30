package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Rajan Maurya on 30/10/16.
 */
public class JokesTest {

    private Jokes jokes;
    private String joke = "This is awesome java joke, It's funny joke ohhh";

    @Before
    public void setUp() throws Exception {
        jokes = new Jokes();
        jokes.setJoke(joke);
    }

    @After
    public void tearDown() throws Exception {
        jokes = null;
    }

    @Test
    public void getJoke() throws Exception {
        assert jokes.getJoke().length() != 0;
        assertEquals(jokes.getJoke(), joke);
    }
}