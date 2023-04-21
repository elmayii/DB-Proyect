package Logica.Service;

import Logica.Config.Conection;
import Logica.DTO.Colegio;
import Logica.DTO.Elector;

import java.sql.*;
import java.util.LinkedList;

public class Elector_service {

    public static void Create(String nombre,String apellidos,Date fecha_nacimiento, String direccion_particular,int cdr_id) {
        try {
            Conection c= new Conection();
            int limit=ReadAll().size();
            CallableStatement ST= c.getConection().prepareCall("{call create_elector(?,?,?,?,?,?)}");
            ST.setInt(1,limit+1);
            ST.setString(2, nombre);
            ST.setString(3, apellidos);
            ST.setDate(4,fecha_nacimiento);
            ST.setString(5,direccion_particular);
            ST.setInt(6,cdr_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(String nombre,String apellidos,Date fecha_nacimiento, String direccion_particular,int cdr_id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_elector(?,?,?,?,?)}");
            ST.setString(1,nombre);
            ST.setString(2, apellidos);
            ST.setDate(3,fecha_nacimiento);
            ST.setString(4,direccion_particular);
            ST.setInt(5,cdr_id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_elector(?)}");
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
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_elector(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return new Elector(set.getInt(1),set.getString(2),set.getString(3),set.getDate(4),set.getString(5),set.getInt(6));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static LinkedList<Elector> ReadAll(){
        try{
            LinkedList<Elector> Elector_list= new LinkedList<Elector>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM elector");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Elector elector=new Elector(set.getInt(1),set.getString(2),set.getString(3),set.getDate(4),set.getString(5),set.getInt(6));
                Elector_list.add(elector);
            }
            System.out.println(set);
            return Elector_list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
