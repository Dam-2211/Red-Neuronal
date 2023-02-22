package red;

import com.toedter.calendar.JCalendar;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.Date;
import javax.swing.JTextArea;

public class RED {
    public static void main(String[] args) {
    Perceptron per = new Perceptron();
    SQL sql = new SQL();
    Usuario usu = new Usuario();
        
    JFrame ventana = new JFrame("Inicio"); 
    ventana.setSize(500,500); //Establece el tamaño de la ventana
    ventana.setLocationRelativeTo(null); //Localiza la ventana en el centro de la pantalla
    ventana.getContentPane().setBackground(Color.BLUE); //Establece el color de la ventana
    ventana.setLayout(null);

    JButton btn1 = new JButton("Iniciar sesion");
    btn1.setBounds(170, 50, 130 , 30);
        
    JButton btn2 = new JButton("Registrar");
    btn2.setBounds(170, 100, 130 , 30);
        
    JButton sal = new JButton("Salir");
    sal.setBounds(200, 230,70, 20);
    
    JButton btn6 = new JButton("Mostrar");
    btn6.setBounds(150, 200, 200 , 30);

    JButton btn7 = new JButton("Cambiar Fechas");
    btn7.setBounds(150, 150, 200 , 30);
    
    JButton btn8 = new JButton("Mostrar");
    btn8.setBounds(150, 100, 200 , 30);
    
    JButton btn9 = new JButton("Cambiar Modo");
    btn9.setBounds(150, 150, 200 , 30);
    
    JButton btn10 = new JButton("Mostrar");
    btn10.setBounds(150, 130, 200 , 30);
    
    JButton btn11 = new JButton("Cambiar Fecha");
    btn11.setBounds(150, 180, 200 , 30);
    
    JButton btn12 = new JButton("Borrar registros");
    btn12.setBounds(150, 230, 200 , 30);
    
    
    ventana.add(btn1);
    ventana.add(btn2);
    ventana.add(sal);


    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    btn1.addActionListener((ActionEvent e) -> {
            ventana.dispose();
            JFrame v3 = new JFrame("Inicio de sesion"); //Ventana Inicio de sesion
            v3.setSize(500,500);
            v3.setLocationRelativeTo(null);
            v3.getContentPane().setBackground(Color.ORANGE);
            v3.setLayout(null);
            
            JLabel nu = new JLabel("Ingrese nombre de usuario");
            nu.setBounds(170,50, 160, 30);
            
            JTextField id = new JTextField();
            id.setBounds(170,75, 160, 20);
            
            JLabel con = new JLabel("Ingrese contraseña");
            con.setBounds(170,100, 160, 30);
            
            JTextField co = new JTextField();
            co.setBounds(170,125, 160, 20);
            
            JButton reg = new JButton("Iniciar sesion");
            reg.setBounds(180, 200, 130 , 30);
            
            v3.add(nu);
            v3.add(id);
            v3.add(con);
            v3.add(co);
            v3.add(reg);
            
            v3.setVisible(true);
            v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    usu.password = co.getText();
                    usu.sid = id.getText();
                    if(usu.Validar_id() == true && usu.validar_usuario() == true){
                        if(usu.Buscar_id_password()== true){
                            v3.dispose();
                            sql.nom_usuario = usu.sid;
                            JFrame ac = new JFrame("bienvenido"); // VENTANA DE COMIENZO
                            ac.setSize(700,600);
                            ac.setLocationRelativeTo(null);
                            ac.getContentPane().setBackground(Color.GREEN);
                            ac.setLayout(null);
                            
                            JLabel lb = new JLabel("Bienvenido al sistema, precione el boton correspondiente");
                            lb.setBounds(200,30,500,60);
                            
                            JButton btn = new JButton("Muestra de los registros ordenado de may o men");
                            btn.setBounds(200, 100, 400 , 30);
                            
                            JButton btn3 = new JButton("Muestra registros en un rango de fechas");
                            btn3.setBounds(200, 150, 300 , 30);
                            
                            JButton btn4 = new JButton("borra los registros pasado una fecha");
                            btn4.setBounds(200, 200, 350 , 30);
                            
                            JButton btn5 = new JButton("Calcular valor de vivienda");
                            btn5.setBounds(200, 250, 350 , 30);
                            
                            ac.add(lb);
                            ac.add(btn);
                            ac.add(btn3);
                            ac.add(btn4);
                            ac.add(btn5);
                         
                            
                            btn.addActionListener( new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {                    
                                    JFrame geu = new JFrame("Mayor - Menor"); //Ventana de may-men
                                    geu.setSize(500,500);
                                    geu.setLocationRelativeTo(null);
                                    geu.getContentPane().setBackground(Color.GREEN);
                                    geu.setLayout(null);
                                    
                                    JLabel lb1 = new JLabel("Presione 'Mostrar' si desea ver los registros por defecto");
                                    lb1.setBounds(100,10,500,100);
                                    JLabel lb2 = new JLabel("Presione 'Cambiar modo', para modificar la visualizacion");
                                    lb2.setBounds(100,30,500,100);
                                
                                    geu.add(lb1);
                                    geu.add(lb2);
                                    geu.add(btn8);
                                    geu.add(btn9);
                                    
                                    geu.setVisible(true);
                                    geu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                };
                            });
                            
                            btn3.addActionListener( new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {                    
                                    JFrame rf = new JFrame("rango fechas"); 
                                    rf.setSize(500,500);
                                    rf.setLocationRelativeTo(null);
                                    rf.getContentPane().setBackground(Color.GREEN);
                                    rf.setLayout(null);
                                    
                                    JLabel lb1 = new JLabel("Presione 'Mostrar' si desea ver los registros dentro del rango por defecto");
                                    lb1.setBounds(50,10,500,100);
                                    JLabel lb2 = new JLabel("Presione 'Cambiar fechas', para modificar la visualizacion");
                                    lb2.setBounds(100,30,500,100);
                                    
                                    rf.add(lb1);
                                    rf.add(lb2);
                                    rf.add(btn6);
                                    rf.add(btn7);
                                    
                                    rf.setVisible(true);
                                    rf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                };
                            });
                            
                           
                            ac.setVisible(true);
                            ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            
                            btn4.addActionListener( new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {                    
                                    JFrame br = new JFrame("borra registro"); //Ventana de may-men
                                    br.setSize(500,500);
                                    br.setLocationRelativeTo(null);
                                    br.getContentPane().setBackground(Color.GREEN);
                                    br.setLayout(null);
                                    
                                    JLabel lb1 = new JLabel("Presione 'Mostrar' si desea ver los registros luego de ser borrados");
                                    lb1.setBounds(50,10,500,100);
                                    JLabel lb2 = new JLabel("Presione 'Cambiar fecha', para modificar la visualizacion");
                                    lb2.setBounds(100,30,500,100);
                                    JLabel lb3 = new JLabel("Presione 'Borrar registros', para borrar los registros");
                                    lb3.setBounds(100,50,500,100);
                                    

                                    br.add(lb1);
                                    br.add(lb2);
                                    br.add(lb3);
                                    br.add(btn10);
                                    br.add(btn11);
                                    br.add(btn12);
                                    
                                    br.setVisible(true);
                                    br.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                };
                            });
                            
                            btn5.addActionListener( new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {                    
                                    JFrame form = new JFrame("Formulario"); //Ventana de may-men
                                    form.setSize(500,550);
                                    form.setLocationRelativeTo(null);
                                    form.getContentPane().setBackground(Color.GREEN);
                                    form.setLayout(null);
                                    
                                    JLabel bienvenida = new JLabel("Complete el formulario para saber el resultado");
                                    bienvenida.setBounds(100,20,300,40);
                                    
                                    String [] sino = {"1", "2"};
                       
                                    String [] barrios_norte = {"Recoleta","Coghlan","Villa Urquiza","Saavedra","Villa Pueyrredon",
                                                               "Belgrano","Nuñez","Colegiales","Palermo"};

                                    JLabel lbl1 = new JLabel("ingrese el barrio:");
                                    lbl1.setBounds(100,70,130,40);

                                    JComboBox barrios = new JComboBox(barrios_norte);
                                    barrios.setBounds(240, 70,150,30);

                                    JLabel lbl2 = new JLabel("ingrese la cantidad de ambientes: ");
                                    lbl2.setBounds(20,70,300,100);

                                    JTextField variable2 = new JTextField();
                                    variable2.setBounds(240,110,130,20);

                                    JLabel lbl3=new JLabel("ingrese la cantidad de baños:");
                                    lbl3.setBounds(20, 100, 300,100);

                                    JTextField variable3=new JTextField();
                                    variable3.setBounds(240,140,130,20);

                                    JLabel lbl4=new JLabel("Ingrese la superficie Total:");
                                    lbl4.setBounds(20,160,280,40);

                                    JTextField variable4=new JTextField();
                                    variable4.setBounds(240,170,130,20);

                                    JLabel lbl5=new JLabel("Ingrese la superficie Cubierta:");
                                    lbl5.setBounds(20,180,300,60);

                                    JTextField variable5=new JTextField();
                                    variable5.setBounds(240,200,130,20);

                                    JLabel lbl6=new JLabel("1(con amenities), 2(sin amenities):");
                                    lbl6.setBounds(35,210,300,60);    
                                    
                                    JComboBox amenities = new JComboBox(sino);
                                    amenities.setBounds(240, 225,100,30);

                                    JLabel lbl7=new JLabel("1(con cochera), 2(sin cochera):");
                                    lbl7.setBounds(40,240,300,60);

                                    JComboBox cochera = new JComboBox(sino);
                                    cochera.setBounds(240, 260,100,30);

                                    JButton cal = new JButton("Calcular");
                                    cal.setBounds(150, 300, 150 , 20);
                                    
                                    form.add(bienvenida);
                                    form.add(lbl1);
                                    form.add(barrios);
                                    form.add(lbl2);
                                    form.add(variable2);
                                    form.add(lbl3);
                                    form.add(variable3);
                                    form.add(lbl4);
                                    form.add(variable4);
                                    form.add(lbl5);
                                    form.add(variable5);
                                    form.add(lbl6);
                                    form.add(amenities);
                                    form.add(lbl7);
                                    form.add(cochera);
                                    form.add(cal);
                                    
                                    cal.addActionListener( new ActionListener() {
                                        public void actionPerformed(ActionEvent evt) {
                                            String variable1;
                                            if((String) barrios.getSelectedItem() == "Recoleta"){
                                                variable1 = "8";
                                            }
                                            else if((String) barrios.getSelectedItem() == "Coghlan"){
                                                variable1 = "3";
                                            }
                                            else if((String) barrios.getSelectedItem() == "Villa Urquiza"){
                                                variable1 = "5";
                                            }
                                            else if((String) barrios.getSelectedItem() == "Saavedra"){
                                                variable1 = "2"; 
                                            }
                                            else if((String) barrios.getSelectedItem() == "Villa Pueyrredon"){
                                                variable1 = "6";
                                            }
                                            else if((String) barrios.getSelectedItem() == "Belgrano"){
                                                variable1 = "4";
                                            }
                                            else if((String) barrios.getSelectedItem() == "Nuñez"){
                                                variable1 = "9";
                                            }
                                            else if((String) barrios.getSelectedItem() == "Colegiales"){
                                                variable1 = "7";
                                            }
                                            else{
                                                variable1 = "1";
                                            }
                                            sql.identificador = Integer.parseInt(variable1);
                                            sql.nombre = (String) barrios.getSelectedItem();
                                            per.entrada1 = Double.parseDouble(variable1);   
                                            per.entrada2 = Double.parseDouble(variable2.getText());
                                            per.entrada3 = Double.parseDouble(variable3.getText());
                                            per.entrada4 = Double.parseDouble(variable4.getText());
                                            per.entrada5 = Double.parseDouble(variable5.getText());
                                            per.entrada6 = Double.parseDouble((String) amenities.getSelectedItem());
                                            per.entrada7 = Double.parseDouble((String) cochera.getSelectedItem());
                                            
                                            JOptionPane.showMessageDialog(null,"Su valor esta entre: " + per.ingresar_entradas());
                                            String resul = per.ingresar_entradas();
                                            
                                            
                                            sql.ambientes = Integer.parseInt(variable2.getText());
                                            sql.bano = Integer.parseInt(variable3.getText());
                                            sql.sp_total = Integer.parseInt(variable4.getText());
                                            sql.sp_cubierta = Integer.parseInt(variable5.getText());
                                            sql.amenities = amenities.getSelectedIndex();
                                            sql.cochera = cochera.getSelectedIndex();
                                            sql.precio = resul;
                                            
                                            sql.agregar_registro();
                                            
                                            per.entradas.clear();

                                        };
                                    });
                                    
                                    form.setVisible(true);
                                    form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                };
                            });
                        }
                    }
                    if(usu.Buscar_id_password() == false){
                        JOptionPane.showMessageDialog(null,"Ingreso los datos incorrectos"); 
                    }
                    v3.dispose();
                };
            });
        });
        
        btn2.addActionListener((ActionEvent e) -> {
            JFrame v2 = new JFrame("Registro");
            v2.setSize(500,500);
            v2.setLocationRelativeTo(null);
            v2.getContentPane().setBackground(Color.yellow);
            v2.setLayout(null);

            JLabel lbl1 = new JLabel("Nickname");
            lbl1.setBounds(200,70,180,40);
            
            JTextField contra=new JTextField();
            contra.setBounds(170,100,130,20);
            
            JLabel lbl2=new JLabel(" Contraseña:");
            lbl2.setBounds(195,150,180,40);
            
            JTextField contra2=new JTextField();
            contra2.setBounds(170,190,130,20);
            

            JButton reg = new JButton("Registrar");
            reg.setBounds(185, 250, 100 , 20);
            
            v2.add(lbl1);
            v2.add(contra);
            v2.add(lbl2);
            v2.add(contra2);
            v2.add(reg);
            
            v2.setVisible(true);
            v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reg.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    
                    sql.pass = contra.getText();   
                    sql.nom = contra2.getText();
                    String texto;
                    if (sql.entrada_usuario()==true)
                            texto = "se guardo el usuario";
                    else
                        texto="error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    v2.dispose();
                };
            });
            
            
        });
        btn7.addActionListener((ActionEvent e) -> {
            JFrame cam_fech = new JFrame("Cambio de fechas"); // NUEVA VENTANA DE CAMBIO DE FECHAS
            cam_fech.setSize(1000,500);
            cam_fech.setLocationRelativeTo(null);
            cam_fech.getContentPane().setBackground(Color.yellow);
            cam_fech.setLayout(null);
            
            
            
            JLabel fecha1 = new JLabel("Ingrese la fecha de inicio");
            fecha1.setBounds(170,10,180,40);
            
            JCalendar calendario = new JCalendar();
            calendario.setBounds(100,50,300,200);
            
            JLabel fecha2 = new JLabel("Ingrese la fecha de fin");
            fecha2.setBounds(570,10,300,40);
            
            JCalendar calendario2 = new JCalendar();
            calendario2.setBounds(500,50,300,200);
            
            JButton con = new JButton("Continuar");
            con.setBounds(400, 300, 100 , 40);
           
            cam_fech.add(fecha1);
            cam_fech.add(calendario);
            cam_fech.add(calendario2);
            cam_fech.add(fecha2);
            cam_fech.add(con);
            
            cam_fech.setVisible(true);
            cam_fech.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            con.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    Date f1 = calendario.getDate();
                    long f1b = f1.getTime();
                    java.sql.Date d = new java.sql.Date(f1b);
                    sql.fecha1 = d;
                    
                    Date f2 = calendario2.getDate();
                    long f2b = f2.getTime();
                    java.sql.Date a = new java.sql.Date(f2b);
                    sql.fecha2 = a;
                    
                    String texto;
                    
                    if (sql.modificar_param_fecha() == true)
                            texto = "se guardaron los cambios";
                    else
                        texto = "error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    cam_fech.dispose();
                };
            });
        });
        btn6.addActionListener((ActionEvent e) -> {
            JFrame mrf = new JFrame("Muestra en un rango de fechas"); // VENTANA DE RANGO DE FECHAS
            mrf.setSize(1000,600);
            mrf.setLocationRelativeTo(null);
            mrf.getContentPane().setBackground(Color.PINK);
            
            JTextArea areatexto = new JTextArea();
            areatexto.setBounds(10,10,10,10);
            
            sql.leer_rang_fechas();
            
            String resultado = "";
            
            for(int i = 0; i < sql.resultado.size(); i++ ){
                resultado += sql.resultado.get(i) + "\n";
            }
            areatexto.setText(resultado);
            areatexto.setEditable(false);
            mrf.add(areatexto);
            
            mrf.setVisible(true);
            mrf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
        
        btn8.addActionListener((ActionEvent e) -> {
            JFrame mrf = new JFrame("Muestra Mayor - Menor"); // VENTANA DE Mayor - Menor
            mrf.setSize(500,500);
            mrf.setLocationRelativeTo(null);
            mrf.getContentPane().setBackground(Color.PINK);
            
            JTextArea areatexto = new JTextArea();
            areatexto.setBounds(10,10,10,10);
            
            sql.leer_may_men();
            
            String resultado = "";
            
            for(int i = 0; i < sql.resultado.size(); i++ ){
                resultado += sql.resultado.get(i) + "\n";
            }
            areatexto.setText(resultado);
            areatexto.setEditable(false);
            mrf.add(areatexto);
            
            mrf.setVisible(true);
            mrf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);            
        });
        
        btn9.addActionListener((ActionEvent e) -> {
            JFrame cam_fech = new JFrame("Cambio de asc o desc"); // NUEVA VENTANA DE CAMBIO DE FECHAS
            cam_fech.setSize(500,500);
            cam_fech.setLocationRelativeTo(null);
            cam_fech.getContentPane().setBackground(Color.yellow);
            cam_fech.setLayout(null);
            
            String [] sino = {"1", "2"};
                        
            JLabel desc = new JLabel("Ingrese 1 si desea de forma descendente");
            desc.setBounds(120,100, 300, 30);
            JLabel asc = new JLabel("Ingrese 2 si desea de forma ascendente");
            asc.setBounds(120,130, 300, 30);
            
            JComboBox ascdesc = new JComboBox(sino);
            ascdesc.setBounds(170, 160,100,30);
            
            
            JButton con = new JButton("Continuar");
            con.setBounds(170, 230, 100 , 40);
           
            cam_fech.add(desc);
            cam_fech.add(asc);
            cam_fech.add(ascdesc);
            cam_fech.add(con);
            
            cam_fech.setVisible(true);
            cam_fech.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            con.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sql.desc_asc = (String) ascdesc.getSelectedItem();
                    
                    String texto;
                    
                    if (sql.modificar_param_desc_asc() == true)
                            texto = "se guardaron los cambios";
                    else
                        texto = "error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    cam_fech.dispose();
                };
            });
        });
        
        btn10.addActionListener((ActionEvent e) -> {
            JFrame mrf = new JFrame("Muestra datos que quedan");
            mrf.setSize(1000,700);
            mrf.setLocationRelativeTo(null);
            mrf.getContentPane().setBackground(Color.PINK);
  
            JTextArea areatexto = new JTextArea();
            areatexto.setBounds(10,10,10,10);
            
            sql.leer_br();
            
            String resultado = "";
            
            for(int i = 0; i < sql.resultado.size(); i++ ){
                resultado += sql.resultado.get(i) + "\n";
            }
            areatexto.setText(resultado);
            areatexto.setEditable(false);
            mrf.add(areatexto);
            
            mrf.setVisible(true);
            mrf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
        
         btn11.addActionListener((ActionEvent e) -> {
            JFrame cam_fech = new JFrame("Cambio de fecha"); // NUEVA VENTANA DE CAMBIO DE FECHAS
            cam_fech.setSize(500,500);
            cam_fech.setLocationRelativeTo(null);
            cam_fech.getContentPane().setBackground(Color.yellow);
            cam_fech.setLayout(null);
            
            JLabel fecha1 = new JLabel("Ingrese la fecha");
            fecha1.setBounds(190,30, 160, 30);
            
            JCalendar calendario = new JCalendar();
            calendario.setBounds(90,80,300,200);
            
            JButton con = new JButton("Continuar");
            con.setBounds(190, 300, 100 , 40);
           
            cam_fech.add(fecha1);
            cam_fech.add(calendario);
            cam_fech.add(con);
            
            cam_fech.setVisible(true);
            cam_fech.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            con.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {    
                    Date f1 = calendario.getDate();
                    long f1b = f1.getTime();
                    java.sql.Date d = new java.sql.Date(f1b);
                    sql.fecha_br = d;
                      
                    String texto;
                    
                    if (sql.modificar_param_br() == true)
                            texto = "se guardaron los cambios";
                    else
                        texto = "error";
                    JOptionPane.showMessageDialog(null,texto);                    
                    sql.agregar_registro();
                    
                    cam_fech.dispose();
                };
            });
        });
        btn12.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                    
                    String texto;
           
                    if (sql.datos_br() == true)
                            texto = "Los datos han sido borrado";
                    else
                        texto = "error";
                    JOptionPane.showMessageDialog(null,texto);        
                };
            });
        sal.addActionListener((ActionEvent e) -> {
            ventana.dispose();

        });
    }
}