package com.dnascto.ionic.practicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "room")
public class Room {
    @Id
    private BigInteger id;
    private String name;
    private Integer places;
    private Boolean projector;
    private Boolean booked;
    private String company;
}
