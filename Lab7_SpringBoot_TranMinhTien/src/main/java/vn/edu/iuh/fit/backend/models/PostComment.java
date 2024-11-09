package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private PostComment parent;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @ColumnDefault("0")
    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @Lob
    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User idUser;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments = new LinkedHashSet<>();


    public PostComment(Post post, PostComment parent, String title, Boolean published, Instant createdAt, Instant publishedAt, String content) {
        this.post = post;
        this.parent = parent;
        this.title = title;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }
}