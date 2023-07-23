package Service;

import Config.Conection;
import Dto.CDR;
import Dto.Nominado;
import Dto.Parte;

import java.sql.*;
import java.util.LinkedList;

public class Parte_service {

    public static void Create(Timestamp fecha_hora, int electores_eliminados, int electores_agregados, int colegio_id) {
        try {
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call create_parte(?,?,?,?)}");
            ST.setTimestamp(1,fecha_hora);
            ST.setInt(2,electores_eliminados);
            ST.setInt(3,electores_agregados);
            ST.setInt(4,colegio_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(int id,Timestamp fecha_hora, int electores_eliminados, int electores_agregados, int colegio_id){
        try{
            Conection c= new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_parte(?,?,?,?,?)}");
            ST.setInt(1,id);
            ST.setTimestamp(2,fecha_hora);
            ST.setInt(3,electores_eliminados);
            ST.setInt(4,electores_agregados);
            ST.setInt(5,colegio_id);
            ResultSet RS = ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(int Id){
        try {
            Conection c=new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call delete_parte(?)}");
            ST.setInt(1,Id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static Parte ReadOne(int Id){
        try{
            Conection c=new Conection();
            CallableStatement CST= c.getConection().prepareCall("{call getbyid_parte(?)}");
            CST.setInt(1,Id);
            ResultSet set= CST.executeQuery();
            set.next();
            return new Parte(set.getInt(1),set.getTimestamp(2),set.getInt(3),set.getInt(4),set.getInt(5),set.getInt(6),set.getInt(7));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static LinkedList<Parte> ReadAll(){
        try{
            LinkedList<Parte> Parte_list= new LinkedList<Parte>();
            Conection c= new Conection();
            Statement st = c.getConection().createStatement();
            PreparedStatement ST= c.getConection().prepareStatement("SELECT * FROM nominados");
            ResultSet set= ST.executeQuery();
            while (set.next()){
                Parte parte=new Parte(set.getInt(1),set.getTimestamp(2),set.getInt(3),set.getInt(4),set.getInt(5),set.getInt(6),set.getInt(7));
                Parte_list.add(parte);
            }
            return Parte_list;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
