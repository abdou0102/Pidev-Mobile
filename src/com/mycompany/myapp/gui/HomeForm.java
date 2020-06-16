/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{

    Resources theme;
    
    public HomeForm() {
        theme = UIManager.initFirstTheme("/theme");
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        //new Label("Recommendation", "Title")
                )
        );
        Form f = new Form("Acceuil", BoxLayout.y());
        //current=this;
        
        
        //f.add(new Label("Choose an option"));
        Button btnres = new Button("List reservation");
        Button btnListeLivre = new Button("List Livre");
        f.add(btnListeLivre);
        btnres.addActionListener(e-> new ListRes());
        btnListeLivre.addActionListener(e-> new ListeLivre());
        f.add(btnres);
        
        f.show();
        
       
    }
    
    
}
