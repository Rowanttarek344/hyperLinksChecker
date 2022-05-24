/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author ADMIN
 */
public class methods {
    public static int count;
    public void validateURL(String link, int currentdepth, int totaldepth) throws IOException
    {
        if (validateSingleUrl(link))
        {
            System.out.println("Valid Link " + link);
            if(currentdepth == totaldepth)
                return;
            else
            {
                
            String links[]=extractLinks(link);
            for(int i=0;i<count ;i++)
            {
                 if (validateSingleUrl(links[i])) {
                System.out.println("Valid :  " + links[i]);
            } else {
                System.out.println("InValid :  " + links[i]);
            }
                validateURL(links[i+1],currentdepth+1,totaldepth);
            }
            
            
            
            
            
       
        
            //if (validateSingleUrl(x)) {
            //    System.out.println("Valid :  " + x);
            //} else {
              //  System.out.println("InValid :  " + x);
            //}

    }
    }
    }
       
    private String[] extractLinks(String link) {

        try {
            Document doc = Jsoup.connect(link).get();
            Elements e = doc.select("a[href]");
            System.err.println("Count of Links:" + e.size());
            URL u=new URL(link);
            String links[] = new String[e.size()];
            for(int i=0;i<e.size();i++)
            {
                
                links[i] = e.get(i).attr("href");
                String baseLINK = u.getProtocol() + "://" + u.getHost();
                if (!links[i].startsWith("http")) {
                    links[i] = baseLINK + links[i];
                }
                count++;
                
            }
            return links;
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
            
  
    
    public boolean validateSingleUrl(String link){

         boolean valid = false;
        try {
            Document doc = Jsoup.connect(link).get();
            valid = true;
        } catch (HttpStatusException ex) {  
            valid = false;
        } catch (IOException ex) { 
            valid = false;
        }
        return valid;
    }
    
    
}
  
