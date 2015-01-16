package org.lop.observer.subject;

import org.lop.observer.observer.Observer;

public interface Subject {

	void registerObserver( Observer o );

	void removeObserver( Observer o );

	void notifyObserver();

}