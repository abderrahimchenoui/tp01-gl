package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui_control.Gui_Control;
import org.emp.gl.gui_display.Gui_Display;
import org.emp.gl.myWatch.MyWatch;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.actions.Action;

public class App {

    static {

        Lookup.getInstance().register(TimerService.class, new MyWatch());
        
        // add to lookup mywatch service that do the logique of config, mode and increment
        Lookup.getInstance().register(Action.class, new MyWatch());
    }

    public static void main(String[] args) {

        testDuTimeService();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Control().setVisible(true);
                new Gui_Display().setVisible(true);
            }
        });
    }


    private static void testDuTimeService() {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);

        ts.addTimeChangeListener(new Gui_Display());


    }

    public static void clearScreen() {
       //System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
