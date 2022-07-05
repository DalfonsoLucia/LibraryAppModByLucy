package com.aesys.libraryapp.reservation.repository;

import com.aesys.libraryapp.reservation.data.model.Reservation;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String>, JpaSpecificationExecutor<Reservation> {

}
