package it.fabrick.demo.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountBalanceResponse {

    private String date;
    private long balance;
    private long availableBalance;
    private String currency;


    public AccountBalanceResponse date(String date) {
        setDate(date);
        return this;
    }

    public AccountBalanceResponse balance(long balance) {
        setBalance(balance);
        return this;
    }

    public AccountBalanceResponse availableBalance(long availableBalance) {
        setAvailableBalance(availableBalance);
        return this;
    }

    public AccountBalanceResponse currency(String currency) {
        setCurrency(currency);
        return this;
    }
}
