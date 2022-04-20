package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.Model.Utilizator;
import org.example.ViewModel.VMAdministrator;

public class StergereAdministratorButton implements Command{
    private String[] row;

    public StergereAdministratorButton(VMAdministrator vm, String[] s) {
        this.row = s;
    }

    @Override
    public void execute() {
        Utilizator u = new Utilizator(row[0], row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6]);
        PersistentaUtilizator.stergere(u);
    }
}
