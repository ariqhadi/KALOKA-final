package com.example.testflask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pojo {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("kalori")
    @Expose
    private String kalori;
    @SerializedName("lemak")
    @Expose
    private String lemak;
    @SerializedName("kolesterol")
    @Expose
    private String kolesterol;
    @SerializedName("natrium")
    @Expose
    private String natrium;
    @SerializedName("kalium")
    @Expose
    private String kalium;
    @SerializedName("karbohidrat")
    @Expose
    private String karbohidrat;
    @SerializedName("protein")
    @Expose
    private String protein;
    @SerializedName("vitamin_a")
    @Expose
    private String vitaminA;
    @SerializedName("vitamin_c")
    @Expose
    private String vitaminC;
    @SerializedName("vitamin_d")
    @Expose
    private String vitaminD;
    @SerializedName("vitamin_b6")
    @Expose
    private String vitaminB6;
    @SerializedName("vitamin_b12")
    @Expose
    private String vitaminB12;
    @SerializedName("kalsium")
    @Expose
    private String kalsium;
    @SerializedName("zat_besi")
    @Expose
    private String zatBesi;
    @SerializedName("magnesium")
    @Expose
    private String magnesium;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }

    public String getLemak() {
        return lemak;
    }

    public void setLemak(String lemak) {
        this.lemak = lemak;
    }

    public String getKolesterol() {
        return kolesterol;
    }

    public void setKolesterol(String kolesterol) {
        this.kolesterol = kolesterol;
    }

    public String getNatrium() {
        return natrium;
    }

    public void setNatrium(String natrium) {
        this.natrium = natrium;
    }

    public String getKalium() {
        return kalium;
    }

    public void setKalium(String kalium) {
        this.kalium = kalium;
    }

    public String getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(String karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA;
    }

    public String getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(String vitaminC) {
        this.vitaminC = vitaminC;
    }

    public String getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(String vitaminD) {
        this.vitaminD = vitaminD;
    }

    public String getVitaminB6() {
        return vitaminB6;
    }

    public void setVitaminB6(String vitaminB6) {
        this.vitaminB6 = vitaminB6;
    }

    public String getVitaminB12() {
        return vitaminB12;
    }

    public void setVitaminB12(String vitaminB12) {
        this.vitaminB12 = vitaminB12;
    }

    public String getKalsium() {
        return kalsium;
    }

    public void setKalsium(String kalsium) {
        this.kalsium = kalsium;
    }

    public String getZatBesi() {
        return zatBesi;
    }

    public void setZatBesi(String zatBesi) {
        this.zatBesi = zatBesi;
    }

    public String getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(String magnesium) {
        this.magnesium = magnesium;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}