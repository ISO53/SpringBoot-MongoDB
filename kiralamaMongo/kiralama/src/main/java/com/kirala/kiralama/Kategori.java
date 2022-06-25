package com.kirala.kiralama;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Type-C
 */
@Document(collection = "KategoriBilgileri")
public class Kategori {
    
    private String kategori;

    public Kategori(String kategori) {
        this.kategori = kategori;
    }

    public Kategori() {
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
}
