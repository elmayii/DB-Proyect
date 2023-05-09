package Service;

import Config.Conection;
import Dto.CDR;
import Dto.Circunscripcion;

import java.sql.*;
import java.util.LinkedList;

public class Circunscripcion_service {
    public static void Create(String nombre,int municipio_id) {
        try {
            int limit=1;
            Conection c= new Conection();
            if(ReadAll()!=null){
               limit=ReadAll().getLast().getId()+1;
            }
            CallableStatement ST= c.getConection().prepareCall("{call create_circunscripcion(?,?,?)}");
            ST.setInt(1,limit);
            ST.setString(2, nombre);
            ST.setInt(3,municipio_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(String nombre,int municipio_id, int id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_circunscripcion(?,?,?)}");
            ST.setString(1, nombre);
            ST.setInt(2,municipio_id);
            ST.setInt(3,id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_circunscripcion(?)}");
            ST.setInt(1,id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static Circunscripcion ReadOne(int id){
        try{
            Conection c= new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_circunscripcion(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return new Circunscripcion(set.getInt(1),set.getString(2),set.getInt(3));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static LinkedList<Circunscripcion> ReadAll(){
        try{
            LinkedList<Circunscripcion> Circunscripcion_list= new LinkedList<Circunscripcion>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM circunscripcion");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Circunscripcion circunscripcion=new Circunscripcion(set.getInt(1),set.getString(2),set.getInt(3));
                Circunscripcion_list.add(circunscripcion);
            }
            System.out.println(set);
            return Circunscripcion_list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
