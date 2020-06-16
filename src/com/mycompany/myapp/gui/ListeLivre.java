/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
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

public class ListeLivre extends Form{
    
    
    Livre r = new Livre();
    TextArea tn;
    TextArea ts;
    TextArea tt;
    Form f = new Form("Liste des Livres");
    //SpanLabel lb = new SpanLabel("Liste :  ");
    Resources theme;
    

    public ListeLivre() {
        
        theme = UIManager.initFirstTheme("/theme");
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        //new Label("Recommendation", "Title")
                )
        );
        
        //f.add(lb);
        Button up = new Button();
        int height = Display.getInstance().convertToPixels(50f);
        int width = Display.getInstance().convertToPixels(60f);
        LivreService ser = new LivreService();
        //  lb.setText(ser.rechercheSkill().toString());
        ArrayList<Livre> l = ser.AfficheLivre();
        System.out.println("lllllllll"+l);
        for (int i = 0; i < l.size(); i++) {
            Label restaur = new Label("Restaurant" + l.get(i).toString());
            System.out.println("llllllllllllllll" + l);

            r = l.get(i);

            Container c = new Container(BoxLayout.y());

            c.getStyle().setBorder(Border.createLineBorder(1));
            
            ImageViewer image = new ImageViewer();
            EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("biblio.jpg"), false);
            image.setImage(URLImage.createToStorage(placeholder, r.getImage(),"http://localhost/Pi-final/web/images/" +r.getImage()).scaled(height, width));
            System.out.println("http://localhost/Pi-final/web/images/" +r.getImage());
            Container c1 = new Container(BoxLayout.x());
            tn = new TextArea("Nom");
            Label l1 = new Label(r.getNom());
            tn.setUIID("TextAreaBlack");
            c1.add(tn);
            c1.add(l1);

            Container c2 = new Container(BoxLayout.x());
            ts = new TextArea("Auteur");
            Label l2 = new Label(r.getAuteur());
            ts.setUIID("TextAreaBlack");
            c2.add(ts);
            c2.add(l2);

            Container c3 = new Container(BoxLayout.x());
            tt = new TextArea("Description");
            Label l3 = new Label(" " + r.getDescription());
            tt.setUIID("TextAreaBlack");
            
            
            Button laimer = new Button("");
        
        Livre e = new Livre();
        ReservationLivre ae = new ReservationLivre(1, r.getId());
        ReservationService aes=new ReservationService();
      
        Label like = new Label(r.getQuantite()+" disponibles ");
        
        if (aes.findEmp(ae)) {
            laimer.setText("Rendre");
            
        } else {
            laimer.setText("Empreinter");
            
        }            
        
        int qte = r.getQuantite();
        laimer.addActionListener((ActionEvent ev) -> {
            if (laimer.getText().equalsIgnoreCase("Empreinter")) {
                System.out.println("j'aimmeee");
                System.out.println("is s7i7?????? "+r.getId());
                laimer.setText("Rendre");
                aes.empreinter(ae);                
                Livre ll = new Livre();
                System.out.println(ll.getQuantite()+"qteeeeee");
                like.setText(qte-1 +" disponibles ");
                System.out.println(qte);
                revalidate();
            } else {
                laimer.setText("Empreinter");
                
                aes.rendre(ae);
                like.remove();
                like.setText(qte-1 +" disponibles ");
                System.out.println("aimer pas");
                System.out.println(qte);
                revalidate();
            }
        
        });
        //like.setText(r.getQuantite()+ " disponibles");
            System.out.println(r.getQuantite());
            c3.add(tt);
            c3.add(l3);

            c.add(image);                    
            c.add(c1);
            c.add(c2);
            c.add(c3);
            c.add(laimer);
            c.add(like);
            
            f.add(c);    

            f.show();
        }
        
    }
    
        public URLImage photo(int w, int h, String pa) {
        URLImage photo2 = URLImage.createToStorage(EncodedImage.createFromImage(Image.createImage(w, h, 0xfff00000), true), pa,
                "http://localhost/Pi_final/web/images/" + pa
        );
        photo2.fetch();
        return photo2;
    }
    
    


   /* Form f = new Form("Liste des Livres");
    Livre r = new Livre();
    TextArea noml;
    TextArea auteurl;
    TextArea descriptionl;
    //SpanLabel lb = new SpanLabel("Liste :  ");

    public ListeLivre(Form previous) {
        //f.add(lb);
    
        LivreService ser = new LivreService();
        //  lb.setText(ser.rechercheSkill().toString());
        ArrayList<Livre> l = ser.AfficheLivre();
        for (int i = 0; i < l.size(); i++) {
            r = l.get(i);
            Container c = new Container(BoxLayout.x());

            c.getStyle().setBorder(Border.createLineBorder(1));

            noml = new TextArea("Nom");
            Label l1 = new Label(r.getNom());
            noml.setUIID("TextAreaBlack");

            auteurl = new TextArea("Specialite");
            Label l2 = new Label(r.getAuteur());
            auteurl.setUIID("TextAreaBlack");

            descriptionl = new TextArea("Telephone");
            Label l3 = new Label(" " + r.getDescription());
            descriptionl.setUIID("TextAreaBlack");

            c.add(noml);
            c.add(l1);

            c.add(auteurl);
            c.add(l2);

            c.add(descriptionl);
            c.add(l3);
            f.add(c);
            
            f.show();
            //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
            
        }
    }*/

             /*
    public  ListeLivre(Form previous) {
       setTitle("List Livres");
        SpanLabel sp = new SpanLabel();
        
        sp.setText(LivreService.getInstance().AfficheLivre().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }    */
    
}
