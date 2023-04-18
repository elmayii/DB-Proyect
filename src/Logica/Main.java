package Logica;

import Logica.CDR.CDR;
import Logica.CDR.CDR_controler;
import Logica.Circunscripcion.Circunscripcion;
import Logica.Circunscripcion.Circunscripcion_controler;
import Logica.Colegio.Colegio;
import Logica.Colegio.Colegio_controler;
import Logica.Elector.Elector;
import Logica.Elector.Elector_controler;
import Logica.Municipio.Municipio;
import Logica.Municipio.Municipio_controler;
import Logica.Nominado.Nominado;
import Logica.Nominado.Nominado_controler;

import java.sql.Date;

public class Main {

    public static void main(String [] args){
        Conection obj=new Conection();
        obj.doConcect();
        CDR_controler.ReadOne(obj.conection,1);
        //CDR_controler.Update(obj.conection,new CDR("sss","cicicici", 1),1);
        //Nominado s= new Nominado("asdfxz","adzzz", new Date(100,2,16), "aweruiwiwuidu ufhuewu eu9wfhe", 20, "adac","asdz","sdaz","asdxx","afaf dfs dwf ",2,2666,1);
        //Nominado_controler.Create(obj.conection, s);
        //CDR_controler.Create( obj.conection,new Logica.CDR("asda","sdasd", 2));
    }
}
