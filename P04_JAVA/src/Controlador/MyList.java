package Controlador;

import Modelo.Analista;
import Modelo.Empleado;
import Modelo.Programador;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class MyList <E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private Node<E> ActNode;
    static private int contador = 0;
    
    public MyList(){
        this.firstNode = null;
        this.lastNode = null;
    }
    
    
    public void mostrar100(boolean x){
        
        Node<E> aux = firstNode;
        
        if(x){
            for(int i = 0; i < 100; i++){
                System.out.println(aux.getMain());
                aux = aux.getNextNode();
            }
        }
        else{
            for(int i = 0; i < contador; i++){
                System.out.println(aux.getMain());
                aux = aux.getNextNode();
            }
        }
    }
    
    
    public void showMyList(){
        Node<E> tem = this.firstNode;
        while (tem != null){
            System.out.println(tem.getMain());
            tem=tem.getNextNode();
        }
    }
    
    
    public void InterCambiar(Node numEmple1, Node numEmple2){
        Node<E> aux1 = numEmple1;
        Node<E> aux2 = numEmple2;
            
        int TemIndice = aux1.getIndice();
        aux1.setIndice(aux2.getIndice());
        aux2.setIndice(TemIndice);
            
        E TemMain = aux1.getMain();
        aux1.setMain(aux2.getMain());
        aux2.setMain(TemMain);
    }
    
    
    public boolean sort(){
        Node<E> tem = this.firstNode;
        Node<E> tem2 = tem.getNextNode();
        
        while(tem != null){
            while(tem2 != null){
                if(tem.getIndice() > tem2.getIndice()){
                    InterCambiar(tem, tem2);
                }
                tem2 = tem2.getNextNode();
            }
            tem = tem.getNextNode();
            tem2 = tem;
        }
        return true;
    }
    
    
    public void jlist(){
        DefaultListModel<Empleado> modelo = new DefaultListModel<>();
        JList<Empleado> lista = new JList<>(modelo);
        JScrollPane ventana = new JScrollPane(lista);
        JFrame nuevaVentana;
        
        Node<E> aux = firstNode;
        while(aux != null){
            modelo.addElement((Empleado) aux.getMain());
            aux =aux.getNextNode();
        }
        
        nuevaVentana = new JFrame();
        nuevaVentana.pack();
        nuevaVentana.add(ventana);
        nuevaVentana.setSize(5000, 500);
        nuevaVentana.setVisible(true);
    }
    
    

    public void Guardarlista(){
            FileOutputStream fichero = null;
        
            try{
                fichero = new FileOutputStream("Datos.txt");
                ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
                Node<E> aux = this.firstNode;
                while(aux != null){
                    tuberia.writeObject(aux.getMain());
                    aux = aux.getNextNode();
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }catch(IOException ex){
                ex.printStackTrace();
            }finally{
                try{
                    fichero.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
    }
    
    
    public boolean existe(int numero){
        Node<E> tem = this.firstNode;
        while (tem != null){
            if(tem.getIndice() == numero){
                return true;
            }
            tem=tem.getNextNode();
        }    
        return false; 
    }
    
    
    public boolean esPrimero(){
        return ActNode.returnNode == firstNode;
    }
    
    
    public boolean esUltimo(){
        return ActNode.nextNode == lastNode;
    }
    
    
    public void next(){
        ActNode = ActNode.getNextNode();
        System.out.println(ActNode.getMain().toString());
    }
       
    
    public void retur(){
        ActNode = ActNode.getReturnNode();
        System.out.println(ActNode.getMain().toString());
    }
    
    
    public void modificar(E p){
        ActNode.setMain(p);
        System.out.println(ActNode.getMain().toString());
    }
    
    
    public void elimianar(){
//        contador--;
        if(ActNode == firstNode && ActNode == lastNode){
            System.out.println("NO se puede");
        }
        else if(ActNode == firstNode && !(ActNode == lastNode)){
            firstNode = firstNode.nextNode;
            firstNode.returnNode = null;
            ActNode = ActNode.nextNode;
        }
        else if (ActNode == lastNode && !(ActNode == firstNode)){
            lastNode = ActNode.returnNode;
            lastNode.nextNode = null;
            ActNode = ActNode.returnNode;
        }
        else{
            ActNode.returnNode.nextNode = ActNode.nextNode;
            ActNode.nextNode.returnNode = ActNode.returnNode;
            ActNode = ActNode.returnNode;
        }
        System.out.println("Eliminado");
    }
    
    
    public Node<E> getact(){
        return ActNode;
    }
    
    public void setact(Node<E> aux){
        ActNode = aux;
    }
    
    public Node<E> getFirst(){
        return firstNode;
    }
    
    public Node<E> getLast(){
        return lastNode;
    }
    
    public int getContador(){
        return contador;
    }
    
    
    public void add(E p){
        contador++;
        Node<E> newNode = new Node(p);
        if(this.firstNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.ActNode = newNode;
        }
        else{
            newNode.returnNode = lastNode; 
            lastNode.nextNode = newNode;
            this.lastNode = newNode;
        }
        
    }

    private static class Jlist<T> {

        public Jlist() {
        }
    }

// Inner class

    public class Node<E>{
        private Node<E> nextNode;
        private Node<E> returnNode;
        E main;
        int Indice;
        
        public Node(E p){
            this.nextNode = null;
            this.returnNode = null;
            this.main = p;
            Empleado aux = (Empleado) p;
            Indice = aux.getNumero();
        }
        
        public int getIndice(){
            return this.Indice;
        }
        
        public void setIndice(int Ind){
            this.Indice = Ind;
        }
        
        public Node<E> getNextNode() {
            return this.nextNode;
        }
        
        public Node<E> getReturnNode() {
            return this.returnNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
        
        public void setReturnNode(Node<E> nextNode) {
            this.returnNode = nextNode;
        }

        public E getMain() {
            return main;
        }

        public void setMain(E p) {
            this.main = p;
        }
    }
}