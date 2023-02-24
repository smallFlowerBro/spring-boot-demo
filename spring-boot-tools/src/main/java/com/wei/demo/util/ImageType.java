package com.wei.demo.util;

public enum ImageType {
    PNG("PNG"),
    JPG("JPG"),
    JPEG("JPEG");

    private String type;

    ImageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
