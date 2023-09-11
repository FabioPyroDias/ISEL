public class Admin {

	private static minhasVariaveis mv;
	private static GUI_Admin gui;
	
	private static Vaguear vaguear;
	private static Evitar evitar;
	private static Fugir fugir;
	
	/*
	private static Semaphore semaphoreVaguear;
	private static Semaphore semaphoreEvitar;
	private static Semaphore semaphoreFugir;
	*/
	
	public Admin()
	{
		mv = new minhasVariaveis();
		
		/*
		semaphoreEvitar = new Semaphore(0);
		semaphoreVaguear = new Semaphore(0);
		semaphoreFugir = new Semaphore(0);
		
		
		vaguear = new Vaguear(semaphoreVaguear);
		evitar = new Evitar(semaphoreEvitar);
		fugir = new Fugir(semaphoreFugir);
		*/
		
		vaguear = new Vaguear();
		fugir = new Fugir(vaguear);
		evitar = new Evitar(fugir, vaguear);
		
		vaguear.start();
		fugir.start();
		evitar.start();
		
		gui = new GUI_Admin(mv, vaguear, evitar, fugir);
	}
	
	public static void main(String[] args) {
		Admin admin = new Admin();
		admin.run();
	}
	
	private void run()
	{
		//evitar.funcionar();
		//vaguear.funcionar();
		//fugir.funcionar();
	}
}