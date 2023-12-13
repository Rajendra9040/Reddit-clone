package io.mountblue.redditclone.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "created_at")
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Column(name = "image_name")
    String image;

    @Column(name = "vote_count")
    Integer voteCount = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "photo_name")
    String photoName;

    @Column(name = "photo_type")
    String photoType;

    @Column(name = "photo_link")
    String photoLink;

    @Column(name = "photo_size")
    Long photoSize;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<Bookmark> bookmarkList;

    public Integer getCount(List<Comment> commentList){
        return commentList.size();
    }

    @ManyToMany()
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tag> tagList = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post")
    List<Comment> commentList;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "subreddit_id")
    SubReddit subReddit;

    @OneToMany(mappedBy="post", cascade = CascadeType.ALL)
    List<VotePost> votePosts;

    @OneToMany(mappedBy="post", cascade = CascadeType.ALL)
    List<VoteComment> voteComments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public Long getPhotoSize() {
        return photoSize;
    }

    public void setPhotoSize(Long photoSize) {
        this.photoSize = photoSize;
    }

    public List<Bookmark> getBookmarkList() {
        return bookmarkList;
    }

    public void setBookmarkList(List<Bookmark> bookmarkList) {
        this.bookmarkList = bookmarkList;
    }

    public Set<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(Set<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public SubReddit getSubReddit() {
        return subReddit;
    }

    public void setSubReddit(SubReddit subReddit) {
        this.subReddit = subReddit;
    }

    public List<VotePost> getVotePosts() {
        return votePosts;
    }

    public void setVotePosts(List<VotePost> votePosts) {
        this.votePosts = votePosts;
    }

    public List<VoteComment> getVoteComments() {
        return voteComments;
    }

    public void setVoteComments(List<VoteComment> voteComments) {
        this.voteComments = voteComments;
    }
}
