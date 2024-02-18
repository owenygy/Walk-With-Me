package com.example.walkwithme;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.jar.Manifest;

public class MainActivityTest {

    @Test
    public void isCorrect() throws IOException {
        assertEquals(new User(1, "admin@anu.edu.au" , "admin", "",
                "", "", 20, "", 5, ""), MainActivity.users.get(0));
    }
}
