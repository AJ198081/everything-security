package dev.aj.junit5testing.util.car;

public enum Category {
    SMALL ("Small"), MEDIUM ("Medium"), LARGE("large");
    private String category;

    Category(String cateory) {
        this.category = cateory;
    }

    public String getCategory() {
        return this.category;
    }

}
