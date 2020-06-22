package context;

public interface EtatBus {

	public abstract void stopper(ContextBus context);
	public abstract void demarrer(ContextBus context);
	public abstract void sortirDepot(ContextBus context);
	public abstract void retourDepot(ContextBus context);
}
