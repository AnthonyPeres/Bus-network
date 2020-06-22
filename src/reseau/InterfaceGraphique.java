package reseau;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
 
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
 
public class InterfaceGraphique extends JFrame {
 
	
	/* Integrer cette JFRAME A une view
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	/** Pour éviter un warning venant du JFrame */
	private static final long serialVersionUID = -8123406571694511514L;
 
  	public InterfaceGraphique(Reseau reseau) {
	    super("JGrapghX tutoriel: Exemple 1");
	 
	    mxGraph graph = new mxGraph();
	    Object parent = graph.getDefaultParent();
	 
	    graph.getModel().beginUpdate();
	    
	    try {
	    	
	    	ArrayList<Object> objets;

	    	int indice = 0;
	    	
	    	for (Ligne l: reseau.getLignes()) {
	    		
	    		objets = new ArrayList<Object>();
	    		
	    		for (Arret a: l.getArrets()) {
	    			
    				// On place l'arret
	    			objets.add(graph.insertVertex(parent, null, a.getNom(), a.getPosition().getPositionX(), a.getPosition().getPositionY(), 40, 15));
	    			
	    			
	    			// Si il y en a des déjà placé, on le relie
	    			if (indice >= 1) {
	    				
	    				// SI IL Y A UN BUS SUR LA LIGNE ET ENTRE CES DEUX ARRETS, ON MET LE NOM DU BUS DESSUS
	    				// EXEMPLE FICTIF
	    				String nomBus = "Bus 1";
	    				graph.insertEdge(parent, null, nomBus, objets.get(indice -1), objets.get(indice));
	    			}
	    			
	    			indice++;
	    			
	    		}
	    		indice = 0;
	    	}
	    } finally {
	    	graph.getModel().endUpdate();
	    }
	 
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    getContentPane().add(graphComponent);
  	}
}