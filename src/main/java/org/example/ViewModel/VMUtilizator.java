package org.example.ViewModel;

import org.example.Model.IncaltaminteFinal;
import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.example.ViewModel.Commands.*;

public class VMUtilizator {
    public Command adaugare;
    public Command stergere;
    public Command actualizare;
    public Command vizualizare;
    public Command searchProducator;
    public Command searchMarime;
    public Command searchDisponibilitate;
    public Command raportJSON;
    public Command raportCSV;
    public Command raportXML;
    public Command pieChartDisponibilitate;
    public Command pieChartPret;
    public Command pieChartProducator;
    private String producatorValue;
    private String denumireValue;
    private Float pretValue;
    private Boolean dispValue;
    private Integer marimeValue;
    private Integer cantitateValue;
    private Integer idValue;
    private String[] rowValue;
    private String searchValue;

    public VMUtilizator() {
        vizualizare = new VizualizareProdusButton(this);
        raportJSON = new RaportJSONButton(this);
        raportCSV = new RaportCSVButton(this);
        raportXML = new RaportXMLButton(this);
        pieChartDisponibilitate = new PieChartDisponibilitateButton(this);
        pieChartPret = new PieChartPretButton(this);
        pieChartProducator = new PieChartProducatorButton(this);
    }

    public void instantiereComandaAdd() {
        adaugare = new AdaugareProdusButton(this, producatorValue, denumireValue, pretValue, dispValue, marimeValue, cantitateValue, idValue);
    }

    public void instantiereComandaDel() {
        stergere = new StergereProdusButton(this, rowValue);
    }

    public void instantiereComandaUpdate() {
        actualizare = new ActualizareProdusButton(this, producatorValue, denumireValue, pretValue, dispValue, marimeValue, cantitateValue, idValue, rowValue);
    }

    public void instantiereSearchProducator() {
        searchProducator = new SearchProducatorButton(this, searchValue);
    }

    public void instantiereSearchDisponibilitate() {
        searchDisponibilitate = new SearchDisponibilitateButton(this, searchValue);
    }

    public void instantiereSearchMarime() {
        searchMarime = new SearchMarimeButton(this, searchValue);
    }

    public Object[][] creareTabel(PersistentaIncaltaminte incaltaminteList) {
        int i = 0;
        int size = incaltaminteList.getIncaltamintep().size();
        Object[][] data = new Object[size][];
        for(IncaltaminteFinal x : incaltaminteList.getIncaltamintep()) {
            data[i] = new Object[] {x.getProducator(), x.getDenumire(), x.getPret(), x.getDisponibilitate(), x.getMarime(), x.getCantitate(), x.getId()};
            i++;
        }
        return data;
    }

    public void setProducatorValue(String producatorValue) {
        this.producatorValue = producatorValue;
    }

    public void setDenumireValue(String denumireValue) {
        this.denumireValue = denumireValue;
    }

    public void setPretValue(Float pretValue) {
        this.pretValue = pretValue;
    }

    public void setDispValue(Boolean dispValue) {
        this.dispValue = dispValue;
    }

    public void setMarimeValue(Integer marimeValue) {
        this.marimeValue = marimeValue;
    }

    public void setCantitateValue(Integer cantitateValue) {
        this.cantitateValue = cantitateValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }

    public void setRowValue(String[] rowValue) {
        this.rowValue = rowValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
