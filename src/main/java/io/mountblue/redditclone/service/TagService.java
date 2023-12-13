package io.mountblue.redditclone.service;

import io.mountblue.redditclone.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface TagService {
    Set<String> findAllTags();
}
