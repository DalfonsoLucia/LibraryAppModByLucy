package com.aesys.libraryapp.userlibrary.data.dto;

import com.aesys.libraryapp.reservation.data.dto.ReservationDto;
import com.aesys.libraryapp.reservation.data.model.Reservation;
import com.aesys.libraryapp.title.data.dto.TitleDto;
import com.aesys.libraryapp.title.data.model.Title;
import com.aesys.libraryapp.userlibrary.data.model.UserLibrary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserLibraryMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "reservations", target = "reservations")
    UserLibraryDto userLibraryToUserLibraryDto (UserLibrary userLibrary);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "creationDate", target = "creationDate")
    ReservationDto reservationToReservationDto (Reservation reservation);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "type", target = "type")
    TitleDto titleToTitleDto (Title title);
}
