package com.luv2code.cruddemo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private int statusCode;
    private LocalDateTime localDateTime;
}
