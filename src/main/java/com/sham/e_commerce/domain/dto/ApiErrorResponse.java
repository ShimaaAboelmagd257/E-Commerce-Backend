package com.sham.e_commerce.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse extends Object{
    private int status;
    private String message;
    private List<FieledMessages> messagesList;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FieledMessages{
        private String field;
        private String message;
    }

}
