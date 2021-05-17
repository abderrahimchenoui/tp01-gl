/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author tina
 */
public class AfficheurHeureSurConsole implements TimerChangeListener {

    
    //Fonctionnalité de réafficher l'heure courante après chaque changement des secondes ,minutes ou des heures 
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        
        switch (pce.getPropertyName()){
            case TimerChangeListener.HEURE_PROP:
                System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
                break;
            case TimerChangeListener.MINUTE_PROP:
                System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
                break;
            case TimerChangeListener.SECONDE_PROP:
                System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
                break;
            case TimerChangeListener.DIXEME_DE_SECONDE_PROP:
                System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
                break;
               
        }
        
    }

}
