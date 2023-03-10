package com.example.backend.models.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.boot.model.naming.Identifier;

import java.time.LocalDateTime;

@Entity
@Table(name = User.TABLE_NAME)
public class User implements Identifiable<Long> {
    public static final String TABLE_NAME = "User";

    public User() {

    }

    public User(Long id, String name, String email, LocalDateTime createdAt, String password, Type user_type, String profileImage, String profileText) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.password = password;
        this.user_type = user_type;
        this.profileImage = profileImage;
        this.profileText = profileText;
    }

    public enum Type {
        CLIENT,
        ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "user_password", nullable = true, columnDefinition = "varchar(255)")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false, columnDefinition = "varchar(255) default 'PERSON'")
    private User.Type user_type;


    @Column(name = "profile_image", nullable = true)
    private String profileImage;

    @Column(name = "profile_text", nullable = true)
    private String profileText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getUser_type() {
        return user_type;
    }

    public void setUser_type(Type user_type) {
        this.user_type = user_type;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileText() {
        return profileText;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }
}
