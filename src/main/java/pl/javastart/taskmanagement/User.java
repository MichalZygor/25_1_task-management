package pl.javastart.taskmanagement;

public enum User {
    MICHAL("Michał"),
    KASIA("Kasia"),
    BARTOSZ("Bartuś"),
    ADAM("Adaś"),
    KRZYSZTOF("Krzysiu");

    private String displayName;

    User(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
