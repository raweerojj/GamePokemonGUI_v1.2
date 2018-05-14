
package gamepokemongui_v2;

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
import static gamepokemongui_v2.CommandGame.printPokemons;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.Component;

/**
 *
 * @author rebor
 */
public class CommandGame extends JFrame {
    JButton bteat,btrun,btatk;
    JPanel p1,p2,p3;
    JLabel image,user;
    Icon begin,lugia,gradon;
    JTextArea area;
    JComboBox select;
    int member;
    
     public static String printPokemons(ArrayList<Pokemon> pokemons, int member){
        return "===== Pokemon List =====\n"+"Pokemon "+
                pokemons.get(member).getName()+"\n"+"Health : "+pokemons.get(member).getHealth()
                +"/"+pokemons.get(member).maxHealth+"\n"+"Weight : "+
                pokemons.get(member).getWeight();
    }
    public CommandGame(String s){
        super("PokemonGame");
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());    
        pokemons.add(new Gradon());
        pokemons.add(new Lugia());

        area = new JTextArea("");
        lugia = new ImageIcon(getClass().getResource("lugia.gif"));
        gradon = new ImageIcon(getClass().getResource("Gradon.gif"));
        image = new JLabel("");
        image.setIcon(begin);
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());

     
        //Name -----------------------User----------------------------------------
        user = new JLabel("Player : "+s);
        
        // List ---------------------- Pokemon ---------------------------------------
        String[] pokemonStrings = { "-------Gradon--------", "------Lugia------" };
	select = new JComboBox(pokemonStrings);
	select.setSelectedIndex(1);
        
        // Button 
        //-------------------------- pokemonList ------------------------------------
        JButton btpl = new JButton("Select");
		btpl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"You selected : " +select.getSelectedItem());
			}
		});
        //-------------------------- select ----------------------------------------
        btpl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        image.setIcon(gradon);
                        area.setText(printPokemons(pokemons,0));
                        break;
                    case 1:
                        image.setIcon(lugia);  
                        area.setText(printPokemons(pokemons,1));
                        break;
                    default:
                        break;
                }
            }
        });
        
        //----------------------- eat -------------------------------------------
        bteat = new JButton("eat");
        bteat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HpBerry berry = new HpBerry(0);
                switch (select.getSelectedIndex()) {
                    case 0:
                        for(Pokemon pokemon: pokemons)
			pokemon.eat(berry);
                        area.setText(printPokemons(pokemons,0));
                        image.setIcon(gradon);
                        break;
                    case 1:
                        for(Pokemon pokemon: pokemons)
			pokemon.eat(berry);
                        area.setText(printPokemons(pokemons,1));
                        image.setIcon(lugia);
                        break;
                    default:
                        break;
                }
            }
            
        });
        

        //------------------------ run -----------------------------------------
        btrun = new JButton("run");
        btrun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
			pokemons.get(0).move();
                        area.setText(printPokemons(pokemons,0));
                        image.setIcon(gradon);
                        break;
                    case 1:
			pokemons.get(1).move();
                        area.setText(printPokemons(pokemons,1));
                        image.setIcon(lugia);
                        break;
                    default:
                        break;
                }
                

            }
            
        });
        //--------------- actrack ----------------------------------------------
        btatk = new JButton("attack");
        btatk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (select.getSelectedIndex()) {
                    case 0:
                        JOptionPane.showMessageDialog(new Vs(pokemons,0),"Start Battle");
                        image.setIcon(gradon);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(new Vs(pokemons,1),"Start Battle");
                        image.setIcon(lugia);
                        break;
                    default:
                        break;
                }
            }
            
        });   
        
        //------------------------------- add ----------------------------------
        p1.add(user);
        p1.add(select);
        p1.add(btpl);
        p1.add(bteat);
        p1.add(btrun);
        p1.add(btatk);     
        p2.add(image);
        p3.add(area);
        
        c.add(p1, BorderLayout.PAGE_END);
        c.add(p2, BorderLayout.PAGE_START);
        c.add(p3, BorderLayout.CENTER);

        //set others
        setLocation(800, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(700,620);
        setVisible(true);
        
    }
}
