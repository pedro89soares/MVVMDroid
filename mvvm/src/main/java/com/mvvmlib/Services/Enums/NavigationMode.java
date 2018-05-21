package com.mvvmlib.Services.Enums;

public enum NavigationMode {
    Normal(1),

    ClearTop(2),

    ClearStack(3);

    private int value;

    NavigationMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
