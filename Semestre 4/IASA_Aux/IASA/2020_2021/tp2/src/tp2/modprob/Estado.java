package tp2.modprob;

public abstract class Estado {
	public Estado() {}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.hashCode() == obj.hashCode();
	}
	
	
	@Override
	public abstract int hashCode();
}
