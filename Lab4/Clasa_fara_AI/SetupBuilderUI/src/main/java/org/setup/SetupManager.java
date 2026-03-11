package org.setup;

public class SetupManager {
    private double bugetMaxim;

    public SetupManager(double bugetMaxim) {
        this.bugetMaxim = bugetMaxim;
    }

    public double getBugetMaxim() {
        return bugetMaxim;
    }

    public void setBugetMaxim(double bugetMaxim) {
        this.bugetMaxim = bugetMaxim;
    }

    public void verificaBuget(SmartDevice dispozitiv) {
        if (dispozitiv.getPret() <= this.bugetMaxim) {
            System.out.println("Succes: " + dispozitiv.getNume() + " a fost adăugat în setup!");
        } else {
            System.out.println("Eroare: " + dispozitiv.getNume() + " este prea scump pentru bugetul tău.");
        }
    }
}
