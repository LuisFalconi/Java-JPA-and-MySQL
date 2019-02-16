
package test;

import controladores.ProductoJpaController;
import entidades.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {

    
    public static void main(String[] args) {
        
        System.out.println("HOLA MUNDO!!");  

        test t = new test();
        
        t.InsertarDatos("uvas", 0.25, 20);
        t.EliminarDatos(2);
        t.Actualizar(1, "pan", 0.12, 15);
        t.EliminarDatos(2);
        
    }
    public void InsertarDatos(String nombre, Double precio, int unidades){
        
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("practicadb");
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        Producto p = new Producto();  
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setUnidades(unidades);
        
        try{
            pjc.create(p);
        }catch(Exception ex){
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void EliminarDatos(int id){
        
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("practicadb");
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        Producto p = new Producto();  
        
        
        try{
            pjc.destroy(id);
        }catch(Exception ex){
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
    public void Actualizar(int id, String nombre, double precio, int unidades){
        
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("practicadb");
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        Producto p = new Producto(); 
        p.setCodigo(id);
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setUnidades(unidades);
        
        
        try{
            pjc.edit(p);
        }catch(Exception ex){
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
    
    
    
}
