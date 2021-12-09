package it.fabrick.demo.model;


import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountTransactionModel {

    private String transactionId;
    private String operationId;
    private String accountingDate;
    private String valueDate;
    private AccountTransactionType type;
    private Long amount;
    private String currency;
    private String description;


    public AccountTransactionModel transactionId(String transactionId) {
        setTransactionId(transactionId);
        return this;
    }

    public AccountTransactionModel operationId(String operationId) {
        setOperationId(operationId);
        return this;
    }

    public AccountTransactionModel accountingDate(String accountingDate) {
        setAccountingDate(accountingDate);
        return this;
    }

    public AccountTransactionModel valueDate(String valueDate) {
        setValueDate(valueDate);
        return this;
    }

    public AccountTransactionModel type(AccountTransactionType type) {
        setType(type);
        return this;
    }

    public AccountTransactionModel amount(Long amount) {
        setAmount(amount);
        return this;
    }

    public AccountTransactionModel currency(String currency) {
        setCurrency(currency);
        return this;
    }

    public AccountTransactionModel description(String description) {
        setDescription(description);
        return this;
    }
}
