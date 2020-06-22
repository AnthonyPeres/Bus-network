package view;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import reseau.Arret;
import reseau.Ligne;
import reseau.Reseau;
 
public class InterfaceGraphique extends JFrame {	
	
	/** Pour éviter un warning venant du JFrame */
	private static final long serialVersionUID = -8123406571694511514L;
 
	/* Constructeur */
  	public InterfaceGraphique(Reseau reseau) {
	    super("JGrapghX tutoriel: Exemple 1");
	    
	    /* La partie menu */
	    JPanel menu = new JPanel();
	    menu.setBackground(SystemColor.inactiveCaption);
	    menu.setBounds(0, 0, 1200, 50);
	    getContentPane().add(menu);
	    menu.setLayout(null);
	    
	    /* Bouton activer simulation */
	    JButton boutonRunOrStop = new JButton("Lancer la simulation");
	    boutonRunOrStop.setBounds(500, 15, 200, 20);
	    boutonRunOrStop.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		// Lancer ou arreter simulation
	    	}
	    });
	    
	    menu.add(boutonRunOrStop);
	    
	    /* La partie simulation */
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
	    graphComponent.setBounds(0, 50, 1200, 750);
	    getContentPane().add(graphComponent);
  	}
}