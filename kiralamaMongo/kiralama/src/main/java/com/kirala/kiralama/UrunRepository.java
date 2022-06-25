package com.kirala.kiralama;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Type-C
 */
@Repository
public interface UrunRepository extends MongoRepository<Urun, String>{
    
}
