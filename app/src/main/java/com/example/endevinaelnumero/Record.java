package com.example.endevinaelnumero;

public class Record {
    private final String name;
    private final int intents;
    private final int temps;


    public Record(String name, int intents, int temps) {
        this.name = name;
        this.intents = intents;
        this.temps = temps;
    }

    public String getName() {
        return name;
    }
    public int getIntents() {
        return intents;
    }
    public int getTemps() {
        return temps;
    }




}
