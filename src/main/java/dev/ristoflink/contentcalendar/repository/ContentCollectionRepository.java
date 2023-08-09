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
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        //checks if the id of the content equals the id given and returns the first occurrence of it
        //returns an optional
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content c) {
        contentList.removeIf(con -> con.id().equals(c.id()));
        contentList.add(c);
    }
    //returns true if an id match is found in the content list
    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
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
        contentList.add(c);
    }
}
