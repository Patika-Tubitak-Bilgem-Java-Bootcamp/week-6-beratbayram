package pkg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Request {
    private String senderTc;
    private String receiverTc;
    private Double amount;
}
