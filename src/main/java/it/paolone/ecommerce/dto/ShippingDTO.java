package it.paolone.ecommerce.dto;

public class ShippingDTO {

    private Long id;
    private String shippingDate;
    private String shippingAddress;
    private String shippingCompany;
    private String trackingCode;

    public Long getId() {
        return id;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getTrackingCode() {
        return trackingCode;
    }
}
