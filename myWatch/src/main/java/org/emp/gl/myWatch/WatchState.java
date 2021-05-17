/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.myWatch;

/**
 *
 * @author pc
 */
abstract class WatchState {
    
    protected MyWatch mywatch;
    
    WatchState(MyWatch mywatch){
        this.mywatch = mywatch;
    }
    
    abstract void do_config();
    abstract void do_mode();
    abstract void do_increment();
    
}
