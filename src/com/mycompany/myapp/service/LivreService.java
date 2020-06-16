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
import com.mycompany.myapp.entities.Type;
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
public class LivreService {
    public ArrayList<Livre> livres;
    
    public static LivreService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public LivreService() {
         req = new ConnectionRequest();
    }

    public static LivreService getInstance() {
        if (instance == null) {
            instance = new LivreService();
        }
        return instance;
    }
    public ArrayList<Livre> AfficheLivre() {
      ArrayList<Livre> livres = new ArrayList<>();
      ConnectionRequest con = new ConnectionRequest();
      con.setUrl(Statics.BASE_URL+"/biblio/AfficheLivre");
      con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listOffres = getListOffre(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> restaurant = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) restaurant.get("root");
                    for (Map<String, Object> obj : list) {  
                        Livre t = new Livre();
                float id = Float.parseFloat(obj.get("idLivre").toString());
                t.setId((int)id);
                t.setNom(obj.get("nom").toString());
                t.setAuteur(obj.get("auteur").toString());
                t.setDescription(obj.get("description").toString());
                
                
                t.setImage(obj.get("image").toString());                
                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
                t.setNbPersonnes(((int)Float.parseFloat(obj.get("nbpersonnes").toString())));
                
                
                LinkedHashMap<String, Object> obgtype = (LinkedHashMap<String, Object>) obj.get("type");
                        Type u = new Type();
                        
                        u.setIdL((int) Float.parseFloat(obgtype.get("idL").toString()));
                        u.setLibelle(obgtype.get("libelle").toString());
                        System.out.println("uuuuuuuuuu "+u);
                        
                t.setId_type((Type) u);
                
                
                livres.add(t);
                    }
                } catch (IOException ex) {
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return livres;
    }
 
    /*
    public ArrayList<Livre> parseTasks(String jsonText){
        try {
            livres=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Livre t = new Livre();
                float id = Float.parseFloat(obj.get("idLivre").toString());
                t.setId((int)id);
                t.setNom(obj.get("nom").toString());
                t.setAuteur(obj.get("auteur").toString());
                t.setDescription(obj.get("description").toString());
                
                
                t.setImage(obj.get("image").toString());                
                t.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
                t.setNbPersonnes(((int)Float.parseFloat(obj.get("nbpersonnes").toString())));
                
                
                LinkedHashMap<String, Object> obgtype = (LinkedHashMap<String, Object>) obj.get("type");
                        Type u = new Type();
                        
                        u.setIdL((int) Float.parseFloat(obgtype.get("idL").toString()));
                        u.setLibelle(obgtype.get("libelle").toString());
                        System.out.println("uuuuuuuuuu "+u);
                        
                t.setId_type((Type) u);
                
                
                livres.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return livres;
    }
    
    public ArrayList<Livre> AfficheLivre(){
        String url = Statics.BASE_URL+"/biblio/AfficheLivre";
       req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                livres = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return livres;
    }
*/
}

