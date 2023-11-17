package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String PASSWORD = "Jin800##";
    private static final String LOGIN = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/javaproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=false&useSSL=false";
    private static Connection connection;
    private Statement statement;
    private String filename = "BoulderDashMap1.txt";
    public DBConnection() {
        this.connection = null;
        this.statement = null;
    }
    public boolean open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DBConnection.URL,
                    DBConnection.LOGIN, DBConnection.PASSWORD);
            this.statement = this.connection.createStatement();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<String> loadBD(final String name1) {
        try {
            final String sql = "{call GetMapByName(?)}";
            final CallableStatement call = connection.prepareCall(sql);
            call.setString(1, name1);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            List<String> mapLines = new ArrayList<>();

            while (resultSet.next()) {
                String line = resultSet.getString("line");
                mapLines.add(line);
            }
            return mapLines;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public void saveToFile(List<String> mapLines, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String line : mapLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
