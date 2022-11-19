package com.maksym.prykhodko.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Potentiometer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer value;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimestamp;

    public Potentiometer() {

    }

    public Potentiometer(String name, Integer value){
        this.name = name;
        this.value = value;
        this.createTimestamp = new Date();
    }

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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getCreate() {
        return createTimestamp;
    }

    public void setCreate(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", create=" + createTimestamp +
                '}';
    }
}
