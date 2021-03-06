package com.googlecode.totallylazy.validations;

import com.googlecode.totallylazy.Sequence;

import static com.googlecode.totallylazy.Sequences.sequence;
import static com.googlecode.totallylazy.validations.ValidationResult.functions.merge;
import static com.googlecode.totallylazy.validations.Validator.functions.validateAgainst;

public class AllOfValidator<T> extends LogicalValidator<T>{
    private final Sequence<Validator<? super T>> validators;

    private AllOfValidator(Sequence<Validator<? super T>> validators) {
        this.validators = validators;
    }

    @Override
    public ValidationResult validate(T instance) {
        return validators.
                map(validateAgainst(instance)).
                reduce(merge());
    }

    public static class constructors {

        public static <T> AllOfValidator<T> allOf(Validator<? super T>... validators) {
            return allOf(sequence(validators));
        }

        public static <T> AllOfValidator<T> allOf(Sequence<Validator<? super T>> validators) {
            return new AllOfValidator<T>(validators);
        }
    }


}
