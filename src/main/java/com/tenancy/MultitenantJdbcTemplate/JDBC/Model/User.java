package com.tenancy.MultitenantJdbcTemplate.JDBC.Model;

public class User{

    public String id;
    public String name;
    public String rol;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public User(String id, String name, String rol) {
        this.id = id;
        this.name = name;
        this.rol = rol;
    }

}