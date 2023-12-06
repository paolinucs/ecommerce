package it.paolone.ecommerce.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long columnId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "barcode")
    private String barcode;

    @Column(name = "quantity")
    private short quantity;

    //getters and setters


    public Long getColumnId() {
        return columnId;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public short getQuantity() {
        return quantity;
    }
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
}
