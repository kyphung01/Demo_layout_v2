package vn.thai.demolayout.model;

/**
 * Created by ngoquan on 4/24/2016.
 */
public class Data {
    private int image;
    private String name;
    private String author;

    public Data() {}
    public Data(int image, String name, String author) {
        this.image = image;
        this.name = name;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
