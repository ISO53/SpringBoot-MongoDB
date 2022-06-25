package com.kirala.kiralama;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Type-C
 */

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/Urun")
public class UrunController {

    @Autowired
    private UrunRepository urunRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Urun>> getAllUruns(@RequestParam(required = false) String title) {
        return new ResponseEntity<>(urunRepository.findAll(), HttpStatus.CREATED);
    }

    @GetMapping("/getByID/{id}")
    public Urun getUrunById(@PathVariable("id") String id) {
        Optional<Urun> kullaniciData = urunRepository.findById(id);
        if (kullaniciData.isPresent()) {
            return kullaniciData.get();
        } else {
            return null;
        }
    }

    @GetMapping("/getByInfo/{basTarih}/{bitTarih}/{sehir}/{kategori}")
    public List<Urun> getUrunByInf(@PathVariable("basTarih") String basTarih,
            @PathVariable("bitTarih") String bitTarih,
            @PathVariable("sehir") String sehir,
            @PathVariable("kategori") String kategori) {
        
        System.out.println("adasdasdsadsadsadasdasddsa");
        
        List<Urun> allUruns = urunRepository.findAll();
        List<Urun> returnUruns = new ArrayList<>();
        
        for (Urun urun : allUruns) {
            if (!(urun.getKategori().equals(kategori) || kategori.equals("Default"))) {
                continue;
            }
            if (!(urun.getSehir().equals(sehir) || sehir.equals("Default"))) {
                continue;
            }
            if (!Methods.isBetween(basTarih, bitTarih, urun.getTarih())) {
                continue;
            }
            returnUruns.add(urun);
        }
        return returnUruns;
    }

    @PostMapping("/create")
    public ResponseEntity<Urun> createUrun(@RequestBody Urun urun) {
        try {
            Urun _urun = urunRepository.save(new Urun(
                    urun.getUrunId(),
                    urun.getIsim(),
                    urun.getAciklama(),
                    urun.getFotograf(),
                    urun.getTarih(),
                    urun.getKategori(),
                    urun.getFiyat(),
                    true,
                    urun.getSehir()
            ));
            return new ResponseEntity<>(_urun, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Urun> updateUrun(@PathVariable("id") String id, @RequestBody Urun urun) {
        Optional<Urun> urunData = urunRepository.findById(id);
        if (urunData.isPresent()) {
            Urun _urun = urunData.get();
            _urun.setUrunId(urun.getUrunId());
            _urun.setIsim(urun.getIsim());
            _urun.setAciklama(urun.getAciklama());
            _urun.setFotograf(urun.getFotograf());
            _urun.setTarih(urun.getTarih());
            _urun.setKategori(urun.getKategori());
            _urun.setFiyat(urun.getFiyat());
            _urun.setPublished(urun.getPublished());
            return new ResponseEntity<>(urunRepository.save(_urun), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<HttpStatus> deleteUrun(@PathVariable("id") String id) {
        try {
            urunRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllUruns() {
        try {
            urunRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
