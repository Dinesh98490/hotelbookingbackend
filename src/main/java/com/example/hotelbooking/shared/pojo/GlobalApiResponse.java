package com.example.hotelbooking.shared.pojo;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GlobalApiResponse<T> {
    private String message;
    private T data;
    private int statusCode;
}