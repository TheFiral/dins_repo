package com.example.dins.shemyak_semoyn.pojo;

public class Phone {

    private String number;

    public Phone() {
        this.number = createRandomNumber();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // 8-9xx-xxx-xx-xx
    private String createRandomNumber() {
        StringBuilder stringBuilder = new StringBuilder("89");
        for (int i = 0; i < 9; i++){
            stringBuilder.append((int)(Math.random()*(9-0))+0);
        }
            return stringBuilder.toString();
    }

    public boolean findNumberAcrossEquals(String number) {
        if (number.equals(this.number)) {
            return true;
        }
        return false;
    }
}
