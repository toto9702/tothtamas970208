package com.exam.service;

import com.exam.dto.DateInformationDto;
import com.exam.dto.PrimeNumberDto;
import com.exam.dto.VowelsDto;
import com.exam.exception.CommonException;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.primes.Primes;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@Slf4j
public class DataInformationService {

    private final List<DateTimeFormatter> formatters = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy.MM.dd"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd")
    );

    public DateInformationDto getDateInformation(String inputDateString) {
        for (DateTimeFormatter formatter : formatters) {
            try {
                LocalDate formattedDate = LocalDate.parse(inputDateString, formatter);
                log.info("Successfully parsed date: " + inputDateString);
                return new DateInformationDto(
                        inputDateString,
                        formattedDate,
                        convertDayToHungarian(formattedDate.getDayOfWeek().toString())
                );
            } catch (DateTimeParseException e) {
                log.warn("Parse date error", inputDateString);
            }
        }
        log.error("All Dates are not supported");
        throw new CommonException("Invalid date format. Supported formats: yyyy-MM-dd, yyyy.MM.dd, yyyy/MM/dd");
    }

    public PrimeNumberDto isPrimeNumber(String numberString) {
        if (isInteger(numberString)) {
            int number = Integer.parseInt(numberString);
            boolean result = Primes.isPrime(number);
            return new PrimeNumberDto(number, result);
        }
        log.error("Invalid input: " + numberString);
        throw new CommonException("Invalid input: " + numberString);
    }

    public VowelsDto getCountOfVowels(String inputString) {
        List<Character> chars = List.of('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');
        int count = 0;
        for (char ch : inputString.toCharArray()) {
            char toLowerCase = Character.toLowerCase(ch);
            if (chars.contains(toLowerCase)) {
                count++;
            }
        }
        return new VowelsDto(inputString, count);
    }

    private String convertDayToHungarian(String dayName) {
        return switch (dayName) {
            case "MONDAY" -> "Hétfő";
            case "TUESDAY" -> "Kedd";
            case "WEDNESDAY" -> "Szerda";
            case "THURSDAY" -> "Csütörtök";
            case "FRIDAY" -> "Péntek";
            case "SATURDAY" -> "Szombat";
            case "SUNDAY" -> "Vasárnap";
            default -> "Error";
        };
    }

    private boolean isInteger(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }

        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}
