package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String category) {
        super();
    }
}
