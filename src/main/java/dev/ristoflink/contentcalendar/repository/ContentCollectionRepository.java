package dev.ristoflink.contentcalendar.repository;

import dev.ristoflink.contentcalendar.model.Content;
import dev.ristoflink.contentcalendar.model.Status;
import dev.ristoflink.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        //checks if the id of the content equals the id given and returns the first occurrence of it
        //returns an optional
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content( 1,
                "My first post",
                "My first post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
    }
}
