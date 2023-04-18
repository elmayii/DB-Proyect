package Logica.CDR;

import Logica.Colegio.Colegio;

import java.sql.*;

public class CDR_controler {


    public static void Create(Connection c, CDR obj) {
        try {
            Statement st = c.createStatement();
            ResultSet e= st.executeQuery("SELECT count(*) FROM cdr");
            e.next();
            PreparedStatement ST= c.prepareStatement("INSERT INTO cdr (id,nombre,nombre_presidente,colegio_id) VALUES(?,?,?,?)");
            ST.setInt(1,e.getInt(1)+1);
            ST.setString(2,obj.getNombre());
            ST.setString(3,obj.getNombre_presidente());
            ST.setInt(4,obj.getColegio_id());
            ResultSet RS = ST.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Update(Connection c, CDR obj, int Id){
        try{
            PreparedStatement ST= c.prepareStatement("UPDATE cdr SET nombre=?, nombre_presidente=?, colegio_id=? WHERE id=?");
            ST.setString(1, obj.getNombre());
            ST.setString(2, obj.getNombre_presidente());
            ST.setInt(3,obj.getColegio_id());
            ST.setInt(4,Id);
            ResultSet rs= ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void Delete(Connection c, int Id){
        try {
            PreparedStatement ST= c.prepareStatement("DELETE FROM cdr WHERE id=?");
            ST.setInt(1,Id);
            ResultSet rs=ST.executeQuery();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static ResultSet ReadOne(Connection c, int Id){
        try{
            CallableStatement CST= c.prepareCall("{call getcdr_id(?)}");
            CST.setInt(1,Id);
            ResultSet set= CST.executeQuery();
            set.next();
            System.out.println(set.getInt(1));
            System.out.println(set.getString(2));
            return set;
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

    public static ResultSet ReadAll(Connection c){
        try{
            PreparedStatement ST= c.prepareStatement("SELECT * FROM cdr");
            ResultSet set= ST.executeQuery();
            System.out.println(set);
            return set;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
