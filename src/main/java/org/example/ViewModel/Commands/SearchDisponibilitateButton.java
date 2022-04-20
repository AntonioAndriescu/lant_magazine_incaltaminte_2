package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.View.AngajatView;
import org.example.ViewModel.VMUtilizator;

import java.sql.SQLException;

public class SearchDisponibilitateButton implements Command {
    private String search;

    public SearchDisponibilitateButton(VMUtilizator vm, String s) {
        this.search = s;
    }

    @Override
    public void execute() {
        try {
            PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
            incaltaminte.getIncaltamintep().removeIf(u -> u.getDisponibilitate() != Boolean.parseBoolean(search));
            AngajatView v = new AngajatView();
            v.TabelProduse(incaltaminte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
