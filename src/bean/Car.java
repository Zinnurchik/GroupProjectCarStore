package bean;

public class Car extends BaseIdBean{
    private String name;
    private String color;
    private Double price;
    private Integer userId;
    private Boolean isInStore = false;

    public Car(String name, String color, Double price, Integer userId) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.userId = userId;
    }

    public Boolean getInStore() {
        return isInStore;
    }

    public void setInStore(Boolean inStore) {
        isInStore = inStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
