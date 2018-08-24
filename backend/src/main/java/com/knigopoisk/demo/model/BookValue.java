package com.knigopoisk.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookValue {
    int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {

        return value;
    }
}
