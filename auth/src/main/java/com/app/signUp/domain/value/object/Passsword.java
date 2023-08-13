package com.app.signUp.domain.value.object;

public class Passsword {

    private final String value;

    public Passsword(String value) {
        boolean isOk = true;
        if(value == null){
            isOk = false;
        } else if (value.isEmpty()) {
            isOk = false;
        }

        if(!isOk){
            throw new RuntimeException("Forget mandatory data");
        }
        this.value = value;
    }

    public String value(){
        return value; 
    }
}
