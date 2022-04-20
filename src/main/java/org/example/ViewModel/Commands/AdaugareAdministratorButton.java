package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.Model.Utilizator;
import org.example.ViewModel.VMAdministrator;

public class AdaugareAdministratorButton implements Command {
    private String nume;
    private String prenume;
    private String email;
    private String functie;
    private Integer idMagazin;
    private String username;
    private String parola;

    public AdaugareAdministratorButton(VMAdministrator vm, String s1, String s2, String s3, String s4, Integer i, String s5, String s6) {
        this.nume = s1;
        this.prenume = s2;
        this.email = s3;
        this.functie = s4;
        this.idMagazin = i;
        this.username = s5;
        this.parola = s6;
    }

    @Override
    public void execute() {
        Utilizator u = new Utilizator(nume, prenume, email, functie, idMagazin, username, parola);
        PersistentaUtilizator.adaugare(u);
    }
}
