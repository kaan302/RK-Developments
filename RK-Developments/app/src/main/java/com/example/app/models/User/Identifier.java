package com.example.app.models.User;

public interface Identifier<T> {
    T getId();
    void setId(T id);
}
