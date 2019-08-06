package pl.blog.java.validation;

import jdk.nashorn.internal.ir.FunctionNode;
import pl.blog.java.Calendar;
import pl.blog.java.CalendarDAO;
import pl.blog.java.Scope;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CalendarValidationService {
    private final Map<Scope, AbstractCalendarValidator> validatorMap;

    public CalendarValidationService(List<AbstractCalendarValidator> validators) {
        validateValidatorQuantity(validators);

        Map<Scope, AbstractCalendarValidator> map = validators.stream()
                .collect(Collectors.toMap(AbstractCalendarValidator::getScope, Function.identity()));

        validatorMap = Collections.unmodifiableMap(map);
    }

    private void validateValidatorQuantity(List<AbstractCalendarValidator> validators) {
        int scopes = Scope.values().length;
        if (validators.size() < scopes) {
            throw new RuntimeException("There are not strategies (size: " + validators.size() + ") for all enums values (size: " + scopes + ").");
        }
    }

    private AbstractCalendarValidator getValidator(Calendar calendar) {
        return Optional.ofNullable(validatorMap.get(calendar.getScope()))
                .orElseThrow(() -> new IllegalArgumentException("Validation method for calendar scope: " + calendar.getScope() + " is not defined."));
    }

    public void validate(Calendar calendar) {
        AbstractCalendarValidator validator = getValidator(calendar);

        validator.validate(calendar);
    }
}
