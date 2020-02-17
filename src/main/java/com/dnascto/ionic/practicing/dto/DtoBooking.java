package com.dnascto.ionic.practicing.dto;

import com.dnascto.ionic.practicing.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoBooking {
    private Integer id;
    private String date;
    private Room room;
    private Integer period;
    private String author;
    private Boolean approved;
}

