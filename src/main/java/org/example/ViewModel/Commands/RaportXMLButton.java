package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.Raport.Raport;
import org.example.ViewModel.VMUtilizator;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;

public class RaportXMLButton implements Command {
    public RaportXMLButton(VMUtilizator vm) {}

    @Override
    public void execute() {
        try {
            PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
            Raport.creareRaportXml(incaltaminte);
        } catch (SQLException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
