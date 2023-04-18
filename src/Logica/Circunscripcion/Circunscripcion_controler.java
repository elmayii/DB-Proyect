package Logica.Circunscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Circunscripcion_controler {
    public static void Create(Connection c, Circunscripcion obj) {
        try {
            Statement st = c.createStatement();
            ResultSet e= st.executeQuery("SELECT count(*) FROM CIRCUNSCRIPCION");
            e.next();
            PreparedStatement ST= c.prepareStatement("INSERT INTO CIRCUNSCRIPCION (id,nombre,municipio_id) VALUES(?,?,?)");
            ST.setInt(1,e.getInt(1)+1);
            ST.setString(2,obj.getNombre());
            ST.setInt(3,obj.getMunicipio_id());
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
