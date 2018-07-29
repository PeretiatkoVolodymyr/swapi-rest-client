package com.swapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.swapi.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

public class SimpleTest {

    private Gson gson;

    @Before
    public void setUp() {
        gson = new GsonBuilder().create();
    }

    @Test
    public void simpleTest() throws IOException {

        People people1 = gson.fromJson(HttpUtils.sendRequest("https://swapi.co/api/people/1/"), People.class);

        Assert.assertEquals("Luke Skywalker", people1.getName());


        Planet planet = gson.fromJson(HttpUtils.sendRequest(people1.getHomeWorldUrl()), Planet.class);

        Assert.assertEquals("Tatooine", planet.getName());
        Assert.assertEquals("200000", planet.getPopulation());

    }
}
