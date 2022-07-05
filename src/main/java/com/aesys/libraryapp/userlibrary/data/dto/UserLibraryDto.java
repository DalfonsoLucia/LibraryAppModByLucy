package com.aesys.libraryapp.userlibrary.data.dto;

import com.aesys.libraryapp.reservation.data.dto.ReservationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLibraryDto {

    private String firstName;

    private String lastName;

    private List<ReservationDto> reservations;

}
