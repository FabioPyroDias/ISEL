package classcode.p15Swing.p07MyModelViewController;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * Esta classe suporta o registo de ChangeListeners e a divulgação dos
 * ChangeEvents. Os objectos que são MODEL devem possuir um objecto desta
 * classe.
 * 
 */
public class ChangeNotifier implements IChangeNotifier {

	protected ArrayList<ChangeListener> listenerList = new ArrayList<ChangeListener>();

	/**
	 * add one changeListener to the end of the list
	 */
	public void addChangeListener(ChangeListener l) {
		listenerList.add(l);
	}

	/**
	 * Should fire the changeEvent for every changeListeners registered
	 */
	public void fireStateChanged(ChangeEvent e) {
		for (ChangeListener listener : listenerList) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					listener.stateChanged(e);
				}
			});
		}
	}

	/**
	 * get the list of changeListeners
	 */
	protected List<ChangeListener> getChangeListeners() {
		return listenerList;
	}

}
