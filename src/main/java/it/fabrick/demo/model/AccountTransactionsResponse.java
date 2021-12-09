package it.fabrick.demo.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountTransactionsResponse {

    private List<AccountTransactionModel> list;

    public AccountTransactionsResponse list(List<AccountTransactionModel> list) {
        setList(list);
        return this;
    }
}
