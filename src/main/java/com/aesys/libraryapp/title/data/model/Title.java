package com.aesys.libraryapp.title.data.model;

import com.aesys.libraryapp.reservation.data.model.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "title")
public class Title {

    @Id
    @Column(name = "title_id")
    private String titleId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "title", fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Reservation> reservations;

}
