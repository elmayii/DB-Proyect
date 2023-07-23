package Service;

import Config.Conection;
import Dto.Circunscripcion;
import Dto.Listado;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Listado_service {

    public static void Update(int elector_id, int colegio_id, boolean votodo, String causa_no_voto){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_listado(?,?,?,?)}");
            ST.setInt(1, elector_id);
            ST.setInt(2,colegio_id);
            ST.setBoolean(3,votodo);
            ST.setString(4,causa_no_voto);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_listado(?)}");
            ST.setInt(1,id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static Listado ReadOne(int id){
        try{
            Conection c= new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_listado(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            return new Listado(set.getInt(1),set.getInt(2),set.getBoolean(3),set.getString(4));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static LinkedList<Listado> ReadAll(){
        try{
            LinkedList<Listado> Listado_list= new LinkedList<Listado>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM listado");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Listado listado=new Listado(set.getInt(1),set.getInt(2),set.getBoolean(3),set.getString(4));
                Listado_list.add(listado);
            }
            System.out.println(set);
            return Listado_list;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
