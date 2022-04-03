package pkg.user;

import pkg.Msg;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDto implements UserRepository{

    final Set<User> users = new HashSet<>();

    @Override
    public Msg addUser(User user) {
        if (users.contains(user))
            return new Msg("Error", "This tc is used already");
        if(user.getPassword().contains(user.getTc()))
            return new Msg("Error", "Password cannot include TC");
        users.add(user);
        return new Msg("Success", "Successful register");
    }

    @Override
    public User getUser(String tc) {
        List<String> tcList = users.stream().map(User::getTc).toList();
        if (tcList.contains(tc))
            return users.stream().filter(user -> user.getTc().equals(tc)).toList().get(0);
        return null;
    }
}
