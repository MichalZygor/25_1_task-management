package pl.javastart.taskmanagement;

public enum Category {
    HOME("Obowiązki domowe"),
    WORK("Praca"),
    SCHOOL("Szkoła i dzieci"),
    RELAX("Odpoczynek"),
    DEVELOPMENT("Rozwój osobisty"),
    VOLUNTEERING("Wolontariat"),
    OTHER("Inne");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
