package com.colaboraai.colaboraai.Model;

public class PointOfInterest {
    private String id;
    private String titulo;
    private String latitude;
    private String longitude;

    public PointOfInterest(String id, String titulo, String latitude, String longitude) {
        this.id = id;
        this.titulo = titulo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
