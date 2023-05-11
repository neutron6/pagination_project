package com.rsn.pagination.pagination_with_sorting.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private int statusCode;
    private String message;

    private String description;


}
