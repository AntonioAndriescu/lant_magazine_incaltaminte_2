package org.example.ViewModel.Commands;

import org.example.Model.IncaltaminteFinal;
import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.ViewModel.VMUtilizator;

public class ActualizareProdusButton implements Command {
    private String producator;
    private String denumire;
    private Float pret;
    private Boolean disponibilitate;
    private Integer marime;
    private Integer cantitate;
    private Integer id;
    private String[] row;

    public ActualizareProdusButton(VMUtilizator vm, String s1, String s2, Float f, Boolean b, Integer i1, Integer i2, Integer i3, String[] s) {
        this.producator = s1;
        this.denumire = s2;
        this.pret = f;
        this.disponibilitate = b;
        this.marime = i1;
        this.cantitate = i2;
        this.id = i3;
        this.row = s;
    }

    @Override
    public void execute() {
        IncaltaminteFinal x2 = new IncaltaminteFinal(producator, denumire, pret, disponibilitate, marime, cantitate, id);
        IncaltaminteFinal x1 = new IncaltaminteFinal(row[0], row[1], Float.parseFloat(row[2]), Boolean.parseBoolean(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
        PersistentaIncaltaminte.updateIncaltaminte(x1, x2);
    }
}
