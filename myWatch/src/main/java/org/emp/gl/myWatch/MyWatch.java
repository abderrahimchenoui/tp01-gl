package org.emp.gl.myWatch;

import org.emp.gl.timer_service_impl_withdelegation.Timer_service_impl_withdelegation;
import org.emp.gl.actions.Action;

/**
 *
 * @author pc
 */
public class MyWatch extends Timer_service_impl_withdelegation implements Action {
    
    WatchState state;
    
    public MyWatch(){
        super();
        this.state = new NormalState(this);
    }
    
    public void changeState(WatchState state){
        this.state = state;
    }
    public WatchState getState(){
        return this.state;
    }

    @Override
    public void do_config() {
        state.do_config();
    }

    @Override
    public void do_mode() {
        state.do_mode();
    }

    @Override
    public void do_increment() {
        state.do_increment();
    }
    
    
}
