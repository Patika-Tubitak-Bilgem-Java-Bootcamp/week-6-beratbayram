package pkg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Login {
    private String tc;
    private String password;

    public void setTc(String tc) {
        this.tc = tc;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
