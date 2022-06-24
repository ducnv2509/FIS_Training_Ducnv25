package com.example.full_code_quynv.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String code;
    private String message;
}
