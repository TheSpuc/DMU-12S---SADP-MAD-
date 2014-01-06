package Opg1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Person {
	private PropertyChangeSupport change = new PropertyChangeSupport(this);
	private List<AgeErrorEventListener> listeners = new ArrayList<AgeErrorEventListener>();
	private String name;
	private int age;
	private String address;

	public Person() {
		this.name = "";
		this.address = "";
		this.age = -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		change.firePropertyChange("name", oldName, name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0 || age > 141) {
			fireAgeErrorEvent(new AgeErrorEvent(this));
		} else {
			this.age = age;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		String oldAddress = this.address;
		this.address = address;
		change.firePropertyChange("address", oldAddress, address);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		change.addPropertyChangeListener(l);
	}

	public void removePropertyChangelIstener(PropertyChangeListener l) {
		change.removePropertyChangeListener(l);
	}

	public void addAgeErrorEventListener(AgeErrorEventListener a) {
		if (!listeners.contains(a)) {
			listeners.add(a);
		}
	}

	public void removeAgeErrorEventListener(AgeErrorEventListener a) {
		if (listeners.contains(a)) {
			listeners.remove(a);
		}
	}

	private void fireAgeErrorEvent(AgeErrorEvent event) {
		List<AgeErrorEventListener> list;
		synchronized (this) {
			list = new ArrayList<>(listeners);
		}
		for (AgeErrorEventListener ae : list) {
			ae.ageOutOfRange(event);
		}
	}
}
