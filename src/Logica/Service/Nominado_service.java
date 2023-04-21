package Logica.Service;

import Logica.Config.Conection;
import Logica.DTO.Elector;
import Logica.DTO.Nominado;

import java.sql.*;
import java.util.LinkedList;

public class Nominado_service {

    public static void Create(String nombre, String apellidos,Date fecha_nacimiento, String direccion, int edad, String integracion_revolucionaria, String telefono, String ocupacion, String profesion, String datos_biograficos, int vuelta, int votos, int circunscripcion_id) {
        try {
            Conection c= new Conection();
            int limit=ReadAll().size();
            CallableStatement ST= c.getConection().prepareCall("{call create_nominados(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ST.setInt(1,limit+1);
            ST.setString(2, nombre);
            ST.setString(3, apellidos);
            ST.setDate(4,fecha_nacimiento);
            ST.setString(5,direccion);
            ST.setInt(6,edad);
            ST.setString(7, integracion_revolucionaria);
            ST.setString(8, telefono);
            ST.setString(9, ocupacion);
            ST.setString(10, profesion);
            ST.setString(11, datos_biograficos);
            ST.setInt(12,vuelta);
            ST.setInt(13,votos);
            ST.setInt(14,circunscripcion_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Update(int id,String nombre, String apellidos,Date fecha_nacimiento, String direccion, int edad, String integracion_revolucionaria, String telefono, String ocupacion, String profesion, String datos_biograficos, int vuelta, int votos, int circunscripcion_id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_nominados(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ST.setInt(1,id);
            ST.setString(2, nombre);
            ST.setString(3, apellidos);
            ST.setDate(4,fecha_nacimiento);
            ST.setString(5,direccion);
            ST.setInt(6,edad);
            ST.setString(7, integracion_revolucionaria);
            ST.setString(8, telefono);
            ST.setString(9, ocupacion);
            ST.setString(10, profesion);
            ST.setString(11, datos_biograficos);
            ST.setInt(12,vuelta);
            ST.setInt(13,votos);
            ST.setInt(14,circunscripcion_id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_nominados(?)}");
            ST.setInt(1,id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static Elector ReadOne(int id){
        try{
            Conection c= new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_nominados(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return new Nominado(set.getInt(1),set.getString(2),set.getString(3),set.getDate(4),set.getString(5),set.getInt(6),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getInt(12),set.getInt(13),set.getInt(14));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static LinkedList<Nominado> ReadAll(){
        try{
            LinkedList<Nominado> Nominado_list= new LinkedList<Nominado>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM nominados");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Nominado nominado=new Nominado(set.getInt(1),set.getString(2),set.getString(3),set.getDate(4),set.getString(5),set.getInt(6),set.getString(7),set.getString(8),set.getString(9),set.getString(10),set.getString(11),set.getInt(12),set.getInt(13),set.getInt(14));
                Nominado_list.add(nominado);
            }
            return Nominado_list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
