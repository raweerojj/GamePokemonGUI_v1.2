/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepokemongui_v2;

/**
 *
 * @author Raweeroj
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static gamepokemongui_v2.Vs.printPokemons;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Dimension;

public class Vs extends JFrame{
    JButton runOut,attack2;
    JPanel p1,p2,p3;
    JLabel image,user;
    Icon begin,bt2,bt1;
    JTextArea area;
    JComboBox select;
    int member;
    
     public static String printPokemons(ArrayList<Pokemon> pokemons, int member){
        String hp = "========== Pokemon List ========== \n"+"Name: "+
                pokemons.get(member).getName()+"\nHealth: "+pokemons.get(member).getHealth()
                +"/"+pokemons.get(member).maxHealth;
        String weight = " Weight: "+ pokemons.get(member).getWeight();
        return hp+"\n"+weight;
    }
    public Vs(ArrayList<Pokemon> pokemons,int n){
        super("PokemonGame");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());      
        pokemons.add(new Gradon());
        pokemons.add(new Lugia());
        
        area = new JTextArea("");        
        image = new JLabel("");        
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        
        switch (n) {
            case 0:
                bt2 = new ImageIcon(getClass().getResource("bt2.gif"));
                image.setIcon(bt2);
                break;
            case 1:
                bt1 = new ImageIcon(getClass().getResource("bt1.gif"));
                image.setIcon(bt1);
                break;
            default:
            break;
        }
        
        //------------------------------------------------------------------------
        // Radio Button
	final JRadioButton radio1 = new JRadioButton("Berry");
	radio1.setBounds(200, 520, 109, 23); 
	getContentPane().add(radio1);
		
	final JRadioButton radio2 = new JRadioButton("GoldBerry");
	radio2.setBounds(200, 546, 109, 23);
	getContentPane().add(radio2);
		
	final JRadioButton radio3 = new JRadioButton("MysteryBerry");
	radio3.setBounds(200, 572, 109, 23);
	getContentPane().add(radio3);
		
	// Set Group
	ButtonGroup group = new ButtonGroup();
	group.add(radio1);
        group.add(radio2);
        group.add(radio3);
		
	// Button
	JButton btn = new JButton("Button");
	btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			// Check Checkbox 1
			if(radio1.isSelected()){
                                HpBerry berry = new HpBerry(0);	
				JOptionPane.showMessageDialog(null,"You select Item : Berry");
                                pokemons.get(n).eat(berry);
			} else if (radio2.isSelected()) {
                                HpBerry berry1 = new HpBerry(1);	
				JOptionPane.showMessageDialog(null,"You select Item : GoldBerry");
                                pokemons.get(n).eat(berry1);
			} else if (radio3.isSelected()) {
                                HpBerry berry2 = new HpBerry(2);
				JOptionPane.showMessageDialog(null,"You select Item : MysteryBerry");
                                pokemons.get(n).eat(berry2);
			} else {
				JOptionPane.showMessageDialog(null,"You not select.");	
			}
				
                }
	});
        
        //------------------------- berry ----------------------------------------
        String berryName[] = {
            "Berry",     
            "GoldBerry", 
            "MysteryBerry"     
        };
        select = new JComboBox(berryName);
        select.setPreferredSize(new Dimension(120,20));
               

        //------------------------ run out -----------------------------------------
        runOut = new JButton("run");
        runOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Run Out !!");
                setVisible(false);
            }
            
        });
        
        //------------------------- actrack --------------------------------------
        attack2 = new JButton("attack");
        attack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        pokemons.get(1).reducedHealth(10);
                        area.setText(printPokemons(pokemons,1));
                        if(pokemons.get(1).getHealth() == 0){
                            JOptionPane.showMessageDialog(null,"Now !! Gradon is Dead ");
                            setVisible(false);
                        }
                        break;
                    case 1:
                        pokemons.get(0).reducedHealth(10);
                        area.setText(printPokemons(pokemons,0));
                        if(pokemons.get(0).getHealth() == 0){
                            JOptionPane.showMessageDialog(null,"Now !! Gradon is Dead ");
                            setVisible(false);
                        }
                        break;                        
                }

            }
            
        });   
        
        //------------------------------ add -----------------------------------
        p1.add(runOut);
        p1.add(attack2);    
        p1.add(btn);
        p2.add(image);
        p3.add(area);
        
        c.add(p1, BorderLayout.PAGE_END);
        c.add(p2, BorderLayout.PAGE_START);
        c.add(p3, BorderLayout.CENTER);

        //------------------------ set others ----------------------------------
        setLocation(500, 180);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setSize(500,700);
        setVisible(true);
        
    }
    
}
