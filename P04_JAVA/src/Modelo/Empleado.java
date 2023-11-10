package Modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Empleado implements ComprobarFechas, Serializable{
    
    //decalraciones de variables de la clase Empleado
    private int Numero;
    private transient String Nombre;
    private float Sueldo;
    private float SueldoMaximo;
    Calendar fecha_alta; 
    String Tipo;
    
    //declaraciones del los Contructores
    public Empleado(int Numero, String Nombre, float Sueldo, float SueldoMaximo){
        this.Numero = Numero;
        this.Nombre = Nombre;
        this.Sueldo = Sueldo;
        this.SueldoMaximo = SueldoMaximo;
        
        fecha_alta = new GregorianCalendar();
    }
    
    
    //decalraciones de los Setters
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setSueldo(float Sueldo) throws SaldoEx {
        if(Sueldo > this.getSueldoMaximo()){
            throw new SaldoEx("El sueldo supera al sueldo maximo permitido");
        }
        else{
            this.Sueldo = Sueldo;
        }
    }

    public void setSueldoMaximo(float SueldoMaximo) throws SaldoEx {
        if(this.getSueldo() > this.getSueldoMaximo()){
            throw new SaldoEx("El sueldo supera al sueldo maximo permitido");
        }
        else{
             this.SueldoMaximo = SueldoMaximo;
        }
       
    }

    public void setFecha_alta(GregorianCalendar fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
      
    
    //declaraciones de los Getters

    public int getNumero() {
        return Numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public float getSueldo() {
        return Sueldo;
    }

    public float getSueldoMaximo() {
        return SueldoMaximo;
    }

    public Calendar getFecha_alta() {
        return fecha_alta;
    }
    
    public String getTipo() {
        return Tipo;
    }
    
    
    //Metodo ToString()
    @Override
    public String toString() {
        return "Empleado{" + "Numero=" + Numero + ", Nombre=" + Nombre + ", Sueldo=" + Sueldo + ", SueldoMaximo=" + SueldoMaximo + ", fecha_alta=" + fecha_alta + '}';
    }

    
}
