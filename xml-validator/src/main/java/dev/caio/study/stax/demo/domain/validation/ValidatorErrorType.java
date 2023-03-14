package dev.caio.study.stax.demo.domain.validation;


import lombok.Getter;

public enum ValidatorErrorType {
    ERROR(1);

    @Getter
    Integer value;

    ValidatorErrorType(Integer value) {
        this.value = value;
    }
}
