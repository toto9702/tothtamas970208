package com.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VowelsDto {

    private String input;

    private int countOfVowels;
}
