/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.gui_display;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author pc
 */
public class Gui_Display extends javax.swing.JFrame implements TimerChangeListener{

    
    public Gui_Display() {
        initComponents();     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        heurs = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        secondes = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        meli_Secondes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 0));
        setSize(new java.awt.Dimension(20, 20));

        jLabel1.setBackground(new java.awt.Color(0, 102, 204));
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Smart  Watch");

        heurs.setBackground(new java.awt.Color(40, 200, 180));
        heurs.setForeground(new java.awt.Color(50, 5, 70));
        heurs.setText("HH");
        heurs.setMaximumSize(new java.awt.Dimension(20, 20));
        heurs.setMinimumSize(new java.awt.Dimension(20, 20));
        heurs.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel3.setText(":");

        minutes.setForeground(new java.awt.Color(51, 0, 0));
        minutes.setText("MM");

        jLabel5.setText(":");

        secondes.setText("SS");

        jLabel7.setText(",");

        meli_Secondes.setText("MS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(heurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meli_Secondes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(minutes)
                    .addComponent(jLabel5)
                    .addComponent(secondes)
                    .addComponent(jLabel7)
                    .addComponent(meli_Secondes))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel heurs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel meli_Secondes;
    public static javax.swing.JLabel minutes;
    public static javax.swing.JLabel secondes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
                
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        
         Integer h = ts.getHeures();
         Integer m = ts.getMinutes();
         Integer s = ts.getSecondes();
         Integer ms = ts.getDixiemeDeSeconde();
         
        String H = h.toString();
        String M = m.toString();
        String S = s.toString();
        String MS = ms.toString();
         
        switch (pce.getPropertyName()){
            case TimerChangeListener.HEURE_PROP:
                heurs.setText(H.toString());
                minutes.setText(M.toString());
                secondes.setText(S.toString());
                meli_Secondes.setText(MS.toString());
                
                
                break;
            case TimerChangeListener.MINUTE_PROP:
                  heurs.setText(H);
                  
                  heurs.setText(H.toString());
                minutes.setText(M.toString());
                secondes.setText(S.toString());
                meli_Secondes.setText(MS.toString());
                
                
                break;
            case TimerChangeListener.SECONDE_PROP:

                heurs.setText(H.toString());
                minutes.setText(M.toString());
                secondes.setText(S.toString());
                meli_Secondes.setText(MS.toString());

               
                break;
            case TimerChangeListener.DIXEME_DE_SECONDE_PROP:
                
                heurs.setText(H.toString());
                minutes.setText(M.toString());               
                secondes.setText(S.toString());
                meli_Secondes.setText(MS.toString());
                 
                
                break;
               
        }
   
    }



}
