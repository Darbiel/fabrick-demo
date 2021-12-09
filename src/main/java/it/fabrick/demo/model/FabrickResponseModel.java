package it.fabrick.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FabrickResponseModel <T>{

    private String status;
    private List<String> error;
    private T payload;


    public FabrickResponseModel status(String status) {
        setStatus(status);
        return this;
    }

    public FabrickResponseModel error(List<String> error) {
        setError(error);
        return this;
    }

    public FabrickResponseModel payload(T payload) {
        setPayload(payload);
        return this;
    }
}
