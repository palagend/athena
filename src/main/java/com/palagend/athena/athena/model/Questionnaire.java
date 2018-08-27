package com.palagend.athena.athena.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Questionnaire {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String code;
    String phone;
    String gender;
    String ageRange;
    String tvBoxAwareness;
    String tvBoxFunctions;
    String tvTimeSpent;
    String feedback;
    String reason;
}
