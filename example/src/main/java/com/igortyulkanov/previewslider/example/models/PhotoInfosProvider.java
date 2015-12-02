package com.igortyulkanov.previewslider.example.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PhotoInfosProvider {

    private static final String BASE_URL = "http://lorempixel.com/400/400/sports/";

    public static List<PhotoInfo> generate() {
        final List<PhotoInfo> result = new ArrayList<>();

        final Random random = new Random();
        final Calendar calendar = Calendar.getInstance();

        for (int i = 0 ; i < 100; i++) {
            final String url = BASE_URL + (random.nextInt(10) + 1) + "/";
            calendar.add(Calendar.DATE, random.nextInt(31));
            final Date date = calendar.getTime();
            result.add(new PhotoInfo(url, date));
        }

        return result;
    }

}
