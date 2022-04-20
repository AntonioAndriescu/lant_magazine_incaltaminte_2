package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.View.AngajatView;
import org.example.ViewModel.VMUtilizator;

import java.sql.SQLException;

public class SearchProducatorButton implements Command {
    private String search;

    public SearchProducatorButton(VMUtilizator vm, String s) {
        this.search = s;
    }

    @Override
    public void execute() {
        try {
            PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
            incaltaminte.getIncaltamintep().removeIf(u -> !u.getProducator().equals(search));
            AngajatView v = new AngajatView();
            v.TabelProduse(incaltaminte);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
