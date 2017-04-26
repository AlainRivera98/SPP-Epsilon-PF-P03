//Proyecto Final 
//Problema 3
//Equipo Epsilon
//Nombres, matrículas y carreras de integrantes de equipo:
//Roberto Alain Rivera Bravo | A01411516 | IMT11
//Fabricio Arturo Balboa Cavazos | A01411541 | IMT11
//Andrés de Jesús Martínez Castillo | A01411447 | IMT11
//Jessica Delgado González | A01411536 | IMT11
//Alfredo Alejandro Lárraga Sosa | A01410278 | LMC

/*3.Desarrolla un programa que muestre un Menú con 3 opciones: 
Opción 1: Calcular Máximo Común Divisor, 
Opción 2: Calcular Mínimo Común Múltiplo, 
Opción 3: Salir. De acuerdo con la opción seleccionada por el usuario el 
programa deberá solicitar dos número, realizar el cálculo correcto y mostrar el resultado. */

package spp.epsilon.pf.p03;

import javax.swing.JOptionPane;

public class SPPEpsilonPFP03 {

    public static void main(String[] args) {
        boolean flag;
        
        do{        
            menu(); //manda a método menú
            flag = salida(); //recibe el valor booleano
        } while (flag==false);
        
    }
    
    //método menú: muestra las opciones en pantalla
    public static void menu(){
        int option;
        boolean flag;   
        
        JOptionPane.showMessageDialog(null, "------------------------------------------------------\n"
        +   " Calculadora  de MCD y mcm\n"
        +   "------------------------------------------------------\n" , "Inicio", JOptionPane.PLAIN_MESSAGE);
        
        //Se crea método object para mostrar las opciones en el método showOptionDialog
        Object[] entradas = {
            "1. Calcular Máximo Común Divisor (MCD)",
            "2. Calcular Mínimo Común Múltiplo (mcm)",
            "3. Salir"
        };
        
        do {
            //Se elige una opción de operacion según lo elegido
  
            option = JOptionPane.showOptionDialog(null, "Seleccione una opción ", "Menú de opciones ", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, entradas, null);
            
            //estructura if/else para elegir opciones
            if(option == 0  || option == 1){ //se ingresa al cálculo de opciones
                JOptionPane.showMessageDialog(null, "La opción seleccionada fue "+entradas[option], 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
                operaciones(option);
                flag = true;
            } else if(option == 2){ //se solicita salir del programa
                JOptionPane.showMessageDialog(null, "La opción seleccionada fue "+entradas[option], 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
                flag = true;
            } else { //se pide introducir una opción válida
                JOptionPane.showMessageDialog(null, "Introduzca una opción válida ", 
                "ERROR", JOptionPane.ERROR_MESSAGE);
                flag=false;   
            }
   
        } while (flag==false); 
        
    }
    
    //Método operaciones: realiza las operaciones de MCD o mcm
    public static void operaciones(int option){
        int a, b, c, d, r;
        String message;
        
        //se piden los números sobre los que se calculará el MCD o el mcm
        a = solicitarDatos("Primer número");
        b = solicitarDatos("Segundo número");
        
        c = a;
        d = b;
        
        //Estructura que permite cambiar el orden  de los números para ejecutar el algoritmo siguiente
        if(a < b){
            a = d;
            b = c;
        }
        
        //ciclo que determina el Máximo Común Divisor de 2 números usando el algoritmo de Euclides
        do{
            r = a%b;
            a = b; //"a" termina quedando con el MCD 
            b = r;  
        } while (r!=0);
        
        if(option == 0){
            message = "Máximo Común Divisor (MCD)";
                       
        } else {
            message = "Mínimo Común Múltiplo (mcm)";
            //Se obtiene el mcm a partir de el MCD, ya que se usa la relación entre mcm y MCD para dos números a,b:
            //a*b = mcm[a,b] * MCD (a,b)
            a = (c*d)/a;
        }
        
        //Se muestra el resultado de las operaciones
        JOptionPane.showMessageDialog(null, "El "+message+" de los números "+c+" y "+d+" es:\n"+a, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    //Método solicitar datos: permite verificar que los datos sean correctos y los captura
    public static int solicitarDatos(String message){
        int x = 0;
        boolean flag;

        do {
            try { //Intenta realizar las instrucciones
                x = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduzca el "+message, message,JOptionPane.QUESTION_MESSAGE));
                flag = true;
            } catch (Exception ex) { //Evita que el programa falle en caso de error y muestra el error
                JOptionPane.showMessageDialog(null, "Introduzca un número entero válido "+ex, 
                "ERROR", JOptionPane.ERROR_MESSAGE);
                flag = false;
            }
     
        } while (flag == false);
        
        return x; //regresa el valor verificado
    }
 
    //Método salida: da opción de terminar o reiniciar los cálculos  
    public static boolean salida(){
        int option;
        boolean flag;
        
        option = JOptionPane.showConfirmDialog(null, "¿Desea salir del programa?", 
        "Menú de salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //verifica si el String es igual a "1"
        if(option == 1){
             //Se manda el valor booleano para volver a ejecutar el programa
            flag=false;
        } else{
            //Se manda el valor booleano para terminar el programa
           flag=true; 
        }
        
        return flag;  //Se regresa el valor booleano
    }
    

}
