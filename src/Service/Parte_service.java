package Service;

import Config.Conection;
import Dto.CDR;
import Dto.Nominado;
import Dto.Parte;

import java.sql.*;
import java.util.LinkedList;

public class Parte_service {

    public static void Create(Date fecha_hora, int votos_total, int electores_eliminados, int electores_agregados, int electores_actual, int colegio_id) {
        try {
            int limit=1;
            Conection c= new Conection();
            if(ReadAll()!=null){
                limit=ReadAll().getLast().getId()+1;
            }
            CallableStatement ST= c.getConection().prepareCall("{call create_parte(?,?,?,?,?,?,?)}");
            ST.setInt(1,limit);
            ST.setDate(2,fecha_hora);
            ST.setInt(3,votos_total);
            ST.setInt(4,electores_eliminados);
            ST.setInt(5,electores_agregados);
            ST.setInt(6,electores_actual);
            ST.setInt(7,colegio_id);
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(int id,Date fecha_hora, int votos_total, int electores_eliminados, int electores_agregados, int electores_actual, int colegio_id, int Id){
        try{
            Conection c=new Conection();
            CallableStatement ST= c.getConection().prepareCall("{call update_parte(?,?,?,?,?,?,?)}");
            ST.setInt(1,id);
            ST.setDate(2,fecha_hora);
            ST.setInt(3,votos_total);
            ST.setInt(4,electores_eliminados);
            ST.setInt(5,electores_agregados);
            ST.setInt(6,electores_actual);
            ST.setInt(7,colegio_id);
            ResultSet rs= ST.executeQuery();
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
            return new Parte(set.getInt(1),set.getDate(2),set.getInt(3),set.getInt(4),set.getInt(5),set.getInt(6),set.getInt(7));
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
                Parte parte=new Parte(set.getInt(1),set.getDate(2),set.getInt(3),set.getInt(4),set.getInt(5),set.getInt(6),set.getInt(7));
                Parte_list.add(parte);
            }
            return Parte_list;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
