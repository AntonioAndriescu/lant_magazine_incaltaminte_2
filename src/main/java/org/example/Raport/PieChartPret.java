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

public class PieChartPret extends ApplicationFrame {

    public PieChartPret(String title ) throws SQLException {
        super( title );
        setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset( ) throws SQLException {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        PersistentaIncaltaminte incaltaminte = PersistentaIncaltaminte.unmarshal();
        List<Float> pret = new ArrayList<>();
        for(IncaltaminteFinal x : incaltaminte.getIncaltamintep()) {
            int nr = 0;
            if(!pret.contains(x.getPret())) {
                pret.add(x.getPret());
                for(IncaltaminteFinal y : incaltaminte.getIncaltamintep()) {
                    if(y.getPret() == x.getPret()) {
                        nr += y.getCantitate();
                    }
                }
                System.out.println(nr);
                dataset.setValue(String.valueOf(x.getPret()), nr);
            }
        }
        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Price",
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

    public static void createChartPrice() throws SQLException {
        PieChartPret demo = new PieChartPret( "Pie chart" );
        demo.setSize( 560 , 367 );
        RefineryUtilities.centerFrameOnScreen( demo );
        demo.setVisible( true );
    }
}