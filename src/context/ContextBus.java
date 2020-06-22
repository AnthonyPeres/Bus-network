package context;

import events.IEventsControleBus;

public class ContextBus {

	
	private IEventsControleBus m_refCtrlBus;
	private EtatBus m_possedeEtat;
	
	public ContextBus(IEventsControleBus referenceBus) {
		// TODO Auto-generated constructor stub
		m_refCtrlBus = referenceBus;
		m_possedeEtat = new EtatDepot();
	}

	public IEventsControleBus getControlesBus() {
		return m_refCtrlBus;
	}
	
	
	public void changerEtat(EtatBus etat) {
		m_possedeEtat = etat;
	}
	
	public void stopper() {
		m_possedeEtat.stopper(this);
	}
	
	public void demarrer() {
		m_possedeEtat.demarrer(this);
	}
	
	public void sortirDepot() {
		m_possedeEtat.sortirDepot(this);
	}
	
	public void retourDepot() {
		m_possedeEtat.retourDepot(this);
	}
}
