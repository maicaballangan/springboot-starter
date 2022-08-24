package com.cordisys.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Cacheable
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Employee extends Model<Employee> {

    private String name;
    private String email;

    public Employee() {
    }
}
