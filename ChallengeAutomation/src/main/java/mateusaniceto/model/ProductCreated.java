package mateusaniceto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductCreated {
    private Integer id;
    private String title;
    private Integer price;
    private Integer stock;
    private Integer rating;
    private String thumbnail;
    private String description;
    private String brand;
    private String category;

}
