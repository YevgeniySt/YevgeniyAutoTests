package com.blog.webservices.client;

import org.junit.Test;

/**
 * Created by Евгений on 17.10.2015.
 */
public class GetCities {

    @Test
    public void getCities(){
        GlobalWeatherStub globalWeatherStub = new GlobalWeatherStub();

        globalWeatherStub.getCitiesByCountry();
    }
}
