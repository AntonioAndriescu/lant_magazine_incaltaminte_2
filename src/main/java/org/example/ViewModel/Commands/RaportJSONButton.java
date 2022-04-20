package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.Raport.Raport;
import org.example.ViewModel.VMUtilizator;

import java.io.IOException;
import java.sql.SQLException;

public class RaportJSONButton implements Command {
    public RaportJSONButton(VMUtilizator vm) {}

    @Override
    public void execute() {
        try {
            PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
            Raport.creareRaportJson(incaltaminte);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
