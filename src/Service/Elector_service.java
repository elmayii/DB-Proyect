package Service;

import Config.Conection;
import Dto.Elector;

import java.sql.*;
import java.util.LinkedList;

public class Elector_service {

    public static void Create(String nombre,String apellidos,Date fecha_nacimiento, String direccion_particular,int cdr_id) {
        try {
            int limit=1;
            Conection c= new Conection();
            if(!ReadAll().isEmpty()){
                limit=ReadAll().getLast().getId()+1;
            }
            CallableStatement ST= c.getConection().prepareCall("{call create_elector(?,?,?,?,?,?,?)}");
            ST.setInt(1,limit);
            ST.setString(2, nombre);
            ST.setString(3, apellidos);
            ST.setDate(4,fecha_nacimiento);
            ST.setString(5,direccion_particular);
            ST.setInt(6,cdr_id);
            ST.setInt(7,1);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(int id,String nombre,String apellidos,Date fecha_nacimiento, String direccion_particular,int cdr_id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_elector(?,?,?,?,?,?)}");
            ST.setInt(1,id);
            ST.setString(2,nombre);
            ST.setString(3, apellidos);
            ST.setDate(4,fecha_nacimiento);
            ST.setString(5,direccion_particular);
            ST.setInt(6,cdr_id);
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
            return new Elector(set.getInt(1),set.getString(2),set.getString(3),set.getDate(4),set.getString(5),set.getInt(6),set.getInt(7),set.getString(8));
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
                Elector elector=new Elector(set.getInt(1),set.getString(2),set.getString(3),set.getDate(4),set.getString(5),set.getInt(6),set.getInt(7),set.getString(8));
                Elector_list.add(elector);
            }
            System.out.println(set);
            return Elector_list;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
