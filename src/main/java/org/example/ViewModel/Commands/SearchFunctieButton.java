package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.View.AdministratorView;
import org.example.ViewModel.VMAdministrator;

import java.sql.SQLException;

public class SearchFunctieButton implements Command {
    private String search;

    public SearchFunctieButton(VMAdministrator vm, String s) {
        this.search = s;
    }

    @Override
    public void execute() {
        try {
            PersistentaUtilizator utilizatori = PersistentaUtilizator.unmarshal();
            utilizatori.getUtilizatori().removeIf(u -> !u.getFunctie().equals(search));
            AdministratorView v = new AdministratorView();
            v.TabelUtilizatori(utilizatori);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
