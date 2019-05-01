package com.smartdroidesign.projectapp_recyclerview2;

public class Items {

    private String imageURL;
    private String textOne;
    private String textTwo;

    public Items(String textOne, String textTwo) {
        this.textOne = textOne;
        this.textTwo = textTwo;
    }

    public Items(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTextOne() {
        return textOne;
    }

    public String getTextTwo() {
        return textTwo;
    }

    public void setTextOne(String textOne) {
        this.textOne = textOne;
    }

    public void setTextTwo(String textTwo) {
        this.textTwo = textTwo;
    }
}
