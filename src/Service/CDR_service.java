package Service;

import Config.Conection;
import Dto.CDR;
import Dto.Colegio;

import java.sql.*;
import java.util.LinkedList;

public class CDR_service {


    public static void Create(String nombre,String nombre_presidente,int colegio_id) {
        try {
            int limit=1;
            Conection c= new Conection();
            if(ReadAll()!=null){
                limit=ReadAll().getLast().getId()+1;
            }
            CallableStatement ST= c.getConection().prepareCall("{call create_cdr(?,?,?,?)}");
            ST.setInt(1,limit);
            ST.setString(2,nombre);
            ST.setString(3,nombre_presidente);
            ST.setInt(4,colegio_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(String nombre,String nombre_presidente,int colegio_id, int Id){
        try{
            Conection c=new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_cdr(?,?,?,?)}");
            ST.setInt(1,Id);
            ST.setString(2, nombre);
            ST.setString(3, nombre_presidente);
            ST.setInt(4,colegio_id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(int Id){
        try {
            Conection c=new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_cdr(?)}");
            ST.setInt(1,Id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static CDR ReadOne(int Id){
        try{
            Conection c=new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_cdr(?)}");
            CST.setInt(1,Id);
            ResultSet set= CST.executeQuery();
            set.next();
            return new CDR(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4));
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

    public static ResultSet ReadAllA(Connection c){
        try{
            CallableStatement ST= c.prepareCall("{call getall()}");
            ResultSet set= ST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            set.next();
            System.out.println(set.getInt(1));
            return set;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
