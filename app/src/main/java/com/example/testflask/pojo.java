package com.example.testflask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pojo {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("kalori")
    @Expose
    private Integer kalori;
    @SerializedName("lemak")
    @Expose
    private Integer lemak;
    @SerializedName("kolesterol")
    @Expose
    private Integer kolesterol;
    @SerializedName("natrium")
    @Expose
    private Integer natrium;
    @SerializedName("kalium")
    @Expose
    private Integer kalium;
    @SerializedName("karbohidrat")
    @Expose
    private Integer karbohidrat;
    @SerializedName("protein")
    @Expose
    private Integer protein;
    @SerializedName("vitamin_a")
    @Expose
    private Integer vitaminA;
    @SerializedName("vitamin_c")
    @Expose
    private Double vitaminC;
    @SerializedName("vitamin_d")
    @Expose
    private Integer vitaminD;
    @SerializedName("vitamin_b6")
    @Expose
    private Double vitaminB6;
    @SerializedName("vitamin_b12")
    @Expose
    private Double vitaminB12;
    @SerializedName("kalsium")
    @Expose
    private Integer kalsium;
    @SerializedName("zat_besi")
    @Expose
    private Double zatBesi;
    @SerializedName("magnesium")
    @Expose
    private Integer magnesium;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getKalori() {
        return kalori;
    }

    public void setKalori(Integer kalori) {
        this.kalori = kalori;
    }

    public Integer getLemak() {
        return lemak;
    }

    public void setLemak(Integer lemak) {
        this.lemak = lemak;
    }

    public Integer getKolesterol() {
        return kolesterol;
    }

    public void setKolesterol(Integer kolesterol) {
        this.kolesterol = kolesterol;
    }

    public Integer getNatrium() {
        return natrium;
    }

    public void setNatrium(Integer natrium) {
        this.natrium = natrium;
    }

    public Integer getKalium() {
        return kalium;
    }

    public void setKalium(Integer kalium) {
        this.kalium = kalium;
    }

    public Integer getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(Integer karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(Integer vitaminA) {
        this.vitaminA = vitaminA;
    }

    public Double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(Double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public Integer getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(Integer vitaminD) {
        this.vitaminD = vitaminD;
    }

    public Double getVitaminB6() {
        return vitaminB6;
    }

    public void setVitaminB6(Double vitaminB6) {
        this.vitaminB6 = vitaminB6;
    }

    public Double getVitaminB12() {
        return vitaminB12;
    }

    public void setVitaminB12(Double vitaminB12) {
        this.vitaminB12 = vitaminB12;
    }

    public Integer getKalsium() {
        return kalsium;
    }

    public void setKalsium(Integer kalsium) {
        this.kalsium = kalsium;
    }

    public Double getZatBesi() {
        return zatBesi;
    }

    public void setZatBesi(Double zatBesi) {
        this.zatBesi = zatBesi;
    }

    public Integer getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Integer magnesium) {
        this.magnesium = magnesium;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}