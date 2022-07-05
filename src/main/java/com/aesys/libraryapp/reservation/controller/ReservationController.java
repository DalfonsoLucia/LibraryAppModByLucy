package com.aesys.libraryapp.reservation.controller;

import com.aesys.libraryapp.reservation.data.dto.Filter;
import com.aesys.libraryapp.reservation.data.dto.ReservationDto;
import com.aesys.libraryapp.reservation.data.mapper.ReservationMapper;
import com.aesys.libraryapp.reservation.data.model.Reservation;
import com.aesys.libraryapp.reservation.data.model.ReservationSpec;
import com.aesys.libraryapp.reservation.repository.ReservationRepository;
import com.aesys.libraryapp.reservation.service.ReservationService;
import com.aesys.libraryapp.userlibrary.data.dto.UserLibraryDto;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrarySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper mapper;

    @Autowired
    private ReservationSpec spec;


    @GetMapping(value = "old/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDto getReservationById(@PathVariable String id) {
        return reservationService.getReservation(id);
    }


    @GetMapping(value="/{reservationId}")
    public ReservationDto getReservationId(@PathVariable String reservationId){
        Optional<Reservation> result = reservationRepository.findOne(spec.getByReservationId(reservationId));
               return result.map(reservation -> mapper.reservationToReservationDto(reservation)).orElseThrow();

    }

    @GetMapping(value="/{reservationId}/{taxCode}")
    public List<ReservationDto> getReservationIdAndTaxCode(@PathVariable String reservationId, @PathVariable String taxCode){
        return reservationRepository.findAll(spec.getByReservationIdAndTaxCode(reservationId, taxCode))
                .stream().map(reservation -> mapper.reservationToReservationDto(reservation)).collect(Collectors.toList());

    }

    @PostMapping(path = "filter")
    public List<ReservationDto> getReservationByFilter(@RequestBody Filter filter){
        return reservationRepository.findAll(spec.createSpecification(filter)).
                stream().map(reservation -> mapper.reservationToReservationDto(reservation)).collect(Collectors.toList());
    }
}
