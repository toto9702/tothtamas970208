package com.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrimeNumberDto {

    private int number;

    private boolean isPrime;

}
