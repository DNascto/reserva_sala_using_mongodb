package com.dnascto.ionic.practicing.model;

import com.dnascto.ionic.practicing.dto.DtoBooking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "booking")
public class Booking {
    @Id
    private Integer id;

//    @Column
    private LocalDateTime date;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn(name="room", referencedColumnName="id")
    private Room room;

    private Integer period;
    private String author;
    private Boolean approved;
//    private Boolean active;

    public Booking(DtoBooking dtoBooking) {
        this.id = dtoBooking.getId();
        this.room = dtoBooking.getRoom();
        this.period = dtoBooking.getPeriod();
        this.author = dtoBooking.getAuthor();
        this.approved = dtoBooking.getApproved();
        ZonedDateTime result = ZonedDateTime.parse(dtoBooking.getDate(), DateTimeFormatter.ISO_DATE_TIME);
        this.date = result.toLocalDateTime();
    }
}
