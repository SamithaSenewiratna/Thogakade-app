package entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class ItemEntity {
    private String itemCode;
    private String description;
    private Double unitPrice;
    private Integer qty;
}
