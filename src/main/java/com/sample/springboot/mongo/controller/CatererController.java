package com.sample.springboot.mongo.controller;

import com.sample.springboot.mongo.model.Caterer;
import com.sample.springboot.mongo.repository.CatererRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author syedbilalraza
 * @date 22/05/2021
 */
@RestController
@RequestMapping(value = "/catSearch")
@Slf4j
public class CatererController {

  @Autowired
  private CatererRepository catererRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<Page<?>> getByName(@RequestParam("name") String name, Pageable pageable) {

       Page<Caterer> caterers= catererRepository.findByLocationCityName(name,pageable);
        log.info("name= "+name );
        return ResponseEntity.ok(caterers);
    }
}
