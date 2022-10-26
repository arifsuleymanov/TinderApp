package com.entity;

public class CurrentUser {
    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        CurrentUser.id = id;
    }

}
