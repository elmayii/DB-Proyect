package Service;

import Config.Conection;
import Dto.Colegio;

import java.sql.*;
import java.util.LinkedList;

public class Colegio_service {
    public static void Create(String nombre,String direccion,int circunscripcion_id) {
        try {
            int limit=1;
            Conection c= new Conection();
            if(!ReadAll().isEmpty()){
                limit=ReadAll().getLast().getId()+1;
            }
            CallableStatement ST= c.getConection().prepareCall("{call create_colegio(?,?,?,?)}");
            ST.setInt(1,limit);
            ST.setString(2, nombre);
            ST.setString(3, direccion);
            ST.setInt(4,circunscripcion_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Update(String nombre,String direccion,int circunscripcion_id, int id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_colegio(?,?,?,?)}");
            ST.setInt(1,id);
            ST.setString(2,nombre);
            ST.setString(3,direccion);
            ST.setInt(4,circunscripcion_id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_colegio(?)}");
            ST.setInt(1,id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static Colegio ReadOne(int id){
        try{
            Conection c= new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_colegio(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return new Colegio(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static LinkedList<Colegio> ReadAll(){
        try{
            LinkedList<Colegio> Colegio_list= new LinkedList<Colegio>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM colegio");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Colegio colegio=new Colegio(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4));
                Colegio_list.add(colegio);
            }
            System.out.println(set);
            return Colegio_list;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
