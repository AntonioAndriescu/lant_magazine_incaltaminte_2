package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.View.AngajatView;
import org.example.ViewModel.VMUtilizator;

import java.sql.SQLException;

public class VizualizareProdusButton implements Command {
    public VizualizareProdusButton(VMUtilizator vm) {}

    private static PersistentaIncaltaminte incaltamintep = new PersistentaIncaltaminte();

    @Override
    public void execute() {
        try {
            incaltamintep = PersistentaIncaltaminte.unmarshal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AngajatView v = new AngajatView();
        v.TabelProduse(incaltamintep);
    }
}
