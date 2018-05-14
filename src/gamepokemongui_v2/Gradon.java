/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepokemongui_v2;

/**
 *
 * @author rebor
 */
public class Gradon extends Pokemon implements Runnable{
	private static final int maxGroupHealth = 500;
	public Gradon(){
		super("Gradon",
		      (int) Math.floor(Math.random() * 501)+ 100,(int) Math.floor(Math.random() * 21) + 40);

		this.attackSkill = PokemonSkills.getPokemonSkills("Mud Shot");
		this.untimatedSkill = PokemonSkills.getPokemonSkills("Fire Blast");
	}

	public void move(){
		this.run();
	}

	public void run(){
		this.reducedWeight(2.5);
	}

	public void walk(){
		this.reducedHealth(2);
	}

}
