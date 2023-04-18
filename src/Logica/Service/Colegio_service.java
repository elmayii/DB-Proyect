package Logica.Service;

import Logica.DTO.Colegio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Colegio_service {
    public static void Create(Connection c, Colegio obj) {
        try {
            Statement st = c.createStatement();
            ResultSet e= st.executeQuery("SELECT count(*) FROM colegio");
            e.next();
            PreparedStatement ST= c.prepareStatement("INSERT INTO colegio (id,nombre,direccion,circunscripcion_id) VALUES(?,?,?,?)");
            ST.setInt(1,e.getInt(1)+1);
            ST.setString(2,obj.getNombre());
            ST.setString(3,obj.getDir());
            ST.setInt(4,obj.getCircunscripcion_id());
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
