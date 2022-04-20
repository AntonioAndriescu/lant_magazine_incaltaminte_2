package org.example.ViewModel.Commands;

import org.example.Model.IncaltaminteFinal;
import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.ViewModel.VMUtilizator;

public class AdaugareProdusButton implements Command {
    private String producator;
    private String denumire;
    private Float pret;
    private Boolean disponibilitate;
    private Integer marime;
    private Integer cantitate;
    private Integer id;

    public AdaugareProdusButton(VMUtilizator vm, String s1, String s2, Float f, Boolean b, Integer i1, Integer i2, Integer i3) {
        this.producator = s1;
        this.denumire = s2;
        this.pret = f;
        this.disponibilitate = b;
        this.marime = i1;
        this.cantitate = i2;
        this.id = i3;
    }

    @Override
    public void execute() {
        IncaltaminteFinal x = new IncaltaminteFinal(producator, denumire, pret, disponibilitate, marime, cantitate, id);
        PersistentaIncaltaminte.adaugareIncaltaminte(x);
    }
}
