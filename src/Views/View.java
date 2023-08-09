package Views;

import javax.swing.*;

public class View {

    public View(){
    }

    public int menu(String[] options){
        return JOptionPane.showOptionDialog(null,"Seleccione una opcion","Menu",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
    }

    public void message(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public String input(String message) {
        return JOptionPane.showInputDialog(null,message);
    }
}
