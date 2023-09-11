
Este package pretende mostrar uma implementação simples do padrão MVC 
(Model-View-Controller).

Assim, temos uma classe de nome ChangeNotifier que se destina e propagar
eventos de alteração, ou seja, ChangeEvents. Esta classe também permite
o registo de ChangeListeners, ou seja, o registo de objectos quer querem 
receber notificações (eventos) de alteração de estado.

Um Model deve possuir uma instância desta classe de modo a permitir o 
registo de ChangeListeners e permitir a difusão de ChangeEvents.

Então um Viewer tem de registar um seu ChangeListener no Model (ou melhor 
no objecto ChangeNotifier do Model), é por isso que um model tem de 
implementar a interface IChangeNotifier, para que se saiba que tem um
método de registo de ChangeListeners.

Um controller actua sobre o model, através dos seus métodos de setValue, 
ou outros do género. Aqui não se criou métodos com nome predefinidos.
