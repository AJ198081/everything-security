package dev.aj.junit5testing.util.car;

public enum Model {
    NEW ("new"), OLD ("old"), LEGACY("legacy");

    private String model;

    Model(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }
}
