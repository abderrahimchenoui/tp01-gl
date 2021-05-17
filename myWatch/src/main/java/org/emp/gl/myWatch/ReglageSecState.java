package org.emp.gl.myWatch;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author pc
 */
public class ReglageSecState extends WatchState {
    
    ReglageSecState(MyWatch mywatch){
        super(mywatch);
    }
    
     @Override
    void do_config() {
        mywatch.changeState(new NormalState(mywatch));
        System.out.println("current state : normale");
    }

    @Override
    void do_mode() {
        mywatch.changeState(new ReglageMinState(mywatch));
        System.out.println("current state : reglage minute");
    }

    @Override
    void do_increment() {
        //traitement d'incrémentation
        MyWatch a = (MyWatch) Lookup.getInstance().getService(TimerService.class);
        a.updateSecode();
        
    }
}
