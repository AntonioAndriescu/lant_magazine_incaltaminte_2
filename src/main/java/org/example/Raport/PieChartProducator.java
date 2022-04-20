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
import java.util.ArrayList;
import java.util.List;

public class PieChartProducator extends ApplicationFrame {

    public PieChartProducator(String title ) throws SQLException {
        super( title );
        setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset( ) throws SQLException {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
        List<String> producator = new ArrayList<>();
        for(IncaltaminteFinal x : incaltaminte.getIncaltamintep()) {
            int nr = 0;
            if(!producator.contains(x.getProducator())) {
                producator.add(x.getProducator());
                for(IncaltaminteFinal y : incaltaminte.getIncaltamintep()) {
                    if(y.getProducator().equals(x.getProducator())) {
                        nr += y.getCantitate();
                    }
                }
                System.out.println(nr);
                dataset.setValue(String.valueOf(x.getProducator()), nr);
            }
        }

        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Producator",
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

    public static void createChartProducator() throws SQLException {
        PieChartProducator demo = new PieChartProducator( "Pie chart" );
        demo.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
    }
}