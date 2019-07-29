package alararestaurant.domain.dtos.importDtos.xmls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderSeedDto {
    @XmlElement
    private String customer;
    @XmlElement
    private String employee;
    @XmlElement(name = "date-time")
    private String dateTime;
    @XmlElement
    private String type;
    @XmlElement(name = "items")
    private ItemRootDto orderItems;

    public OrderSeedDto() {}

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ItemRootDto getItems() {
        return orderItems;
    }

    public void setItems(ItemRootDto items) {
        this.orderItems = items;
    }
}
