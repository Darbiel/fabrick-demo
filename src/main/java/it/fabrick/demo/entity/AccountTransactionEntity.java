package it.fabrick.demo.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class AccountTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "operationId")
    private String operationId;

    @Column(name = "accountingDate")
    private String accountingDate;

    @Column(name = "valueDate")
    private String valueDate;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    @JoinColumn(name = "account_transaction_type_entity_id")
    private AccountTransactionTypeEntity accountTransactionTypeEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountTransactionEntity that = (AccountTransactionEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}