/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import tztbackoffice.Models.KoerierModel;

/**
 *
 * @author Andy
 */
public class KoerierDetailsScreen extends JDialog implements ActionListener{
    
    private KoerierModel selectedKoerier;
    
    public KoerierDetailsScreen(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public void showAndChangeSelectedKoerier(KoerierModel newSelectedKoerier){
        selectedKoerier = newSelectedKoerier;
        System.out.println(selectedKoerier.getStatus());
        setVisible(true);
    }
}
