package com.example.karim.robabikia;

/**
 * Created by karim on 9/03/2018.
 */

public class Post {
    String title;
    String des;
    String date;

    String urlToImage;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }


    public Post() {
    }

    public Post(String title, String des, String date, String urlToImage) {
        this.title = title;
        this.des = des;
        this.date = date;

        this.urlToImage = urlToImage;
    }
}
