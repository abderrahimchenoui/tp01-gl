/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer_service_impl_withdelegation;


import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author pc
 */
public class Timer_service_impl_withdelegation extends TimerTask implements TimerService {

    int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;
    
    PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this) ;
    
    public Timer_service_impl_withdelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();
        //LocalTime localTime = LocalTime.of(15, 10, 10); pour changer 

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        propertyChangeSupport.addPropertyChangeListener(pl);
        
    }
    
    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        
        propertyChangeSupport.removePropertyChangeListener(pl);
        
        }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    private void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;
        
        // informer les listeners ! 
        propertyChangeSupport.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP,
                    oldValue, dixiemeDeSeconde);
        

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    public void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;

        propertyChangeSupport.firePropertyChange(TimerChangeListener.SECONDE_PROP,
            oldValue, secondes);
        
        
        if (secondes == 0) {
            updateMinutes();
        }
    }

    public void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;

        propertyChangeSupport.firePropertyChange(TimerChangeListener.MINUTE_PROP,
               oldValue, minutes);
       
        if (minutes == 0) {
            updateHeures();
        }
    }

    public void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;

       propertyChangeSupport.firePropertyChange(TimerChangeListener.HEURE_PROP,
                    oldValue, heures);
        
    }
    public void onPause() throws InterruptedException{
        
        propertyChangeSupport.wait();
       
    }
}
