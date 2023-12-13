package com.dailycodebuffer.springboot.tutorial.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Errormessage {

    private HttpStatus status;
    private String message;
}
