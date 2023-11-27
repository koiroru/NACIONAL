package com.example.nacional;

public class Peliculas {
    private String Nombre;
    private String Director;
    private String Sipnosis;
    private String Opinion;
    private String Calificacion;

    public Peliculas()
    {
        this.Nombre="";
        this.Director="";
        this.Sipnosis="";
        this.Opinion="";
        this.Calificacion="";
    }

    public Peliculas( String Nombre, String Director, String Sipnosis,String Opinion, String Calificacion  )
    {
        this.Nombre=Nombre;
        this.Director=Director;
        this.Sipnosis=Sipnosis;
        this.Opinion=Opinion;
        this.Calificacion=Calificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getSipnosis() {
        return Sipnosis;
    }

    public void setSipnosis(String Sipnosis) {
        this.Sipnosis = Sipnosis;
    }
    public String getOpinion() {
        return Opinion;
    }

    public void setOpinion(String Opinion) {
        this.Opinion = Opinion;
    }
    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String Calificacion) { this.Calificacion = Calificacion; }

    @Override
    public String toString() {
        return "Pelicula: {" +
                "Nombre: ='" + Nombre + '\'' +
                ", Director: ='" + Director + '\'' +
                ", Sipnosis: ='" + Sipnosis + '\'' +
                ", Opinion: ='" + Opinion + '\'' +
                ", Calificacion: ='" + Calificacion + '\'' +
                '}';
    }

}
