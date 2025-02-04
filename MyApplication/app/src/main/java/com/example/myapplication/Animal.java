package com.example.myapplication;

public class Animal {
    private int id;
    private String nombre;
    private String descripcion;
    private int imgResourceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public Animal(int id, String nombre, String descripcion, int imgResourceId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgResourceId = imgResourceId;
    }
}
