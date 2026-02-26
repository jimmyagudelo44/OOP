package entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Planificator {

	private List<Process> pending = new LinkedList<>();
	private Set<Process> executing = new TreeSet<>();
	private static int PID;
	
	public List<Process> getPending() {
		return pending;
	}

	public void setPending(List<Process> pending) {
		this.pending = pending;
	}

	public Set<Process> getExecuting() {
		return executing;
	}

	public void setExecuting(Set<Process> executing) {
		this.executing = executing;
	}

	public void addPendingProcess(int priority, int duration) {
		pending.add(new Process(PID++, priority, duration));
		pending.sort(null);
	}
	
	public void execute() {
		if(pending.size() > 0)
			if(executing.add(pending.getFirst())) {
				System.out.println("Ejecutando "+pending.getFirst());
				pending.removeFirst();
			}else
				System.err.println("No se ejecuto ningun proceso");
		else
			System.err.println("No hay ningun proceso pendiente");
	}
	
	public List<Process> listExecution() {
		List<Process> aux = new LinkedList<>();
		Iterator<Process> i = executing.iterator();
		while(i.hasNext())
			aux.add(i.next());
		aux.sort(new Process());
		return aux;
	}
	
	public boolean abortExecution(int pid) {
		Iterator<Process> i = executing.iterator();
		boolean found = false;
		Process x = null;
		while(i.hasNext() && !found) {
			x = i.next();
			if(x.getPid() == pid && executing.remove(x))
				found = true;
		}
		return found;
	}
	
}
