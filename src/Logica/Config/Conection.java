package Logica.Config;

import java.sql.*;

public class Conection {
    private Connection conection=null;

    String usuario="postgres";
    String contraseña="firYaDaUQch2";
    String bd="Java";
    String ip="localhost";
    String port="5432";

    String url = "jdbc:postgresql://"+ip+":"+port+"/"+bd;

    public Conection(){
        try {
            Class.forName("org.postgresql.Driver");
            conection= DriverManager.getConnection(url,usuario,contraseña);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Connection getConection(){
        return this.conection;
    }

}
