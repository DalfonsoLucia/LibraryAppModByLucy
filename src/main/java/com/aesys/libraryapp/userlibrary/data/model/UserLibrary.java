package com.aesys.libraryapp.userlibrary.data.model;

import com.aesys.libraryapp.reservation.data.model.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_library")
public class UserLibrary {

    @Id
    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "userLibrary", fetch = FetchType.EAGER)
    private Collection<Reservation> reservations;

}
