package com.example.sbquerydsl.dto.condition;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class MemberSearchCondition {

    private String username;
    private String teamName;
    private Integer ageGoe;
    private Integer ageLoe;
}
