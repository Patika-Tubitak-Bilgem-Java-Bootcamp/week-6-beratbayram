package pkg.bank;

import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository {

    Bank getBank();
}
