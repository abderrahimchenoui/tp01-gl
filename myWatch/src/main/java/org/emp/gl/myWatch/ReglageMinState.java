package org.emp.gl.myWatch;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author hafia
 */
public class ReglageMinState extends WatchState {
    
    ReglageMinState(MyWatch mywatch){
        super(mywatch);
    }
    
     @Override
    void do_config() {
        mywatch.changeState(new NormalState(mywatch));
        System.out.println("current state : normale");
    }

    @Override
    void do_mode() {
        mywatch.changeState(new ReglageHourState(mywatch));
        System.out.println("current state : reglage heure");
    }

    @Override
    void do_increment() {
        //traitement d'incrémentation
        MyWatch a = (MyWatch) Lookup.getInstance().getService(TimerService.class);
        a.updateMinutes();
    }
}
