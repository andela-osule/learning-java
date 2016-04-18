
public class Inheritance {

	public static void main(String[] args) {

			ParentClass pc = new ParentClass();
			pc.start();
			pc.stop();
			
			ChildClass cc = new ChildClass();
			cc.start();
			cc.stop();
			
			cc.wipeWindShield();
			cc.showInfo();
			
	}

}
