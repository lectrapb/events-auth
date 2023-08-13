package com.app.signUp.domain.value.object;

public record Name(String value) {

    public Name {
        boolean isOk = true;
        if (value == null) {
            isOk = false;
        } else if (value.isEmpty()) {
            isOk = false;
        }

        if (!isOk) {
            throw new RuntimeException("Forget mandatory data");
        }
    }
}
