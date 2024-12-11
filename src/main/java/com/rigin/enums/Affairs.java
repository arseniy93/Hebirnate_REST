package com.rigin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public enum Affairs {

    HOME("дом"),
    WORK("работа"),
    HOBBY("увлечения"),
    STUDY("обучение"),
    SPORT("спорт"),
    RELAX("отдых"),
    FAMILY("семья");


    private String nameOfField;
}
