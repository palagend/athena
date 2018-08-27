package com.palagend.athena.athena.service;

import com.palagend.athena.athena.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionnaireService extends JpaRepository<Questionnaire, Integer> {
    int countByCode(String code);
}
