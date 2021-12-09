package it.fabrick.demo.model;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountTransactionType {

    private String enumeration;
    private String value;


    public AccountTransactionType enumeration(String enumeration) {
        setEnumeration(enumeration);
        return this;
    }

    public AccountTransactionType value(String value) {
        setValue(value);
        return this;
    }
}
