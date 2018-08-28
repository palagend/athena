package com.palagend.athena.athena.controller;

import com.palagend.athena.athena.model.Questionnaire;
import com.palagend.athena.athena.service.QuestionnaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@Api(tags = "问卷调查API")
@RequestMapping("/api/v1")
@Slf4j
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService service;

    @GetMapping(value = "/questionnaire")
    public String questionnaire(@Validated Questionnaire questionnaire, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<ObjectError> errs = bindingResult.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (ObjectError err:errs) {
                sb.append(err+" ");
            }
            return sb.toString().trim();
        }
        return service.save(questionnaire).toString();
    }

    @GetMapping(value = "list")
    public List<Questionnaire> list() {
        return service.findAll();
    }

    @GetMapping(value = "/check/{code}")
    @ApiOperation("客户编码查重，0代表不重复，1代表已存在, 2代表code格式错误")
    public int duplicateChecking(@PathVariable String code) {
        if (Pattern.compile("^(?![a-zA-Z]+$)[0-9a-zA-Z]{8,12}$", Pattern.CASE_INSENSITIVE).matcher(code).matches()) {
            if (service.countByCode(code) > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 2;
        }
    }
}
