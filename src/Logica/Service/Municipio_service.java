package Logica.Service;

import Logica.Config.Conection;
import Logica.DTO.Colegio;
import Logica.DTO.Municipio;

import java.sql.*;
import java.util.LinkedList;

public class Municipio_service {
    public static void Create(String nombre) {
        try {
            Conection c= new Conection();
            int limit=ReadAll().size();
            CallableStatement ST= c.getConection().prepareCall("{call create_municipio(?,?)}");
            ST.setInt(1,limit+1);
            ST.setString(2, nombre);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Update(String nombre, int id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_municipio(?,?)}");
            ST.setInt(1,id);
            ST.setString(2,nombre);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_municipio(?)}");
            ST.setInt(1,id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static Municipio ReadOne(int id){
        try{
            Conection c= new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_municipio(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return new Municipio(set.getInt(1),set.getString(2));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static LinkedList<Municipio> ReadAll(){
        try{
            LinkedList<Municipio> Municipio_list= new LinkedList<Municipio>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM municipio");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Municipio municipio=new Municipio(set.getInt(1),set.getString(2));
                Municipio_list.add(municipio);
            }
            System.out.println(set);
            return Municipio_list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
