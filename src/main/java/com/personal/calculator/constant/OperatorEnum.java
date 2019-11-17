package com.personal.calculator.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public enum OperatorEnum
{
	OPEN_BRACKET("("), CLOSE_BRACKET(")"), 
	EXPONENT("^"),
	MULTIPLICATION("*"), DIVISION("/"),  
	ADDITION("+"), SUBTRACTION("-");

	private static final Map<String, OperatorEnum> lookup = new HashMap<>();

    static {
        Stream.of(OperatorEnum.values())
                .forEach(type -> {
                    lookup.put(type.getValue(), type);
                });
    }
	
    private final String value;

    private OperatorEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static OperatorEnum get(String type) {
        return lookup.get(type);
    }
}
