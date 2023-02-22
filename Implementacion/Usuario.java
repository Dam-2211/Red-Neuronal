package red;

import java.awt.Color;
import java.util.ArrayList;
import java.util.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Usuario {
   SQL sq = new SQL();
 
    String password = null;
    String sid = null;
   
    ArrayList<String> entradas = new ArrayList<>();
    
    public boolean validar_usuario(){
        boolean resultado = false;
        char clave;
        for (byte i = 0; i < password.length(); i++) {
            clave = password.charAt(i);
            if(clave >= 48 && clave <= 57 || clave >= 97 && clave <= 122 ||clave !=32){
                
                resultado = true;
            }
        }
        
        return resultado;
    };
    
    public boolean Validar_id(){
        boolean resultado = false;
        char clave;
        for (byte i = 0; i < sid.length(); i++) {
            clave = sid.charAt(i);
            if(clave >= 48 && clave <= 57 || clave >= 97 && clave <= 122 ||clave !=32){
               
                resultado = true;
            }
        }
        return resultado;
    };
    
    public boolean Buscar_id_password(){
        sq.id_password();
       
        boolean resultado = false;
        for(int i =0;i < sq.ids.size();i++){
            if(sq.pas.get(i).equals(password) && sq.ids.get(i).equals(sid)){
                resultado= true;
            }
            
        }
        
        return resultado;
    };
    
    public boolean validar_entradas(){
        boolean resultado = false;
        char clave;
        for (byte i = 0; i < entradas.size(); i++) {
            clave = entradas.get(i).charAt(i);
            if(clave >=48 && clave <= 57){
                resultado = true;
            }
        }
        return resultado;
    };
}
