package org.example.ViewModel.Commands;

import org.example.Raport.PieChartProducator;
import org.example.ViewModel.VMUtilizator;

import java.sql.SQLException;

public class PieChartProducatorButton implements Command {
    public PieChartProducatorButton(VMUtilizator vm) {}

    @Override
    public void execute() {
        try {
            PieChartProducator.createChartProducator();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
