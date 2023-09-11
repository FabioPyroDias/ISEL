package classcode.p15Swing.p07MyModelViewController;

import javax.swing.event.ChangeListener;

/**
 * Entidade que dispara eventos de alteração/change. Quem dispara eventos de
 * change é o model (em MVC). Essa entidade "tem" de implementar esta interface
 */

public interface IChangeNotifier {

	public abstract void addChangeListener(ChangeListener l);

}