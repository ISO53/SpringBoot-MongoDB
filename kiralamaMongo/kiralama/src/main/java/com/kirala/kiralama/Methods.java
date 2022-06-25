package com.kirala.kiralama;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Type-C
 */
public class Methods {

    public static boolean isBetween(String basTarih, String bitTarih, String tarih) {

        Date basDate = null;
        Date bitDate = null;
        Date date = null;

        try {
            basDate = new SimpleDateFormat("dd.MM.yyyy").parse(basTarih);
            bitDate = new SimpleDateFormat("dd.MM.yyyy").parse(bitTarih);
            date = new SimpleDateFormat("dd.MM.yyyy").parse(tarih);
        } catch (ParseException ex) {
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (date.compareTo(basDate) >= 0) && (date.compareTo(bitDate) <= 0);
    }

}
