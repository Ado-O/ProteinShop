package com.example.user.lesson_android_development.data;

public class SingleVertical {
    private String header;
    private int image;

    public SingleVertical(String header, int image) {
        this.header = header;
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
