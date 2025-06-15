package user.example.user.model.enums;

public enum ResponseStatus {
    SUCCESS("Başarılı"),
    FAILURE("Başarısız");

    private final String description;

    private ResponseStatus(String description) {
        this.description = description;
    }
}
