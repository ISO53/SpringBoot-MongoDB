package com.kirala.kiralama;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author termi
 */
@CrossOrigin
@RestController
@RequestMapping("/Kategori")
public class KategoriController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Kategori>> getAllKategoris(@RequestParam(required = false) String title) {
        return new ResponseEntity<>(kategoriRepository.findAll(), HttpStatus.OK);
    }

}
