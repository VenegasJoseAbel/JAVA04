package Modelo;

// La clase Programador es hija de la clase EMPLEADO

import java.io.Serializable;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class Programador extends Empleado {
    
    //Decalraciones de las variables expecificas de Programador
    private float Sueldo_extra; //Varibale Dada
    private String Lenguaje; //Variable Inventada de nombre y tipo distinto que la de Analista 
        
    //Declaracio del Constructor
    public Programador(int Numero, String Nombre, float Sueldo, float SueldoMaximo, float Sueldo_extra, String Lenguaje) {
        super(Numero, Nombre, Sueldo, SueldoMaximo);
        this.Sueldo_extra = Sueldo_extra;
        this.Lenguaje = Lenguaje;      
        Tipo = "Programador";
    }
    
    
    //Declaraciones de los metodos Setters

    public void setSueldo_extra(float Sueldo_extra) {
        this.Sueldo_extra = Sueldo_extra;
    }

    public void setLenguaje(String Lenguaje) {
        this.Lenguaje = Lenguaje;
    }
        
    
    //Declaraciones de los metodos Getters

    public float getSueldo_extra() {
        return Sueldo_extra;
    }

    public String getLenguaje() {
        return Lenguaje;
    }
    

    @Override
    public boolean CumplirMes() {
        
        int dia = fecha_alta.get(DAY_OF_MONTH);
        
        return DIA_DEL_MES == dia;
    }

    @Override
    public boolean CumplirAño() {return false;}
    
    
    @Override
    public String toString() {
        return "Programador: " + "Numero: " + getNumero() + ", Nombre: " + getNombre() + ", Sueldo: " + getSueldo() + ", SueldoMaximo: " + getSueldoMaximo() + ", Sueldo Extra: " + Sueldo_extra + ", Lenguaje : " + Lenguaje + ", fecha_alta: " + getFecha_alta();
    }
    
}
