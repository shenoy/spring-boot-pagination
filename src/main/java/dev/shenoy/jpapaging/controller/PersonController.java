package dev.shenoy.jpapaging.controller;

import dev.shenoy.jpapaging.model.Person;
import dev.shenoy.jpapaging.model.PersonsRequest;
import dev.shenoy.jpapaging.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/api/hello")
    public ResponseEntity<List<String>> getHello(){
        return new ResponseEntity<List<String>>(List.of("hello","world"), HttpStatus.OK);
    }

    @GetMapping("/api/people")
    public ResponseEntity<Page<Person>> findAll(@RequestParam("page") int page, @RequestParam("size") int size){
        System.out.println("request - -----------"+  page + "   " + size);
        logger.info("page...{},size...{}", page,size);


        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept");
        PageRequest pr = PageRequest.of(page, size);
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(personRepository.findAll(pr));
    }
}
