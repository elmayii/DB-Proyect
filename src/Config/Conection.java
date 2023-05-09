package Config;

import java.sql.*;

public class Conection {
    public Connection conection=null;

    String usuario="postgres";
    String password="firYaDaUQch2";
    String bd="Java";
    String ip="localhost";
    String port="5432";

    String url = "jdbc:postgresql://"+ip+":"+port+"/"+bd;

    public void doConcect(){
        try {
            Class.forName("org.postgresql.Driver");
            conection= DriverManager.getConnection(url,usuario,password);
            System.out.println("OKKKKKK");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Connection getConection() {
        doConcect();
        return conection;
    }
}
