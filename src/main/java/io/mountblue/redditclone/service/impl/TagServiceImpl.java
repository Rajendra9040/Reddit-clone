package io.mountblue.redditclone.service.impl;

import io.mountblue.redditclone.entity.Tag;
import io.mountblue.redditclone.repository.TagRepository;
import io.mountblue.redditclone.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Set<String> findAllTags() {
        return tagRepository.findAllTags();
    }
}
