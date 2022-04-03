package pkg.bank;

import org.springframework.stereotype.Repository;

@Repository
public class BankDto implements  BankRepository {

    final Bank bank;

    public BankDto() {this.bank  = new Bank("Bank", 0.0);}

    @Override
    public Bank getBank() {
        return bank;
    }
}
