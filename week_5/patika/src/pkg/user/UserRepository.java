package pkg.user;

import pkg.Msg;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
     Msg addUser(User user);
     User getUser(String tc);
}
