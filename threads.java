/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinks;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class threads extends Thread{ 
    private String link;
    private int depth;
    private int maxDepth;
    
    public threads(String link, int depth, int maxDepth) {
        this.link = link;
        this.depth = depth;
        this.maxDepth = maxDepth;
    }
    
   
}
