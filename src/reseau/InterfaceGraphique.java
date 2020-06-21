package reseau;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
 
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
 
public class InterfaceGraphique extends JFrame {
 
	/** Pour éviter un warning venant du JFrame */
	private static final long serialVersionUID = -8123406571694511514L;
 
  	public InterfaceGraphique(Reseau reseau) {
	    super("JGrapghX tutoriel: Exemple 1");
	 
	    mxGraph graph = new mxGraph();
	    Object parent = graph.getDefaultParent();
	 
	    graph.getModel().beginUpdate();
	    
	    try {
	    	
	    	ArrayList<Object> objets = new ArrayList<Object>();
	    	ArrayList<Arret> arrets = new ArrayList<Arret>();
	    	int position_x = 20;
	    	int position_y = 20;
	    	int indice = 0;
	    	
	    	for (Ligne l: reseau.getLignes()) {
	    		
	    		
	    		indice = 0;
	    		
	    		for (Arret a: l.getArrets()) {
	    			
	    			
	    			// On test si on a déjà l'arret
	    			boolean deja = false;
	    			int i = 0;
	    			for (Arret tmp : arrets) {
	    				if (a.getNom().contentEquals(tmp.getNom())) {
	    					deja = true;
	    					graph.insertEdge(parent, null, l.getNom(), objets.get(indice - 1), objets.get(i));
	    				}
	    				i++;
	    			}
	    			
	    			if (deja == false) {
	    				// On place l'arret
		    			arrets.add(a);
		    			objets.add(graph.insertVertex(parent, null, a.getNom(), position_x, position_y, 80, 30));
		    			
		    			// Si il y en a des déjà placé, on le relie
		    			if (indice > 1) {
		    				graph.insertEdge(parent, null, l.getNom(), objets.get(indice -1), objets.get(indice));
		    			}
		    			
		    			indice++;
	    			}
	    			
	    			
	    			position_x += 200;
	    		}
	    		position_y += 200;
	    		position_x = 20;
	    		
	    	}
	    	
	    } finally {
	    	graph.getModel().endUpdate();
	    }
	 
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    getContentPane().add(graphComponent);
  	}
}