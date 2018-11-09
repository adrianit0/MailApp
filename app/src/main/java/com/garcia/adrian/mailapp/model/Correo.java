package com.garcia.adrian.mailapp.model;

public class Correo {

    private String sujeto;
    private String titulo;
    private String cuerpo;

    private int color;

    private final int CARACTERES_CUERPO_RESUMEN = 60;
    private final int CARACTERES_TITULO_RESUMEN = 30;

    public Correo (String sujeto, String titulo, String cuerpo) {
        this.sujeto = sujeto;
        this.titulo = titulo;
        this.cuerpo = cuerpo;

        ////TODO: Incluir color aleatorio
    }

    public String getSujeto() {
        return sujeto;
    }

    public void setSujeto(String sujeto) {
        this.sujeto = sujeto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getCaracter () {
        if (sujeto.isEmpty()) {
            return "";
        }

        return sujeto.charAt(0)+"";
    }

    public String getTituloResumen () {
        if (titulo.length()<=CARACTERES_TITULO_RESUMEN)
            return titulo;

        return titulo.substring(0, CARACTERES_TITULO_RESUMEN) + "...";
    }

    public String getCuerpoResumen () {
        if (cuerpo.length()<=CARACTERES_CUERPO_RESUMEN)
            return cuerpo;

        return cuerpo.substring(0, CARACTERES_CUERPO_RESUMEN) + "...";
    }
}
