package com.rsn.pagination.pagination_with_sorting.dto;

import com.rsn.pagination.pagination_with_sorting.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {

    int recordCount;
    T response;

    public APIResponse(Product product1) {
    }
}
