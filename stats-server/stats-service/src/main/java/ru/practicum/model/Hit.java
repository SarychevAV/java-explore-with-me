package ru.practicum.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "app")
    String app;
    @Column(name = "uri")
    String uri;
    @Column(name = "ip")
    String ip;
    @Column(name = "date")
    LocalDateTime date;

    public Hit(String app, String uri, String ip, LocalDateTime date) {
        this.app = app;
        this.uri = uri;
        this.ip = ip;
        this.date = date;
    }
}
