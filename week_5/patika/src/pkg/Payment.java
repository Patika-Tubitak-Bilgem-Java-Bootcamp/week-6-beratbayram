package pkg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Payment {
    private String tc;
    private Double amount;
}
