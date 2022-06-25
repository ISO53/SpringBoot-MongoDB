package com.kirala.kiralama;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Type-C
 */
@Document(collection = "UrunBilgileri")
public class Urun {
    
    @Id
    private Object urunId;
    private String isim;
    private String aciklama;
    private String fotograf;
    private String tarih;
    private String kategori;
    private Integer fiyat;
    private Boolean published;
    private String sehir;

    public Urun(Object urunId, String isim, String aciklama, String fotograf, String tarih, String kategori, Integer fiyat, Boolean published, String sehir) {
        this.urunId = urunId;
        this.isim = isim;
        this.aciklama = aciklama;
        this.fotograf = fotograf;
        this.tarih = tarih;
        this.kategori = kategori;
        this.fiyat = fiyat;
        this.published = published;
        this.sehir = sehir;
    }

    /**
     * @return the urunId
     */
    public Object getUrunId() {
        return urunId;
    }

    /**
     * @param urunId the urunId to set
     */
    public void setUrunId(Object urunId) {
        this.urunId = urunId;
    }

    /**
     * @return the isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * @param isim the isim to set
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * @return the aciklama
     */
    public String getAciklama() {
        return aciklama;
    }

    /**
     * @param aciklama the aciklama to set
     */
    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    /**
     * @return the fotograf
     */
    public String getFotograf() {
        return fotograf;
    }

    /**
     * @param fotograf the fotograf to set
     */
    public void setFotograf(String fotograf) {
        this.fotograf = fotograf;
    }

    /**
     * @return the tarih
     */
    public String getTarih() {
        return tarih;
    }

    /**
     * @param tarih the tarih to set
     */
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the fiyat
     */
    public Integer getFiyat() {
        return fiyat;
    }

    /**
     * @param fiyat the fiyat to set
     */
    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    /**
     * @return the published
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * @param published the published to set
     */
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * @return the sehir
     */
    public String getSehir() {
        return sehir;
    }

    /**
     * @param sehir the sehir to set
     */
    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
}
