package Logica.Service;

import Logica.Config.Conection;
import Logica.DTO.CDR;

import java.sql.*;
import java.util.LinkedList;

public class CDR_service {


    public static void Create(String nombre,String nombre_presidente,int colegio_id) {
        try {
            Conection c= new Conection();
            int limit=ReadAll().size();
            CallableStatement ST= c.getConection().prepareCall("{call create_cdr(?,?,?,?)}");
            ST.setInt(1,limit+1);
            ST.setString(2, nombre);
            ST.setString(3,nombre_presidente);
            ST.setInt(4,colegio_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(String nombre,String nombre_presidente,int colegio_id, int id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_cdr(?,?,?,?)}");
            ST.setInt(1, id);
            ST.setString(2,nombre);
            ST.setString(3,nombre_presidente);
            ST.setInt(4,colegio_id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(int id){
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_cdr(?)}");
            ST.setInt(1,id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static CDR ReadOne(int id){
        try{
            Conection c= new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_cdr(?)}");
            CST.setInt(1,id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return new CDR(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static ResultSet ShowCDR(Connection c){
        try{

        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static LinkedList<CDR> ReadAll(){
        try{
            LinkedList<CDR> CDR_list= new LinkedList<CDR>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM cdr");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                CDR cdr=new CDR(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4));
                CDR_list.add(cdr);
            }
            System.out.println(set);
            return CDR_list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
