package io.mountblue.redditclone.service;

import org.springframework.ui.Model;
import io.mountblue.redditclone.entity.Post;
import io.mountblue.redditclone.entity.Tag;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {

    void createNewPost(Post post,Integer subredditId,String username,String tagNames);

    Post findById(Integer userId);

    List<Post> findBySubRedditId(Integer subRedditId);

    List<Post> getFilteredPostsByKeywordAndTags(String keyword, List<String> tags);

    void updatePost(Post updatedPost,Integer postId, String tagNames);

    void deletePost(Integer postId);

    boolean checkUserAuthorized(UserDetails userDetails, Integer postId);

    String getCommaSeperatedTags(Integer postId);

    List<Post> findAllPosts();

    void updatePost(Integer postId, Integer voteCountChange);

    List<Post> findAllBySubscribedSubReddits(String username);

    List<Post> findAllOrderByVoteCountDesc(Model model, int pageNumber);

    List<Post> findAllPostsOrderedByCommentsSizeDesc();

    List<Post> findAllOrderByCreatedAtDesc();

    List<Post> findAllOrderByCreatedAt();

    List<Post> findPostsBySearchQuery(String query);
    Integer getPostsByUserInSubRedditInLast24Hours(String username, String subRedditName, LocalDateTime startDate);
}
