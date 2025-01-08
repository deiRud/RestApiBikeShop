package org.example;

public class Color {
    private String hexCode;
    private String imageName;

    public Color(String hexCode, String imageName) {
        this.hexCode = hexCode;
        this.imageName = imageName;
    }

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
