package entity;

import java.util.Comparator;
import java.util.Objects;

public class Process implements Comparable, Comparator {

	private int pid;
	private int priority;
	private int duration;
	
	public Process(int pid, int priority, int duration) {
		this.pid = pid;
		this.priority = priority < 0? 0 : priority > 10? 10 : priority;
		this.duration = duration;
	}
	
	public Process() {
		
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority < 0? 0 : priority > 10? 10 : priority;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pid);
	}

	@Override
	public boolean equals(Object obj) {
		return pid == ((Process)obj).pid;
	}

	@Override
	public String toString() {
		return "Process [pid=" + pid + ", priority=" + priority + ", duration=" + duration + "]";
	}

	@Override
	public int compareTo(Object o) {
		int x = priority < ((Process)o).priority? 1 :
				priority == ((Process)o).priority? 0 : -1;
		if(x == 0)
			x = duration > ((Process)o).duration? 1 :
					duration == ((Process)o).duration? 0 : -1;
		return x;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return ((Process)o1).pid < ((Process)o2).pid? 1 :
				((Process)o1).pid == ((Process)o2).pid? 0 : -1;
	}
	
	
}
