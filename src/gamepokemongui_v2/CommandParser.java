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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CommandParser extends JFrame{
    public CommandParser(){
        // JFrame Property
		super("PokemonGame_GUI_v1"); // Title
                Container c = getContentPane();
                c.setLayout(new BorderLayout());
                
                //set others
                setLocationRelativeTo(null);
                pack();
		setSize(300, 200);
		setLocation(800, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(null);
                setVisible(true);

		// Text ----------------------------- Label wellcom -----------------------------------
		JLabel welcome = new JLabel("Welcome to PokemonGame ...");
		welcome.setBounds(50, 20, 264, 60);
		c.add(welcome);
                
                // Create -------------------------- Button start -------------------------------------
		JButton letStart = new JButton("Start");
		letStart.setBounds(171, 95, 89, 23);
		c.add(letStart);
                
                // Create -------------------------- Event for Button start ---------------------------
		letStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                            String s = (String) JOptionPane.showInputDialog(null,
						"Hey !\n" + "\"Input your name?\"",
						"Name_User", JOptionPane.PLAIN_MESSAGE, null,
						null, "Name");    
                            new CommandGame(s);
                            setVisible(false);

			}
                        
		});		

                
    }
}
