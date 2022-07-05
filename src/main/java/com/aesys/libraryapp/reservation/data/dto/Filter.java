package com.aesys.libraryapp.reservation.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Filter {

    private String field;
    private QueryOperator operator;
    private String value;
    private List<String> values; // per operazione di IN
}
