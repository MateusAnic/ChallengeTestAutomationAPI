package mateusaniceto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProduct {
    private List<Product> products;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
