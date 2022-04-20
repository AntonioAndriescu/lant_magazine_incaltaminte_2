package org.example.ViewModel.Commands;

import org.example.Model.IncaltaminteFinal;
import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.ViewModel.VMUtilizator;

public class StergereProdusButton implements Command{
    private String[] row;

    public StergereProdusButton(VMUtilizator vm, String[] s){
        this.row = s;
    }

    @Override
    public void execute() {
        IncaltaminteFinal x = new IncaltaminteFinal(row[0], row[1], Float.parseFloat(row[2]), Boolean.parseBoolean(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
        PersistentaIncaltaminte.stergereIncaltaminte(x);
    }
}
