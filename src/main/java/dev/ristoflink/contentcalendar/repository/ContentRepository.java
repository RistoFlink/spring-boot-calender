package dev.ristoflink.contentcalendar.repository;

import dev.ristoflink.contentcalendar.model.Content;
import dev.ristoflink.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    //don't yet understand why this does not work.. some import missing maybe?
    //List<Content> findAllByContains(String keyword);
    //manually defining the query does work though
   @Query("""
        SELECT * FROM Content WHERE status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
