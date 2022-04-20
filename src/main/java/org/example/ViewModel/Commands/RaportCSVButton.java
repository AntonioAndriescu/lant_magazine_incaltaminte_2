package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.Raport.Raport;
import org.example.ViewModel.VMUtilizator;

import java.io.IOException;
import java.sql.SQLException;

public class RaportCSVButton implements Command {
    public RaportCSVButton(VMUtilizator vm) {}

    @Override
    public void execute() {
        try {
            PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
            Raport.creareRaportCSV(incaltaminte);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
