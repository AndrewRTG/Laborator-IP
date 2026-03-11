package org.setup;

public class Main {
    public static void main(String[] args) {

        SmartDevice senzor = new SmartDevice("Senzor Fereastră", 45.0);

        SetupManager manager = new SetupManager(100.0);


        manager.verificaBuget(senzor);

        System.out.println("Scădem bugetul la 30...");
        manager.setBugetMaxim(30.0);

        manager.verificaBuget(senzor);
    }
}
