package entities;


//classe abstrata;
// nao pode ser instanciada 
//(notacao UML: italico)
//Para garantir heranca total: apenas as subclasses podem ser instanciadas
public abstract class Lesson {
	private String title;
	
	public Lesson() {}

	public Lesson(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	//metodo abstrata
	//(notacao UML: italico)
	public abstract int duration();	
	
}
