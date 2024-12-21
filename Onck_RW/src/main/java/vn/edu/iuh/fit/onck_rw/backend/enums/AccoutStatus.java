package vn.edu.iuh.fit.onck_rw.backend.enums;

public enum AccoutStatus {
    CHECKING("CHECKING"), CHECKED("CHECKED");
    private final String value;

    AccoutStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
