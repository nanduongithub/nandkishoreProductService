package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Price extends BaseModel {
    private String currency;
    private double value;

    public Price(int price) {
        super();
    }
}
