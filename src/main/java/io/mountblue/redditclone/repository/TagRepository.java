package io.mountblue.redditclone.repository;

import io.mountblue.redditclone.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag,Integer> {

    Tag findByName(String name);

    @Query("SELECT t.name FROM Tag t")
    Set<String> findAllTags();
}
