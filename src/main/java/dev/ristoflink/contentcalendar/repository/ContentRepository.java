package dev.ristoflink.contentcalendar.repository;

import dev.ristoflink.contentcalendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
