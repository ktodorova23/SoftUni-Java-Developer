package com.softuni.xmlprocessing.domain.dtos.exportDtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersAndProductsRootDto {
    @XmlAttribute(name = "count")
    private int countUsers;
    @XmlElement(name = "user")
    private List<UserSimpleDto> users;

    public UsersAndProductsRootDto() {}

    public int getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(int countUsers) {
        this.countUsers = countUsers;
    }

    public List<UserSimpleDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSimpleDto> users) {
        this.users = users;
    }
}
