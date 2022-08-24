package com.cordisys.web.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Model<U extends Model<U>> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
}
