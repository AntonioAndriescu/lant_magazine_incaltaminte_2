package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.Model.Utilizator;
import org.example.ViewModel.VMAdministrator;

public class ActualizareAdministratorButton implements Command {
    private String[] row;
    private String nume;
    private String prenume;
    private String email;
    private String functie;
    private Integer idMagazin;
    private String username;
    private String parola;

    public ActualizareAdministratorButton(VMAdministrator vm, String[] s, String s1, String s2, String s3, String s4, Integer i, String s5, String s6) {
        this.row = s;
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
        Utilizator u2 = new Utilizator(nume, prenume, email, functie, idMagazin, username, parola);
        Utilizator u1 = new Utilizator(row[0], row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6]);
        PersistentaUtilizator.update(u1, u2);
    }
}
