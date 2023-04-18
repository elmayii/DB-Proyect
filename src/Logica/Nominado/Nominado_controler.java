package Logica.Nominado;

import Logica.DTO.Nominado;

import java.sql.*;

public class Nominado_controler {

    public static void Create(Connection c, Nominado obj) {
        try {
            Statement st = c.createStatement();
            ResultSet e= st.executeQuery("SELECT count(*) FROM nominados");
            e.next();
            PreparedStatement ST= c.prepareStatement("INSERT INTO nominados (id,nombre,apellidos,fecha_nacimiento,direccion_particular,edad,integracion_revolucionaria, telefono, ocupacion, profesion, datos_biograficos, vuelta, votos,circunscripcion_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ST.setInt(1,e.getInt(1)+1);
            ST.setString(2,obj.getNombre());
            ST.setString(3,obj.getApellido());
            ST.setDate(4, (Date) obj.getFecha_nacimiento());
            ST.setString(5,obj.getDireccion());
            ST.setInt(6,obj.getEdad());
            ST.setString(7,obj.getIntegracion_revolucionaria());
            ST.setString(8,obj.getTelefono());
            ST.setString(9,obj.getOcupacion());
            ST.setString(10,obj.getProfesion());
            ST.setString(11,obj.getDatos_biograficos());
            ST.setInt(12,obj.getVuelta());
            ST.setInt(13,obj.getVotos());
            ST.setInt(14,obj.getCircunscripcion());
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
