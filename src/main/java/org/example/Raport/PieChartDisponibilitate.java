package org.example.Raport;

import javax.swing.JPanel;

import org.example.Model.IncaltaminteFinal;
import org.example.Model.Persistenta.PersistentaIncaltaminte;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.sql.SQLException;

public class PieChartDisponibilitate extends ApplicationFrame {

    public PieChartDisponibilitate(String title ) throws SQLException {
        super( title );
        setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset( ) throws SQLException {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
        int t = 0, f = 0;
        for(IncaltaminteFinal x : incaltaminte.getIncaltamintep()) {
            if(x.getDisponibilitate()) {
                t++;
            }
            else {
                f++;
            }
        }

        dataset.setValue( "Avaible" , t );
        dataset.setValue( "Unavaible" , f );
        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Avaibility",
                dataset,
                true,
                true,
                false);
        return chart;
    }

    public static JPanel createDemoPanel( ) throws SQLException {
        JFreeChart chart = createChart(createDataset( ) );
        return new ChartPanel( chart );
    }

    public static void createChartDisp() throws SQLException {
        PieChartDisponibilitate demo = new PieChartDisponibilitate( "Pie chart" );
        demo.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
    }
}