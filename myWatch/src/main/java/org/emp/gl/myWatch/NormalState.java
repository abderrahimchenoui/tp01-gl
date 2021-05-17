package org.emp.gl.myWatch;


/**
 *
 * @author pc
 */
public class NormalState extends WatchState {
    
    NormalState(MyWatch mywatch){
        super(mywatch);
        
    }

    @Override
    void do_config() {
        mywatch.changeState(new ReglageSecState(mywatch));
        System.out.println("current state : reglage seconde");
      
    }

    @Override
    void do_mode() {
        System.out.println("button mode doesn't work on noraml state");
    }

    @Override
    void do_increment() {
        System.out.println("button increment doesn't work on noraml state");
    }
}
