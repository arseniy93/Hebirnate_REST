package com.rigin.enums;

import lombok.*;
import org.eclipse.tags.shaded.org.apache.regexp.RE;

@RequiredArgsConstructor
@Getter
@ToString
public enum TasksList {
    IN_PROGRESS("В ПРОГРЕССЕ"),
    NOT_STARTED("НЕ НАЧАТО"),
    DONE("ВЫПОЛНЕНО");


    private final String nameOfField;
}
