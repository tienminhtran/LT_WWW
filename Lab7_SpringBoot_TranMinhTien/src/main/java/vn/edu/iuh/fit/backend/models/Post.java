package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Post parent;

    @Column(name = "title", nullable = false, length = 75)
    private String title;

    @Column(name = "metaTitle", length = 100)
    private String metaTitle;

    @Lob
    @Column(name = "summary")
    private String summary;

    @ColumnDefault("0")
    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "publishedAt")
    private Instant publishedAt;

    @Lob
    @Column(name = "content")
    private String content;

    public Post(Post parent, String title, String metaTitle, String summary, Instant createdAt, Boolean published, Instant updatedAt, Instant publishedAt, String content) {
        this.parent = parent;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = createdAt;
        this.published = published;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }


}