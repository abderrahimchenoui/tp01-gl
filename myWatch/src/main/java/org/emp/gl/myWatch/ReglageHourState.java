package org.emp.gl.myWatch;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerService;

/**
 *
 * @author pc
 */
public class ReglageHourState extends WatchState {
    
     
    ReglageHourState(MyWatch mywatch){
        super(mywatch);
    }
    
    @Override
    void do_config() {
        mywatch.changeState(new NormalState(mywatch));
        System.out.println("current state : normale");
    }

    @Override
    void do_mode() {
        mywatch.changeState(new ReglageSecState(mywatch));
        System.out.println("current state : reglage seconde");
    }

    @Override
    void do_increment() {
        //traitement d'incrémentation
        MyWatch a = (MyWatch) Lookup.getInstance().getService(TimerService.class);
        a.updateHeures();
    }
}
