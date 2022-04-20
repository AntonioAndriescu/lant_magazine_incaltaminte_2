package org.example.ViewModel;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.Model.Utilizator;
import org.example.ViewModel.Commands.*;

public class VMAdministrator {
    public Command vizualizare;
    public Command adaugare;
    public Command stergere;
    public Command actualizare;
    public Command searchFunctie;
    public Command searchIdMagazin;
    public Command searchNume;
    private String numeValue;
    private String prenumeValue;
    private String emailValue;
    private String functieValue;
    private Integer idValue;
    private String usernameValue;
    private String parolaValue;
    private String[] rowValue;
    private String searchValue;

    public VMAdministrator() {
        vizualizare = new VizualizareAdministratorButton(this);
    }

    public void instantiereComandaAdaugare() {
        adaugare = new AdaugareAdministratorButton(this, numeValue, prenumeValue, emailValue, functieValue, idValue, usernameValue, parolaValue);
    }

    public void instantiereComandaStergere() {
        stergere = new StergereAdministratorButton(this, rowValue);
    }

    public void instantiereComandaActualizare() {
        actualizare = new ActualizareAdministratorButton(this, rowValue, numeValue, prenumeValue, emailValue, functieValue, idValue, usernameValue, parolaValue);
    }

    public void instantiereSearchFunctie() {
        searchFunctie = new SearchFunctieButton(this, searchValue);
    }

    public void instantiereSearchNume() {
        searchNume = new SearchNumeButton(this, searchValue);
    }

    public void instantiereSearchIdMagazin() {
        searchIdMagazin = new SearchIdMagazinButton(this, searchValue);
    }

    public Object[][] creareTabel(PersistentaUtilizator utilizatorList) {
        int i = 0;
        int size = utilizatorList.getUtilizatori().size();
        Object[][] data = new Object[size][];
        for(Utilizator u : utilizatorList.getUtilizatori()) {
            data[i] = new Object[] {u.getNume(), u.getPrenume(), u.getEmail(), u.getFunctie(), u.getIdMagazin(), u.getUsername(), u.getParola()};
            i++;
        }
        return data;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public void setNumeValue(String numeValue) {
        this.numeValue = numeValue;
    }

    public void setPrenumeValue(String prenumeValue) {
        this.prenumeValue = prenumeValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public void setFunctieValue(String functieValue) {
        this.functieValue = functieValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }

    public void setUsernameValue(String usernameValue) {
        this.usernameValue = usernameValue;
    }

    public void setParolaValue(String parolaValue) {
        this.parolaValue = parolaValue;
    }

    public void setRowValue(String[] rowValue) {
        this.rowValue = rowValue;
    }
}
