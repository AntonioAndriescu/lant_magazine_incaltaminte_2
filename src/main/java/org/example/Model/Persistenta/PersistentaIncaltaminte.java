package org.example.Model.Persistenta;

import org.example.Connection.ConnectionFactory;
import org.example.Model.IncaltaminteFinal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "incaltamintep")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersistentaIncaltaminte {
    @XmlElement(name = "incaltaminte")
    private List<IncaltaminteFinal> incaltaminte;

    public List<IncaltaminteFinal> getIncaltamintep() {
        return incaltaminte;
    }

    public void setIncaltamintep(List<IncaltaminteFinal> incaltaminte) {
        this.incaltaminte = incaltaminte;
    }

    static PersistentaIncaltaminte incaltaminteList = new PersistentaIncaltaminte();
    static  {
        incaltaminteList.setIncaltamintep(new ArrayList<IncaltaminteFinal>());
    }

    private final static String findStatementString = "SELECT * FROM incaltaminte";
    private static final String insertStatementString = "INSERT INTO incaltaminte (producator, denumire, pret, disponibilitate, id, marime, cantitate)"
            + " VALUES (?,?,?,?,?,?,?)";
    private static final String deleteStatementString = "DELETE FROM incaltaminte where id = ?";
    private static final String updateStatementString = "UPDATE incaltaminte SET producator = ?, denumire = ?, pret = ?, disponibilitate = ?, id = ?, marime = ?, cantitate = ? WHERE id = ?";

    public static PersistentaIncaltaminte unmarshal() throws SQLException{
        incaltaminteList.getIncaltamintep().clear();
        try {
            Connection dbConnection = new ConnectionFactory().getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(findStatementString);
            while (rs.next()) {
                IncaltaminteFinal incaltaminte = new IncaltaminteFinal(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getBoolean(4),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(5));
                incaltaminteList.getIncaltamintep().add(incaltaminte);
            }
            dbConnection.close();

        } catch(Exception e) {
            System.out.println(e);
        }
        return incaltaminteList;
    }

    public static void adaugareIncaltaminte(IncaltaminteFinal incaltaminte) {
        Connection dbConnection = ConnectionFactory.singleInstance.getConnection();
        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, incaltaminte.getProducator());
            insertStatement.setString(2, incaltaminte.getDenumire());
            insertStatement.setFloat(3, incaltaminte.getPret());
            insertStatement.setBoolean(4, incaltaminte.getDisponibilitate());
            insertStatement.setInt(5, incaltaminte.getId());
            insertStatement.setInt(6, incaltaminte.getMarime());
            insertStatement.setInt(7, incaltaminte.getCantitate());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void stergereIncaltaminte(IncaltaminteFinal incaltaminte) {
        Connection dbConnection = ConnectionFactory.singleInstance.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, incaltaminte.getId());
            deleteStatement.execute();
            ResultSet rs = deleteStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateIncaltaminte(IncaltaminteFinal incaltaminte1, IncaltaminteFinal incaltaminte2) {
        Connection dbConnection = ConnectionFactory.singleInstance.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, incaltaminte2.getProducator());
            updateStatement.setString(2, incaltaminte2.getDenumire());
            updateStatement.setFloat(3, incaltaminte2.getPret());
            updateStatement.setBoolean(4, incaltaminte2.getDisponibilitate());
            updateStatement.setInt(5, incaltaminte2.getId());
            updateStatement.setInt(6, incaltaminte2.getMarime());
            updateStatement.setInt(7, incaltaminte2.getCantitate());
            updateStatement.setInt(8, incaltaminte1.getId());
            updateStatement.executeUpdate();
            ResultSet rs = updateStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

