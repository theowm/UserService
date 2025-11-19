package me.theowm.usermicroservice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "dislikes")
public class Dislike {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID uuid;
    //@Column(nullable=false)
    //private String userUuid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "uuid")
    private User user;

    //@Column(nullable=false)
    //private String mediaUuid;

    @Column(nullable = false)
    private UUID mediaUuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public String getMediaUuid() {
        return mediaUuid;
    }

    public void setMediaUuid(String mediaUuid) {
        this.mediaUuid = mediaUuid;
    } */

    public UUID getMediaUuid() {
        return mediaUuid;
    }

    public void setMediaUuid(UUID mediaUuid) {
        this.mediaUuid = mediaUuid;
    }

    public Dislike() {
    }
}
