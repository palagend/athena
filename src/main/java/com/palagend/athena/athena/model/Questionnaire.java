package com.palagend.athena.athena.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Questionnaire {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    @Pattern(regexp = "^(?![a-zA-Z]+$)[0-9a-zA-Z]{8,12}$")
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
