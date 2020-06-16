/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Livre;
import com.mycompany.myapp.entities.ReservationLivre;
import com.mycompany.myapp.service.LivreService;
import com.mycompany.myapp.service.ReservationService;
import java.util.ArrayList;

/**
 *
 * @author Smirani
 */
public class ListRes {
    Livre r = new Livre();
    TextArea tn;
    TextArea ts;
    TextArea tt;
    Form f = new Form("Liste des Livres");
    //SpanLabel lb = new SpanLabel("Liste :  ");
    Resources theme;
    

    public ListRes() {
     /*   
        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        setToolbar(tb);
        // theme = UIManager.initFirstTheme("/theme");
        Button menuButton = new Button();
        setupSideMenu(MSUIKit.theme);
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Container titleComponent = BorderLayout.north(BorderLayout.west(menuButton));
        titleComponent.setUIID("BottomPaddingContainer");
        tb.setTitleComponent(titleComponent);
         
       */
     
     theme = UIManager.initFirstTheme("/theme");
        //f.add(lb);
        Button up = new Button();
        int height = Display.getInstance().convertToPixels(65f);
        int width = Display.getInstance().convertToPixels(70f);
        LivreService ser = new LivreService();
        ArrayList<Livre> l = ser.AfficheLivre();
        System.out.println("Liste Livre"+l);

        ReservationService reserv = new ReservationService();
        ArrayList<ReservationLivre> res = reserv.getAll();
        System.out.println("Liste reservation "+res);

        for (int i = 0; i < l.size(); i++) {
            for(int j = 0; j<res.size(); j++){
                System.out.println("id : " +res.get(j).getId_eleve());
                if(l.get(i).getId()==res.get(j).getId_livre() && res.get(j).getId_eleve()==2){
            
            Label restaur = new Label("Restaurant" + l.get(i).toString());
            System.out.println("llllllllllllllll" + l);

            r = l.get(i);

            Container c = new Container(BoxLayout.y());

            //c.getStyle().setBorder(Border.createLineBorder(1));
            
            ImageViewer image = new ImageViewer();
            EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("biblio.jpg"), false);
            image.setImage(URLImage.createToStorage(placeholder, "http://localhost/Pi-final/web/images/" +r.getImage() ,"http://localhost/Pi-final/web/images/" +r.getImage()).scaled(height, width));
            System.out.println("http://localhost/Pi-final/web/images/" +r.getImage());
            
            
            Container c1 = new Container(BoxLayout.x());
            TextArea t1 = new TextArea("Nom");
            Label l1 = new Label(r.getNom());
            t1.setUIID("TextAreaBlack");
            c1.add(t1);
            c1.add(l1);

            Container c2 = new Container(BoxLayout.x());
            TextArea t2 = new TextArea("Auteur");
            Label l2 = new Label(r.getAuteur());
            t2.setUIID("TextAreaBlack");
            c2.add(t2);
            c2.add(l2);

            Container c3 = new Container(BoxLayout.x());
            TextArea t3 = new TextArea("Description");
            Label l3 = new Label(" " + r.getDescription());
            t3.setUIID("TextAreaBlack");
            c3.add(t3);
            c3.add(l3);

            c.add(image);                    
            c.add(c1);
            c.add(c2);
            c.add(c3);
            
            f.add(c);    

            f.show();
        }}
    }
        
    }
    
        public URLImage photo(int w, int h, String pa) {
        URLImage photo2 = URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(w, h, 0xfff00000), true), pa,
                "http://localhost/Pi_final/web/images/" + pa
        );
        photo2.fetch();
        return photo2;
    }
    
    
}
