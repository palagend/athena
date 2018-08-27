package com.palagend.athena.athena.controller;

import com.palagend.athena.athena.model.Questionnaire;
import com.palagend.athena.athena.service.QuestionnaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "问卷调查API")
@RequestMapping("/api/v1")
@Slf4j
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService service;

    @GetMapping(value = "/questionnaire")
    public Questionnaire questionnaire(Questionnaire questionnaire) {
        log.info(questionnaire.toString());
        return service.save(questionnaire);
    }

    @GetMapping(value = "list")
    public List<Questionnaire> list() {
        return service.findAll();
    }

    @GetMapping(value = "/check/{code}")
    @ApiOperation("客户编码查重，0代表不重复，1代表已存在")
    public int duplicateChecking(@PathVariable String code) {
        Optional<Questionnaire> o = service.findByCode(code);
        if (o.isPresent()) return 1;
        else return 0;
    }

}