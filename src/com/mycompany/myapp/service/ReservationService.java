/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Livre;
import com.mycompany.myapp.entities.ReservationLivre;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Smirani
 */
public class ReservationService {
    
    public static LivreService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ReservationService() {
         req = new ConnectionRequest();
    }

    public static LivreService getInstance() {
        if (instance == null) {
            instance = new LivreService();
        }
        return instance;
    }
    
    public boolean findEmp(ReservationLivre p)
    {
        for (int i=0;i<getAll().size();i++)
        {
            if((p.getId_livre()==getAll().get(i).getId_livre()) &&(p.getId_eleve()==getAll().get(i).getId_eleve())  )
            {
                 return true;       
            }
        }
        return false;
        /*
        LivreService ls = new LivreService();
        ArrayList<Livre> list = ls.AfficheLivre();
        for (int i=0;i<list.size();i++)
        {
            if((p.getId_livre()==list.get(i).getId()) &&(p.getId_eleve()==1)  )
            {
                 return true;       
            }
        }
        return false;*/
    }
    
    public ArrayList<ReservationLivre > getAll() {
       
        ArrayList<ReservationLivre> listParticipation = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(Statics.BASE_URL+"/biblio/ListeEmpreinteM");
        con.addResponseListener((NetworkEvent evt) -> {
            //listTasks = getListTask(new String(con.getResponseData()));
            JSONParser jsonp = new JSONParser();
            
            try {
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                //System.out.println("eeeeeeeeeeeeeee "+tasks);
                //System.out.println(tasks);
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                //System.out.println("liste res = "+list);
                for (Map<String, Object> obj : list) {
                    
                    ReservationLivre p=new ReservationLivre();
                    
                    p.setId((int) Float.parseFloat(obj.get("id").toString()));
                    
                    LinkedHashMap<String,Object> objEvenement= (LinkedHashMap<String,Object> ) obj.get("id_livre");
                    p.setId_livre(182);
                    System.out.println("idlivre = "+p.getId_livre());
                    LinkedHashMap<String,Object> objUser= (LinkedHashMap<String,Object> ) obj.get("id_eleve");
                    p.setId_eleve(2);
                    
                    System.out.println("p====== "+p);
                    listParticipation.add(p);
                    
                }
            } catch (IOException ex) {
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listParticipation;
    }
    
    public void empreinter(ReservationLivre a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Pi-final/web/app_dev.php/biblio/ReservationLivreM/" + a.getId_livre();
        con.setUrl(Url);

     //   System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
          //  System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void rendre(ReservationLivre a) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Pi-final/web/app_dev.php/biblio/RendreLivreM/" + a.getId_livre();
        con.setUrl(Url);
     //   System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            //System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     public int nbraimer(int id)
    {
        int nbr=0;
        for (int i=0;i<getAll().size();i++)
        {
           if(getAll().get(i).getId_livre()==id)
           {
               nbr++;
           }
        }
        return nbr;
    }
    
}
