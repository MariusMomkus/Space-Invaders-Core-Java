package logic.commandPatternControl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyboardController extends KeyAdapter {
    private Map<Integer, Command> commands;
    private Integer key;

    public KeyboardController(){
        commands = new HashMap<>();
    }

    public void setCommand(Integer keyCode, Command command){
        commands.put(keyCode, command);
    }

    public void keyReleased(KeyEvent keyEvent) {
        key = keyEvent.getKeyCode();
    }
    public void keyPressed(KeyEvent keyEvent){
        key = keyEvent.getKeyCode();
        commands.get(key).execute();
    }
}
