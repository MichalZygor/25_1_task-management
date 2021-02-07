package pl.javastart.taskmanagement;

public enum Status {
    TO_DO("Do zrobienia"),
    IN_PROGRESS("W realizacji"),
    PENDING("W oczekiwaniu"),
    DEFERRED("Odroczony"),
    COMPLETED("Zakończony"),
    CANCELLED("Anulowany");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
