package com.aesys.libraryapp.reservation.service;

import com.aesys.libraryapp.reservation.data.dto.ReservationDto;
import com.aesys.libraryapp.reservation.repository.ReservationRepository;
import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserLibraryMapper mapper;

    @Override
    public ReservationDto getReservation(String id) {
        return reservationRepository.findById(id).map(reservation -> mapper.reservationToReservationDto(reservation)).get();
    }
}
