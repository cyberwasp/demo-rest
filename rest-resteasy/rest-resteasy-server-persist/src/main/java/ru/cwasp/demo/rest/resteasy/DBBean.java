package ru.cwasp.demo.rest.resteasy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.QueryParam;

@Entity
public class DBBean {

    @Id
    @GeneratedValue
    private Long id;

    @QueryParam("name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
