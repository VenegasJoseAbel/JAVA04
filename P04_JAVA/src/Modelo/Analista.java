package Modelo;

// La clase Analista es hija de la clase EMPLEADO

import java.io.Serializable;
import java.util.Calendar;
import static java.util.Calendar.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class Analista extends Empleado {
    
    //Decalraciones de las variables expecificas de Analista
    private float PlusAnual; //Variable Dada
    private int nDepar; //Variable Inventada

    
    //Declaracion del Constructor
    public Analista(int Numero, String Nombre, float Sueldo, float SueldoMaximo, float PlusAnual, int nDepar) {
        super(Numero, Nombre, Sueldo, SueldoMaximo); //llamamos al contructor del padre
        this.PlusAnual = PlusAnual;
        this.nDepar = nDepar;
        Tipo = "Analista";
    }
    
    
    //Declaraciones de los metodos Setters
    public void setPlusAnual(float PlusAnual) {
        this.PlusAnual = PlusAnual;
    }

    public void setnDepar(int nDepar) {
        this.nDepar = nDepar;
    }
    
    
    //Declaraciones de los metodos Getters
    public float getPlusAnual() {
        return PlusAnual;
    }

    public int getnDepar() {
        return nDepar;
    }
    

    @Override
    public boolean CumplirMes() {return false;}

    @Override
    public boolean CumplirAño() {
        
        int mes = fecha_alta.get(MONTH);
        int dia = fecha_alta.get(DAY_OF_MONTH);
        
        return MES == mes+1 && dia == DIA_DEL_MES;
    }   
    
    
    @Override
    public String toString() {
        return "Analista: " + "Numero: " + getNumero() + ", Nombre: " + getNombre() + ", Sueldo: " + getSueldo() + ", SueldoMaximo: " + getSueldoMaximo() + ", Plus Anual: " + PlusAnual + ", Numero departamento: " + nDepar + ", fecha_alta: " + getFecha_alta();
    }
}
