package dev.aj.junit5testing.util;

public enum Title {

    MR ("Mr"), MRS ("Mrs"), MS ("Ms"), OTHER ("Other");
    private String title;

    Title(String title) {
        this.title = title;
    }

    public String getValue() {
        return this.toString();
    }
}
