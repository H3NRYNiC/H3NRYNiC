
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; 
import javax.swing.JOptionPane;
/*
Desarrollo:
Adhair Melchor Osorio
Luis Enrique Nicolas Bonifacio
Hugo Alberto Caracas
*/
public class Programa_Analizador {

    public static void main(String[] args) { 

        String[] reservadas = {"abstract", "boolean", "break", "byte", "byvalue", "case", "cast", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", //16
            "extends", "final", "finally", "float", "for", "future", "generic", "goto", "if", "implemets", "import", "inner", "instanceof", "int", "interface", "long", "native", "new", "null", "operator", "outer", //21
            "package", "private", "protected", "public", "rest", "return", "short", "static", "super", "switch", "synchronized", "this", "threadsafe", "throw", "transient", "try", "var", "void", "while"}; //19

        boolean opc = false;
        while (!opc) {
            String menu = JOptionPane.showInputDialog("----------Seleccione----------\n"
                    + "1 - Identificar elementos\n"
                    + "2 - Identificar tipos de entrada\n"
                    + "3 - Separar instruccion en tokens\n"
                    + "4 - Separar instruccion con numero de posicion\n"
                    + "5 - Salir");

            int mnu = Integer.parseInt(menu);

            switch (mnu) {
                case 1:
                    System.out.println("-----------------Fase Uno-----------------");
                    String cadenaC1 = JOptionPane.showInputDialog("Elemento: ");
                    if (cadenaC1.matches("(([0-9])*|\".*\")")) {
                        JOptionPane.showMessageDialog(null, "PARA VALIDAR DATOS\nDE ENTRADA ELIJA LA 2DA OPCION!!!");
                    } else {

                        int n = 0;
                        boolean encontrado = false;
                        while (n < 56 && encontrado == false) {
                            if (reservadas[n].equals(cadenaC1)) {
                                encontrado = true;
                            }
                            n++;
                        }
                        if (encontrado == true) {
                            System.out.println("Es una Palabra Reservada, ubicada en la posicion " + (n));
                        } else {
                            if (cadenaC1.matches("(true|false)$")) {
                                System.out.println("Cadena valida de tipo Booleana posicion 62");
                            } else if (cadenaC1.matches("([0-9]){1,10}")) {
                                System.out.println("Cadena de tipo Entero (Literal) posicion 57");
                            } else if (cadenaC1.matches("(([0-9]){1,19})L")) {
                                System.out.println("Cadena de tipo Long (Literal) posicion 59");
                            } else if ((cadenaC1.matches("(([0-9])*\\.([0-9])*)f"))) {
                                System.out.println("Cadena de tipo Float(Literal) posicion 61");
                            } else if ((cadenaC1.matches("(([0-9])*\\.([0-9])*)d?"))) {
                                System.out.println("Cadena de tipo Double(Literal)posicion 60");
                            } else if ((cadenaC1.matches("^([a-zA-Z_$][a-zA-Z\\d_$]*)$"))) {
                                System.out.println("Es un Identificador de la posicion 57");
                            } else if ((cadenaC1.matches("['](.)[']"))) {
                                System.out.println("Cadena de tipo Char (Literal)Posicion 63");
                            } else if ((cadenaC1.matches("\".*\""))) {
                                System.out.println("Cadena de tipo String (Literal)");
                            } else if ((encontrado == false)) {

                                String[] operadores = {"++", "--", "!", "*", "/", "%", "+", "-", "<", ">", "<=", ">=", "==", "!=", "&&", "||", "?", "="};
                                int i2 = 0;
                                boolean encontrado2 = false;
                                while (i2 < 18 && encontrado2 == false) {
                                    if (operadores[i2].equals(cadenaC1)) {
                                        encontrado2 = true;
                                    }
                                    i2++;
                                }
                                if (encontrado2 == true) {
                                    System.out.println("Es un Operador, ubicada en la posicion " + (i2 + 64));
                                } else if (encontrado2 == false) {

                                    String[] Delimitadores = {"(", ")", "{", "}", "[", "]", ";", ",", "."};
                                    int i3 = 0;
                                    boolean encontrado3 = false;
                                    while (i3 < 9 && encontrado3 == false) {
                                        if (Delimitadores[i3].equals(cadenaC1)) {
                                            encontrado3 = true;
                                        }
                                        i3++;
                                    }
                                    if (encontrado3 == true) {
                                        System.out.println("Es un Delimitador, ubicada en la posicion " + (i3 + 84));
                                    } else if (encontrado3 == false) {

                                        String[] Comentarios = {"//", "/*", "/**"};
                                        int i4 = 0;
                                        boolean encontrado4 = false;
                                        while (i4 < 3 && encontrado4 == false) {
                                            if (Comentarios[i4].equals(cadenaC1)) {
                                                encontrado4 = true;
                                            }
                                            i4++;
                                        }
                                        if (encontrado4 == true) {
                                            System.out.println("Es un comentario, ubicada en la posicion " + (i4 + 93));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("-----------------Fase Dos-----------------");
                    String cadenaC2 = JOptionPane.showInputDialog("Elemento: ");
                    int i = 0;
                    boolean encontrado = false;
                    while (i < 56 && encontrado == false) {
                        if (reservadas[i].equals(cadenaC2)) {
                            encontrado = true;
                        }
                        i++;
                    }
                    if (encontrado == true) {
                        System.out.println("Es una Palabra Reservada, ubicada en la posicion " + (i));
                    } else {
                        if (cadenaC2.matches("(true|false)$")) {
                            System.out.println("Cadena valida de tipo Booleana posicion 62: " + cadenaC2);
                        } else if (cadenaC2.matches("([0-9]){1,10}")) {
                            System.out.println("Cadena de tipo Entero (Literal) posicion 57: " + cadenaC2);
                        } else if (cadenaC2.matches("(([0-9]){1,19})L")) {
                            System.out.println("Cadena de tipo Long (Literal) posicion 59: " + cadenaC2);
                        } else if ((cadenaC2.matches("(([0-9])*\\.([0-9])*)f"))) {
                            System.out.println("Cadena de tipo Float(Literal) posicion 61: " + cadenaC2);
                        } else if ((cadenaC2.matches("(([0-9])*\\.([0-9])*)d?"))) {
                            System.out.println("Cadena de tipo Double(Literal)posicion 60: " + cadenaC2);
                        } else if ((cadenaC2.matches("^([a-zA-Z_$][a-zA-Z\\d_$]*)$"))) {
                            System.out.println("Es un Identificador de la posicion 57: " + cadenaC2);
                        } else if ((cadenaC2.matches("['](.)[']"))) {
                            System.out.println("Cadena de tipo Char (Literal)Posicion 63: " + cadenaC2);
                        } else if ((cadenaC2.matches("\".*\""))) {
                            System.out.println("Cadena de tipo String (Literal): " + cadenaC2);
                        } else if ((encontrado == false)) {

                            String[] operadores = {"++", "--", "!", "*", "/", "%", "+", "-", "<", ">", "<=", ">=", "==", "!=", "&&", "||", "?", "="};
                            int i2 = 0;
                            boolean encontrado2 = false;
                            while (i2 < 18 && encontrado2 == false) {
                                if (operadores[i2].equals(cadenaC2)) {
                                    encontrado2 = true;
                                }
                                i2++;
                            }
                            if (encontrado2 == true) {
                                System.out.println("Es un Operador, ubicada en la posicion " + (i2 + 64));
                            } else if (encontrado2 == false) {

                                String[] Delimitadores = {"(", ")", "{", "}", "[", "]", ";", ",", "."};
                                int i3 = 0;
                                boolean encontrado3 = false;
                                while (i3 < 9 && encontrado3 == false) {
                                    if (Delimitadores[i3].equals(cadenaC2)) {
                                        encontrado3 = true;
                                    }
                                    i3++;
                                }
                                if (encontrado3 == true) {
                                    System.out.println("Es un Delimitador, ubicada en la posicion " + (i3 + 84));
                                } else if (encontrado3 == false) {

                                    String[] Comentarios = {"//", "/*", "/**"};
                                    int i4 = 0;
                                    boolean encontrado4 = false;
                                    while (i4 < 3 && encontrado4 == false) {
                                        if (Comentarios[i4].equals(cadenaC2)) {
                                            encontrado4 = true;
                                        }
                                        i4++;
                                    }
                                    if (encontrado4 == true) {
                                        System.out.println("Es un cometario, ubicada en la posicion " + (i4 + 93));
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3: {
                    String[] reservadas1 = {"abstract", "boolean", "break", "byte", "byvalue", "case", "cast", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", //16
                        "extends", "final", "finally", "float", "for", "future", "generic", "goto", "if", "implemets", "import", "inner", "instanceof", "int", "interface", "long", "native", "new", "null", "operator", "outer", //21
                        "package", "private", "protected", "public", "rest", "return", "short", "static", "super", "switch", "synchronized", "this", "threadsafe", "throw", "transient", "try", "var", "void", "while"}; //19

                    String[] reservadas2 = {" abstract ", " boolean ", " break ", " byte ", " byvalue ", " case ", " cast ", " catch ", " char ", " class ", " const ", " continue ", " default ", " do ", " double ", " else ", //16
                        " extends ", " final ", " finally ", " float ", " for ", " future ", " generic ", " goto ", " if ", " implemets ", " import ", " inner ", " instanceof ", "int ", " interface ", " long ", " native ", " new ", " null ", " operator ", " outer ", //21
                        " package ", " private ", " protected ", " public ", " rest ", " return ", " short ", " static ", " super ", " switch ", " synchronized ", " this ", " threadsafe ", " throw ", " transient ", " try ", " var ", " void ", " while "};

                    String[] operadores2 = {" ++ ", " -- ", " ! ", " * ", " / ", " % ", " + ", " - ", " < ", " > ", " <= ", " >= ", " == ", " != ", " && ", " || ", " ? ", " = "};
                    String[] operadores1 = {"++", "--", "!", "*", "/", "%", "+", "-", "<", ">", "<=", ">=", "==", "!=", "&&", "||", "?", "="};

                    String[] Delimitadores1 = {"(", ")", "{", "}", "[", "]", ";", ",", "."};
                    String[] Delimitadores2 = {" ( ", " ) ", " { ", " } ", " [ ", " ] ", " ; ", " , ", " . "};

                    System.out.println("-----------------Fase Tres -----------------");
                    String cadenaC4 = JOptionPane.showInputDialog("Instruccion: ");

                    for (int j = 0; j < reservadas1.length; j++) {

                        cadenaC4 = cadenaC4.replace(reservadas[j], reservadas2[j]);

                    }

                    for (int k = 0; k < operadores1.length; k++) {

                        cadenaC4 = cadenaC4.replace(operadores1[k], operadores2[k]);
                    }

                    for (int l = 0; l < Delimitadores1.length; l++) {

                        cadenaC4 = cadenaC4.replace(Delimitadores1[l], Delimitadores2[l]);
                    }

                    //separadorC4[j].replace(reservadas[j], reservadas2[j]);
                    cadenaC4.trim();
                    String[] separadorC4 = cadenaC4.split("\\s");

                    boolean identificador = false;
                    boolean numero = false;
                    int posicionR = 0;
                    boolean cadena = false;

                    System.out.println("El Token que ingreso fue:");
                    System.out.println("");
                    for (int a = 0; a < separadorC4.length; a++) {
                        System.out.println("Posicion: "+"["+(a+1)+"]"+separadorC4[a]);
                    }
                    System.out.println("");
                    System.out.println("Total Tokens: "+separadorC4.length);
                    System.out.println("--------------------------");

                    for (int b = 0; b < separadorC4.length; b++) {

                        boolean cambiar = false;

                        for (int k = 0; k < reservadas.length; k++) {
                            if (reservadas[k].equals(separadorC4[b])) {
                                separadorC4[b].replace(reservadas[k], reservadas2[k]);
                                System.out.println("");
                                posicionR = k;
                                cambiar = true;

                            }
                        }

                        if (cambiar == true) {

                        } else if (separadorC4[b].matches("(true|false)$")) {

                        } else if (separadorC4[b].matches("([a-zA-Z_$][a-zA-Z\\d_$]*)$")) {

                            identificador = true;
                        } else if (separadorC4[b].matches("([0-9])*")) {
                            numero = true;

                        } else if (separadorC4[b].matches("(([0-9])*)L")) {

                        } else if ((separadorC4[b].matches("(([0-9])*\\.([0-9])*)f"))) {

                        } else if ((separadorC4[b].matches("(([0-9])*\\.([0-9])*)d"))) {

                        } else if (separadorC4[b].matches("['](.)[']")) {

                        } else if (separadorC4[b].matches("\".*\"")) {

                        } else if (identificador == true) {

                            for (int k = 0; k < operadores1.length; k++) {
                                if (operadores1[k].equals(separadorC4[b])) {
                                    separadorC4[b].replace(operadores1[k], operadores2[k]);
                                    cambiar = true;

                                    cadena = true;
                                }
                            }

                        } else {
                            System.out.println("");
                        }

                        for (int k = 0; k < Delimitadores1.length; k++) {
                            if (Delimitadores1[k].equals(separadorC4[b])) {
                                separadorC4[b].replace(Delimitadores1[k], Delimitadores2[k]);

                            }

                        }
                    }
                }
                break;
                case 4:
                    String[] reservadas1 = {"abstract", "boolean", "break", "byte", "byvalue", "case", "cast", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", //16
                        "extends", "final", "finally", "float", "for", "future", "generic", "goto", "if", "implemets", "import", "inner", "instanceof", "int", "interface", "long", "native", "new", "null", "operator", "outer", //21
                        "package", "private", "protected", "public", "rest", "return", "short", "static", "super", "switch", "synchronized", "this", "threadsafe", "throw", "transient", "try", "var", "void", "while"}; //19

                    String[] reservadas2 = {" abstract ", " boolean ", " break ", " byte ", " byvalue ", " case ", " cast ", " catch ", " char ", " class ", " const ", " continue ", " default ", " do ", " double ", " else ", //16
                        " extends ", " final ", " finally ", " float ", " for ", " future ", " generic ", " goto ", " if ", " implemets ", " import ", " inner ", " instanceof ", "int ", " interface ", " long ", " native ", " new ", " null ", " operator ", " outer ", //21
                        " package ", " private ", " protected ", " public ", " rest ", " return ", " short ", " static ", " super ", " switch ", " synchronized ", " this ", " threadsafe ", " throw ", " transient ", " try ", " var ", " void ", " while "};

                    String[] operadores2 = {" ++ ", " -- ", " ! ", " * ", " / ", " % ", " + ", " - ", " < ", " > ", " <= ", " >= ", " == ", " != ", " && ", " || ", " ? ", " = "};
                    String[] operadores1 = {"++", "--", "!", "*", "/", "%", "+", "-", "<", ">", "<=", ">=", "==", "!=", "&&", "||", "?", "="};

                    String[] Delimitadores1 = {"(", ")", "{", "}", "[", "]", ";", ",", "."};
                    String[] Delimitadores2 = {" ( ", " ) ", " { ", " } ", " [ ", " ] ", " ; ", " , ", " . "};

                    System.out.println("-----------------Fase Cuatro-----------------");
                    String cadenaC4 = JOptionPane.showInputDialog("Instruccion: ");

                    for (int j = 0; j < reservadas1.length; j++) {

                        cadenaC4 = cadenaC4.replace(reservadas[j], reservadas2[j]);

                    }

                    for (int k = 0; k < operadores1.length; k++) {

                        cadenaC4 = cadenaC4.replace(operadores1[k], operadores2[k]);
                    }

                    for (int l = 0; l < Delimitadores1.length; l++) {

                        cadenaC4 = cadenaC4.replace(Delimitadores1[l], Delimitadores2[l]);
                    }

                    //separadorC4[j].replace(reservadas[j], reservadas2[j]);
                    cadenaC4.trim();
                    String[] separadorC4 = cadenaC4.split("\\s");

                    boolean identificador = false;
                    boolean numero = false;
                    int posicionR = 0;
                    boolean cadena = false;

                    System.out.println("El Token que ingreso fue:");
                    System.out.println("");
                    for (int a = 0; a < separadorC4.length; a++) {
                        System.out.println(separadorC4[a]);
                    }

                    for (int b = 0; b < separadorC4.length; b++) {

                        boolean cambiar = false;

                        for (int k = 0; k < reservadas.length; k++) {
                            if (reservadas[k].equals(separadorC4[b])) {
                                separadorC4[b].replace(reservadas[k], reservadas2[k]);
                                System.out.println("");
                                posicionR = k;
                                cambiar = true;

                            }
                        }

                        if (cambiar == true) {
                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Palabra Reservada en la posicion : " + (posicionR + 1));
                        } else if (separadorC4[b].matches("(true|false)$")) {
                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Booleana Literal en la posicion : 62");
                        } else if (separadorC4[b].matches("([a-zA-Z_$][a-zA-Z\\d_$]*)$")) {
                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Es Identificador en la posicion : 57");
                            identificador = true;
                        } else if (separadorC4[b].matches("([0-9])*")) {
                            numero = true;
                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Es un numero Entero (Literal)en la posicion : 58");

                        } else if (separadorC4[b].matches("(([0-9])*)L")) {

                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Es un numero Long (Literal) en la posicion : 59 ");

                        } else if ((separadorC4[b].matches("(([0-9])*\\.([0-9])*)f"))) {
                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Cadena de tipo Float (Literal) en la posicion : 61");

                        } else if ((separadorC4[b].matches("(([0-9])*\\.([0-9])*)d"))) {
                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + "Cadena de tipo Double(Literal) en la posicion : 60");

                        } else if (separadorC4[b].matches("['](.)[']")) {

                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Cadena de tipo Char (Literal) en la posicion : 63 ");

                        } else if (separadorC4[b].matches("\".*\"")) {

                            System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Cadena de tipo String (Literal) en la posicion : 64 ");

                        } else if (identificador == true) {

                            for (int k = 0; k < operadores1.length; k++) {
                                if (operadores1[k].equals(separadorC4[b])) {
                                    separadorC4[b].replace(operadores1[k], operadores2[k]);
                                    cambiar = true;
                                    System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Es un Operador en la posicion : " + (k + 65));
                                    cadena = true;
                                }
                            }

                        } else {
                            System.out.println("");
                        }

                        for (int k = 0; k < Delimitadores1.length; k++) {
                            if (Delimitadores1[k].equals(separadorC4[b])) {
                                separadorC4[b].replace(Delimitadores1[k], Delimitadores2[k]);
                                System.out.println("[" + (b + 1) + "] " + separadorC4[b] + " Es un Delimitador en la posicion : " + (k + 83));

                            }

                        }

                    }

                case 5:
                    System.out.println("");
                    System.out.println("-----------------Finalizado-----------------\n");
                    opc = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no encontrada\nintentalo de nuevo");
                    opc = false;
            }
        }
    }
}
