package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import java.io.Serializable;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;

    private ToDoList toDoList;

	private int toDosCount = 0;
    
	public ToDoListMB() {
		super();
		this.toDoList = new ToDoList();
		this.toDosCount = this.getToDoList().getToDos().size();
	}

	public int getDoneToDos() {
		int countDoneToDos = 0;
		for( ToDo todo: toDoList.getToDos() )
		{
			if(todo.isDone())
				countDoneToDos++;
		}
		return  countDoneToDos;
	}


	public ToDoList getToDoList() {
		return toDoList;
	}

	public void setToDoList(ToDoList toDoList) {
		this.toDoList = toDoList;
	}

	public int getToDosCount() {
		return toDosCount;
	}

	//Should be called if the Button "Speichern" is pushed.
	//Needs configuration in the faces-config.xml.
    public String save() {
    	return "save";
    }
}
