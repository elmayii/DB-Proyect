package Logica.Elector;

import Logica.Colegio.Colegio;

import java.sql.*;

public class Elector_controler {

    public static void Create(Connection c, Elector obj) {
        try {
            Statement st = c.createStatement();
            ResultSet e= st.executeQuery("SELECT count(*) FROM elector");
            e.next();
            PreparedStatement ST= c.prepareStatement("INSERT INTO elector (id,nombre,apellidos,fecha_nacimiento,direccion_particular,cdr_id) VALUES(?,?,?,?,?,?)");
            ST.setInt(1,e.getInt(1)+1);
            ST.setString(2,obj.getNombre());
            ST.setString(3,obj.getApellido());
            ST.setDate(4, (Date) obj.getFecha_nacimiento());
            ST.setString(5,obj.getDireccion());
            ST.setInt(6,obj.getCdr_id());
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
