package com.example.user.starwars;

import com.example.user.starwars.pojo.Person;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }



    @Test
    public void ttttest() {
        Person p = new Person();
        p.setName("2");
        c(p);
        assertEquals("1", p.getName());
    }


    private void c(Person p) {
        p.setName("1");
    }
}