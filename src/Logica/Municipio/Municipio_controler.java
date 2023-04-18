package Logica.Municipio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Municipio_controler {
    public static void Create(Connection c, Municipio obj) {
        try {
            Statement st = c.createStatement();
            ResultSet e= st.executeQuery("SELECT count(*) FROM municipio");
            e.next();
            PreparedStatement ST= c.prepareStatement("INSERT INTO MUNICIPIO (id,nombre) VALUES(?,?)");
            ST.setInt(1,e.getInt(1)+1);
            ST.setString(2,obj.getNombre());
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
