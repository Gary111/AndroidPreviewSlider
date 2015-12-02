package com.igortyulkanov.previewslider.example.models;

import java.io.Serializable;
import java.util.Date;

public class PhotoInfo implements Serializable {

    private String url;
    private Date date;

    public PhotoInfo() {
    }

    public PhotoInfo(String url, Date date) {
        this.url = url;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public Date getDate() {
        return date;
    }
}
