package org.example.ViewModel.Commands;

import org.example.Raport.PieChartDisponibilitate;
import org.example.ViewModel.VMUtilizator;

import java.sql.SQLException;

public class PieChartDisponibilitateButton implements Command {
    public PieChartDisponibilitateButton(VMUtilizator vm) {}

    @Override
    public void execute() {
        try {
            PieChartDisponibilitate.createChartDisp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
