package com.dnascto.ionic.practicing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "room")
public class Room {
    @Id
    private Integer id;
    private String name;
    private Integer places;
    private Boolean projector;
    private Boolean booked;
}
