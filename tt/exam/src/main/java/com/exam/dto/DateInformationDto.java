package com.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DateInformationDto {

    private String inputDate;

    private LocalDate dateTime;

    private String day;

}
