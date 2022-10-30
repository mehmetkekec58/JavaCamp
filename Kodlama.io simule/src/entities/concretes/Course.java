package entities.concretes;

import core.entities.concretes.Entity;

public class Course extends Entity {
    private String name;
    private double price;
    private int categoryId;
    private int educatorId;

    public Course() {

    }

    public Course(int id, String name, double price, int categoryId, int educatorId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.educatorId = educatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(int educatorId) {
        this.educatorId = educatorId;
    }


}
