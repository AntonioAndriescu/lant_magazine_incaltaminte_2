package org.example.Model.Persistenta;

import org.example.Connection.ConnectionFactory;
import org.example.Model.Utilizator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersistentaUtilizator {
    private List<Utilizator> utilizatori = null;

    public List<Utilizator> getUtilizatori() {
        return utilizatori;
    }

    public void setUtilizatori(List<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
    }

    static PersistentaUtilizator utilizatoriList = new PersistentaUtilizator();
    static  {
        utilizatoriList.setUtilizatori(new ArrayList<Utilizator>());
    }

    private static final String findStatementString = "SELECT * FROM utilizator";
    private static final String insertStatementString = "INSERT INTO utilizator (nume, prenume, email, functie, idMagazin, username, parola)" + " VALUES (?,?,?,?,?,?,?)";
    private static final String deleteStatementString = "DELETE FROM utilizator where email = ?";
    private static final String updateStatementString = "UPDATE utilizator SET nume = ?, prenume = ?, email = ?, functie = ?, idMagazin = ?, username = ?, parola = ? WHERE email = ?";

    public static PersistentaUtilizator unmarshal() throws SQLException {
        utilizatoriList.getUtilizatori().clear();
        try {
            Connection dbConnection = new ConnectionFactory().getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(findStatementString);
            while (rs.next()) {
                Utilizator utilizator = new Utilizator(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
                utilizatoriList.getUtilizatori().add(utilizator);
            }
            dbConnection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return utilizatoriList;
    }

    public static void adaugare(Utilizator utilizator) {
        Connection dbConnection = ConnectionFactory.singleInstance.getConnection();
        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, utilizator.getNume());
            insertStatement.setString(2, utilizator.getPrenume());
            insertStatement.setString(3, utilizator.getEmail());
            insertStatement.setString(4, utilizator.getFunctie());
            insertStatement.setInt(5, utilizator.getIdMagazin());
            insertStatement.setString(6, utilizator.getUsername());
            insertStatement.setString(7, utilizator.getParola());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void stergere(Utilizator utilizator) {
        Connection dbConnection = ConnectionFactory.singleInstance.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, utilizator.getEmail());
            deleteStatement.execute();
            ResultSet rs = deleteStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(Utilizator u1, Utilizator u2) {
        Connection dbConnection = ConnectionFactory.singleInstance.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, u2.getNume());
            updateStatement.setString(2, u2.getPrenume());
            updateStatement.setString(3, u2.getEmail());
            updateStatement.setString(4, u2.getFunctie());
            updateStatement.setInt(5, u2.getIdMagazin());
            updateStatement.setString(6, u2.getUsername());
            updateStatement.setString(7, u2.getParola());
            updateStatement.setString(8, u1.getEmail());
            updateStatement.executeUpdate();
            ResultSet rs = updateStatement.getGeneratedKeys();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
