package vn.edu.iuh.fit.entities;

public enum IsGrant {
    diasable(0), enable(1);

    private int value;

    private IsGrant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IsGrant{" +
                "value=" + value +
                '}';
    }
}
