package com.exam.controller;

import com.exam.dto.DateInformationDto;
import com.exam.dto.PrimeNumberDto;
import com.exam.dto.VowelsDto;
import com.exam.service.DataInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DataController {

    private final DataInformationService dataInformationService;

    @GetMapping("/melyiknap")
    public DateInformationDto getDateInformation(@RequestParam String dateString) {
        return dataInformationService.getDateInformation(dateString);
    }

    @GetMapping("/primszam")
    public PrimeNumberDto isPrimeNumber(@RequestParam String numberString) {
        return dataInformationService.isPrimeNumber(numberString);
    }

    @GetMapping("/maganhangzo")
    public VowelsDto getCountOfVowels(@RequestParam String inputString) {
        return dataInformationService.getCountOfVowels(inputString);
    }
}
