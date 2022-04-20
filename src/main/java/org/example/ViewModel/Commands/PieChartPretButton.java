package org.example.ViewModel.Commands;

import org.example.Raport.PieChartPret;
import org.example.ViewModel.VMUtilizator;

import java.sql.SQLException;

public class PieChartPretButton implements Command {
    public PieChartPretButton(VMUtilizator vm) {}

    @Override
    public void execute() {
        try {
            PieChartPret.createChartPrice();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
