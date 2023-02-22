package red;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class SQL {
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> pas = new ArrayList<>();
    ArrayList<String> resultado = new ArrayList<>();
    
    int id_historial;
    Date fecha;
    String nom_usuario;
    int ambientes;
    int bano;
    int sp_total;
    int sp_cubierta;
    int amenities;
    int cochera;
    String precio;
    
    int id_barrio;
    int identificador;
    String nombre;
    
    int cont;
    int cont2;
    
    String pass = null;
    String nom = null;
    
    String desc_asc;
    Date fecha1;
    Date fecha2;
    Date fecha_br;
       
    int val;
    
    int vales;
    int dato;
    
    static String user = "root";
    static String pwd = "12341234";
    static Connection cn = null;
    public static boolean status = false;
    
    public static Connection conexion(){
        status = false;
        String bd = "red_neuronal?autoReconnect=true&useSSL=false";
        String servidor = "localhost:3306";
        String url = "jdbc:mysql://" +servidor +"/" +bd;
        try{
            cn = DriverManager.getConnection(url,user,pwd);
            status = true;
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return cn;
    }
    
    public boolean entrada_usuario(){ 
        try{
            CallableStatement cst = conexion().prepareCall("{call sp_registrar_usuario(?,?) }");

            cst.setString(1,pass);
            cst.setString(2,nom);
            cst.executeUpdate();
            return true;

        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void saber_pk(){
        try{
            String sql = "{call sp_saber_pk}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                cont += 1;
            }

        }
        catch(java.sql.SQLException exep){
           JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saber_pk_barrio(){
        try{
            String sql = "{call sp_saber_pk_barrio}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                cont2 += 1;
            }
        }
        catch(java.sql.SQLException exep){
           JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregar_registro(){
        try{
            saber_pk();
            Date fecha_now = new Date();
            fecha = fecha_now;
            
            java.sql.Date fecha_sql = new java.sql.Date(fecha.getTime());
            
            id_historial = cont + 1;
            
            CallableStatement cst = conexion().prepareCall("{call sp_agregar_registro(?,?,?,?,?,?,?,?,?,?) }");
            cst.setInt(1, id_historial);
            cst.setDate(2,fecha_sql);
            cst.setString(3,nom_usuario);
            cst.setInt(4,ambientes);
            cst.setInt(5,bano);
            cst.setInt(6,sp_total);
            cst.setInt(7,sp_cubierta);
            cst.setInt(8,amenities);
            cst.setInt(9,cochera);
            cst.setString(10,precio);
            cst.executeUpdate();
            agregar_registro_barrio();
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void agregar_registro_barrio(){
        try{
            saber_pk_barrio();

            id_barrio = cont2 + 1;
            
            CallableStatement cst = conexion().prepareCall("{call sp_agregar_barrio(?,?,?,?) }");
            cst.setInt(1, id_barrio);
            cst.setInt(2,id_historial);
            cst.setInt(3,identificador);
            cst.setString(4,nombre);

            cst.executeUpdate();
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public  void id_password(){
        try{
            String sql = "{call sp_ver_usuarios}";
            
            CallableStatement cst = conexion().prepareCall(sql);
            
            ResultSet consulta = cst.executeQuery(sql);
            
            while(consulta.next()){
                String idd = consulta.getString("nickname");
                String par = consulta.getString("contraseña");
                ids.add(idd);
                pas.add(par);
            }
                     
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public boolean modificar_param_fecha(){
        try{
            java.sql.Date fecha_sql = new java.sql.Date(fecha1.getTime());
            java.sql.Date fecha2_sql = new java.sql.Date(fecha2.getTime());
            
            CallableStatement cst = conexion().prepareCall("{call sp_modif_fech(?,?)}");
            
            cst.setDate(1, fecha_sql);
            cst.setDate(2, fecha2_sql);
            cst.executeUpdate();
            return true;
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
    
    public boolean modificar_param_desc_asc(){
        try{
            CallableStatement cst = conexion().prepareCall("{call sp_modif_fech_asc(?)}");
            
            cst.setString(1, desc_asc);
            cst.executeUpdate();
            return true;
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
    
    public boolean modificar_param_br(){
        try{
            java.sql.Date fecha_sql = new java.sql.Date(fecha_br.getTime());
            CallableStatement cst = conexion().prepareCall("{call sp_modif_fech_br(?)}");
            
            cst.setDate(1, fecha_sql);
            cst.executeUpdate();
            return true;
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
    
    private void borrar_array(){
        while(resultado.size() > 0){
            for(int i = 0; i < resultado.size(); i++){
                resultado.remove(resultado.get(i));
            }
        }
        
    }
    
    public  void leer_rang_fechas(){
        try{
            borrar_array();
            
            String sql = "{call sp_order_fecha}";
            
            CallableStatement cst = conexion().prepareCall(sql);
           
            ResultSet consulta = cst.executeQuery();
            while(consulta.next()){
                String em10 = consulta.getString("fecha");
                String em9 = consulta.getString("nom_usuario");
                int em8 = consulta.getInt("ambientes");
                int em7 = consulta.getInt("baño");
                int em6 = consulta.getInt("sp_total");
                int em5 = consulta.getInt("sp_cubierta");
                int em4 = consulta.getInt("amenities");
                int em3 = consulta.getInt("cochera");
                int em2 = consulta.getInt("precio");
                resultado.add("Fecha:"+em10+" || "+"-Nombre de Usuario:"+em9+" || "+"-Ambientes:"+em8+" || "+"-Baño:"+em7+" || "+
                              "-Sp_total:"+em6+" || "+"-Sp_cubierta:"+em5+" || "+"-Amenities:"+em4+" || "+ "-Cochera:"+em3
                              +" || "+"-Precio: " + em2);
            }
            consulta.close();
            
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  void leer_may_men(){
        try{
            borrar_array();
            String sql = "{call sp_menor_mayor}";
            
            CallableStatement cst = conexion().prepareCall(sql);
           
            ResultSet consulta = cst.executeQuery();
            while(consulta.next()){
                String em10 = consulta.getString("fecha");
                String em9 = consulta.getString("nom_usuario");
                int em2 = consulta.getInt("precio");
                resultado.add("Fecha:" + em10 + "        -Nombre del Usuario:" + em9 + "        -Precio:" + em2);
            }
            consulta.close();
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  void leer_br(){
        try{
            borrar_array();
            String sql = "{call sp_ver_historial_br}";
            
            CallableStatement cst = conexion().prepareCall(sql);
           
            ResultSet consulta = cst.executeQuery();
            while(consulta.next()){
                String em10 = consulta.getString("fecha");
                String em9 = consulta.getString("nom_usuario");
                int em8 = consulta.getInt("ambientes");
                int em7 = consulta.getInt("baño");
                int em6 = consulta.getInt("sp_total");
                int em5 = consulta.getInt("sp_cubierta");
                int em4 = consulta.getInt("amenities");
                int em3 = consulta.getInt("cochera");
                int em2 = consulta.getInt("precio");
                resultado.add("Fecha:"+em10+" || "+"-Nombre de Usuario:"+em9+" || "+"-Ambientes:"+em8+" || "+"-Baño:"+em7+" || "+
                              "-Sp_total:"+em6+" || "+"-Sp_cubierta:"+em5+" || "+"-Amenities:"+em4+" || "+ "-Cochera:"+em3
                              +" || "+"-Precio: " + em2);
            }
            consulta.close();
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean datos_br(){
        try{
            String sql = "{call sp_borrar_reg}";
            
            CallableStatement cst = conexion().prepareCall(sql);
           
            ResultSet consulta = cst.executeQuery();
            
            cst.executeUpdate();
            
            return true;
            
        }
        catch(java.sql.SQLException exep){
            JOptionPane.showMessageDialog(null, "Error" + exep.getMessage(),
            "Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}