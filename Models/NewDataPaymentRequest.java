package com.woderlust.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewDataPaymentRequest {
    private String name;
    private Long number;
    private Integer expDate;
    private Integer securityCode;
    private String userFullName;
}
