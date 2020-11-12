package com.willfp.studentmanager.work;

public enum Performance {
    GOOD(2),
    OKAY(1),
    BAD(0);

    private final int asInt;

    Performance(int asInt) {
        this.asInt = asInt;
    }

    public int getAsInt() {
        return asInt;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "asInt=" + asInt +
                '}';
    }
}
