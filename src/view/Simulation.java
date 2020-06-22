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

import modele.Arret;
import modele.Bus;
import modele.Ligne;
import modele.Reseau;
import utilitaire.Position;


public class Simulation extends JFrame {	
	
	/** Pour éviter un warning venant du JFrame */
	private static final long serialVersionUID = -8123406571694511514L;
	
	/* Variables */
	private static Reseau reseau;
 
	/* Constructeur */
  	public Simulation(Reseau reseau) {
	    super("Simulation réseau de bus");
	    
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
  	
  	public static void main(String[] args) {

  		/* Les bus */
  		Bus b1 = new Bus(1);
		Bus b2 = new Bus(2);
		Bus b3 = new Bus(3);
		
		/* Les arrets */
		Arret a1 = new Arret("A", new Position(100, 20));
		Arret a2 = new Arret("B", new Position(200, 20));
		Arret a3 = new Arret("C", new Position(300, 100));
		Arret a4 = new Arret("D", new Position(50, 200));
		Arret a5 = new Arret("E", new Position(150, 200));
		Arret a6 = new Arret("F", new Position(250, 200));
		
		/* Les lignes */
		Ligne l1 = new Ligne("Ligne 1");
		l1.addArret(a1);
		l1.addArret(a2);
		l1.addArret(a3);
		l1.addArret(a4);
		
		Ligne l2 = new Ligne("Ligne 2");
		l2.addArret(a5);
		l2.addArret(a3);
		l2.addArret(a6);
		
		/* Le réseau */
		reseau = new Reseau();
		reseau.addLigne(l1);
		reseau.addLigne(l2);
				
		/* La simulation */
		Simulation simulation = new Simulation(reseau);
		simulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simulation.setSize(1200, 800);
		simulation.setVisible(true);
	    
	}
}