package pkg.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @NotNull
    private String name;
    private String tc;
    private String password;
    private Double balance;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
            return ((User) obj).tc.equals(this.tc);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tc);
    }
}
