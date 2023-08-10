package dev.ristoflink.contentcalendar.controller;

import dev.ristoflink.contentcalendar.model.Content;
import dev.ristoflink.contentcalendar.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    //in-memory representation of content - moving to a database later
    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    //CRUD - create, read, update, delete

    @ResponseStatus(HttpStatus.CREATED) //return a response 201 to show creation was successful
    @PostMapping("") //will respond to a POST request at /api/content | CREATE
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    //make a GET request and find all the pieces of content in the system | READ
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")//will respond to a GET request at /api/content/id | READ
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}") //will respond to a PUT request at api/content/id | UPDATE
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") //will respond to a DELETE request at api/content/id | DELETE
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
