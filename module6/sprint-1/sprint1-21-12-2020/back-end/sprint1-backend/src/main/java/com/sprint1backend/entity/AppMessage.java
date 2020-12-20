package com.sprint1backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity(name = "app_message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "content", columnDefinition = "VARCHAR(40)")
    private String content;

    @Column(name = "send_date", columnDefinition = "DATE")
    private LocalDate sendDate;

    @Column(name = "status", columnDefinition = "BIT")
    private Double status;









}
