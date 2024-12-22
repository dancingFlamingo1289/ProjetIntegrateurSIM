package scene.pagesObstacles;

import java.awt.* ;
import java.awt.event.* ;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.* ;
import javax.swing.border.* ;
import scene.pagesObstacles.apercu.ApercuMur;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * Page de modification pour un mur.
 * @author Elias Kassas
 * @author Aimé Melançon
 */
public class PageMur extends JPanel {
	/** Coefficient de sérialisation. **/
	private static final long serialVersionUID = 1L ;
	/**support pour lancer des evenements de type PropertyChange**/
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	/**JSpinner permettant de changer la position y de l'obstacle **/
	private JSpinner spnY;
	/**JSpinner permettant de changer la position x de l'obstacle **/
	private JSpinner spnX;
	/**JSpinner permettant de changer l'hauteur de l'obstacle **/
	private JSpinner spnHauteur;
	/**JSpinner permettant de changer la largeur de l'obstacle **/
	private JSpinner spnLargeur;
	/**JSpinner permettant de changer l'angle de l'obstacle **/
	private JSpinner spnAngle;
	/**JButton pour changer la couleur de l'obstacle **/
	private JButton btnChangerCouleur;
	/**Le bouton pour ajouter l'obstacle **/
	private JButton btnAjout;
	/**L'apercu du mur**/
	private ApercuMur apercuMur;
	
	/**
	 * Constructeur de la page de modification d'un mur.
	 */
	// Par Elias Kassas
	public PageMur() {
		setBounds(100, 100, 450, 579);
		setLayout(null);

		JLabel lblTitre = new JLabel("MUR");
		lblTitre.setBounds(12, 6, 426, 25);
		lblTitre.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitre);

		JPanel panInformations = new JPanel();
		panInformations.setBounds(12, 247, 426, 292);
		panInformations.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Param\u00E8tres", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panInformations);
		panInformations.setLayout(null);

		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setBounds(6, 23, 61, 16);
		panInformations.add(lblPosition);

		JLabel lblParOuvr = new JLabel("[");
		lblParOuvr.setBounds(140, 18, 30, 16);
		panInformations.add(lblParOuvr);

		spnX = new JSpinner();
		spnX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				majModificationObstacle();
			}
		});
		spnX.setBounds(156, 13, 93, 26);
		panInformations.add(spnX);

		JLabel lblVirg = new JLabel(",");
		lblVirg.setBounds(239, 18, 30, 16);
		panInformations.add(lblVirg);
		lblVirg.setHorizontalAlignment(SwingConstants.CENTER);

		spnY = new JSpinner();
		spnY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				majModificationObstacle();
			}
		});
		spnY.setBounds(255, 13, 79, 26);
		panInformations.add(spnY);

		JLabel lblParFerm = new JLabel("]");
		lblParFerm.setBounds(316, 18, 30, 16);
		panInformations.add(lblParFerm);
		lblParFerm.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel lblHaut = new JLabel("Hauteur :");
		lblHaut.setBounds(6, 64, 61, 16);
		panInformations.add(lblHaut);

		spnHauteur = new JSpinner();
		spnHauteur.setModel(new SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(1), null, Integer.valueOf(1)));
		spnHauteur.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				majModificationObstacle();
			}
		});
		spnHauteur.setBounds(140, 59, 85, 26);
		panInformations.add(spnHauteur);

		JLabel lblUniteM = new JLabel("m");
		lblUniteM.setBounds(245, 64, 61, 16);
		panInformations.add(lblUniteM);

		JLabel lblLargeur = new JLabel("Largeur :");
		lblLargeur.setBounds(6, 113, 61, 16);
		panInformations.add(lblLargeur);

		spnLargeur = new JSpinner();
		spnLargeur.setModel(new SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
		spnLargeur.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				majModificationObstacle();
			}
		});
		spnLargeur.setBounds(140, 109, 85, 26);
		panInformations.add(spnLargeur);

		JLabel lblUniteM_1 = new JLabel("m");
		lblUniteM_1.setBounds(245, 114, 61, 16);
		panInformations.add(lblUniteM_1);

		JLabel lblAngle = new JLabel("Angle de rotation :");
		lblAngle.setBounds(6, 164, 117, 16);
		panInformations.add(lblAngle);

		spnAngle = new JSpinner();
		spnAngle.setModel(new SpinnerNumberModel(0.0, -180.0, 180.0, 1.0));
		spnAngle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				majModificationObstacle();
			}
		});
		spnAngle.setBounds(183, 82, 85, 26);
		panInformations.add(spnAngle);

		JLabel lblUniteDegres = new JLabel("degrés");
		lblUniteDegres.setBounds(245, 164, 61, 16);
		panInformations.add(lblUniteDegres);

		JLabel lblCouleur = new JLabel("Couleur : ");
		lblCouleur.setBounds(6, 208, 61, 16);
		panInformations.add(lblCouleur);

		JLabel lblInfoCouleur = new JLabel(Color.white.toString()) ;
		lblInfoCouleur.setBounds(79, 208, 341, 16);
		panInformations.add(lblInfoCouleur);
		lblInfoCouleur.setBackground(Color.WHITE);
		lblInfoCouleur.setHorizontalAlignment(SwingConstants.CENTER);

		btnChangerCouleur = new JButton("Modifier la couleur");
		btnChangerCouleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(null, "Choisir la couleur du mur", null) ;
				 apercuMur.setCouleur(c);
			}
		});
		btnChangerCouleur.setBounds(116, 236, 194, 29);
		panInformations.add(btnChangerCouleur);

		JLabel lblUniteM_2 = new JLabel("m");
		lblUniteM_2.setBounds(358, 18, 61, 16);
		panInformations.add(lblUniteM_2);

		btnAjout = new JButton("Ajouter le mur à la table");
		btnAjout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutDObstacleTable();
			}
		});
		btnAjout.setBounds(127, 544, 195, 29);
		add(btnAjout);

		apercuMur = new ApercuMur();
		apercuMur.setBounds(22, 41, 416, 203);
		add(apercuMur);
	}
	
	/**
	 * Méthode permettant d'envoyer un obstacle à la table
	 */
	//Aimé Melançon
	public void ajoutDObstacleTable() {
		pcs.firePropertyChange("obstacle", null, apercuMur.getObstacle());
	}
	/**
	 * Méthode permettant de mettre à jour les paramètres de l'obstacle.
	 */
	//Aimé Melançon
	private void majModificationObstacle() {
		apercuMur.setLargeur(Double.parseDouble( spnLargeur.getValue().toString()));
		apercuMur.setHauteur(Double.parseDouble( spnHauteur.getValue().toString()));
		apercuMur.setAngle(Math.toRadians(Double.parseDouble( spnAngle.getValue().toString())));
		apercuMur.setPosition(Double.parseDouble( spnX.getValue().toString()),Double.parseDouble( spnY.getValue().toString()));
	}
	
	/**
	 * voici la methode qui permettra de s'ajouter en tant qu'ecouteur
	 */
	//Aimé Melançon
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}
}