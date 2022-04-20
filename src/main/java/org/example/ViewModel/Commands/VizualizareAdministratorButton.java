package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.View.AdministratorView;
import org.example.ViewModel.VMAdministrator;

import java.sql.SQLException;

public class VizualizareAdministratorButton implements Command {
    public VizualizareAdministratorButton(VMAdministrator vm) {}

    private static PersistentaUtilizator utilizatori = new PersistentaUtilizator();

    @Override
    public void execute() {
        try {
            utilizatori = PersistentaUtilizator.unmarshal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AdministratorView v = new AdministratorView();
        v.TabelUtilizatori(utilizatori);
    }
}
