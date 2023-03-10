package com.example.backend.models.User;

public interface Identifiable<T> {
    T getId();
    void setId(T id);
}
