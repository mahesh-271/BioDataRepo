package com.luv2code.cruddemo.Exceptions;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Timer;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@ToString
public class DipExceptionHandler extends RuntimeException{
    private String message;
    private LocalDateTime time;
    private int statusCode;



}
