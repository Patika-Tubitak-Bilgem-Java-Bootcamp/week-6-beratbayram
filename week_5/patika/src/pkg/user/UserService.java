package pkg.user;

import pkg.Msg;
import org.springframework.stereotype.Service;
import pkg.bank.Bank;
import pkg.bank.BankDto;
import pkg.bank.BankRepository;

@Service
public class UserService {

    final UserRepository userRepository;
    final BankRepository bankRepository;

    public UserService(UserDto userRepository, BankDto bankRepository) {
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
    }

    Msg register(User user) {
        return userRepository.addUser(user);
    }

    Msg login(String tc, String password) {
        User user = userRepository.getUser(tc);

        if(user == null) {
            return new Msg("Error", "Wrong TC or Password");
        }

        if (user.getPassword().equals(password)) {
            return new Msg("Success", "Logged in");
        } else {
            return new Msg("Error", "Wrong TC or Password");
        }
    }

    Msg send(String senderTc, String receiverTc, Double amount) {
        User sender = userRepository.getUser(senderTc);
        User receiver = userRepository.getUser(receiverTc);

        if(sender == null || receiver == null) {
            return new Msg("Error", "Users could not found");
        }

        if(sender.getBalance() < amount) {
            return new Msg("Error","There is not enough balance");
        }

        sender.setBalance(sender.getBalance()- amount);
        receiver.setBalance(receiver.getBalance() + amount);

        return new Msg("Success", "The amount is sent");

    }

    Msg payCredit(String tc, Double amount) {
        return getMessageResponse(tc, amount);
    }

    private Msg getMessageResponse(String tc, Double amount) {
        User user = userRepository.getUser(tc);

        if(user == null ) {
            return new Msg("Error", "User could not found");
        }

        if(user.getBalance() < amount) {
            return new Msg("Error","There is not enough balance");
        }

        Bank bank = bankRepository.getBank();

        user.setBalance(user.getBalance()-amount);
        bank.setBankAmount(bank.getBankAmount() + amount);

        return new Msg("Success", "The amount is paid");
    }

    Msg payCreditExtres(String tc, Double amount) {
        return getMessageResponse(tc, amount);
    }
}
