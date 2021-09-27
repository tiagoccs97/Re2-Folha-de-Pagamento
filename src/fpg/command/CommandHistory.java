package fpg.command;

import java.util.Stack;


public class CommandHistory {
	
	private Stack<Command> Undo = new Stack<>();
	private Stack<Command> Redo = new Stack<>();	

	public void pushUndo(Command command){
		Undo.push(command);
	}
	public Command popUndo() {
		return Undo.pop();
	}
	public void pushRedo(Command command){
		Redo.push(command);
	}
	public Command popRedo() {
		return Redo.pop();
	}
	public boolean isEmptyUndo() {
		return Undo.isEmpty();
		
	}
	public boolean isEmptyRedo() {
		return Redo.isEmpty();
	}
} 
