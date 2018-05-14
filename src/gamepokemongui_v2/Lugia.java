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
public class Lugia extends Pokemon implements Flyable {
    private static final int maxGroupHealth = 400;
    public Lugia() {
		super("Lugia",
		      (int) Math.floor(Math.random() * 501)+100,(int) Math.floor(Math.random() * 21)+ 40);

		this.attackSkill = PokemonSkills.getPokemonSkills("Sky Attack");
                this.untimatedSkill = PokemonSkills.getPokemonSkills("Dragon Tail");
	}

    public void fly() {
        this.reducedWeight(1.5);
    }

    public void move() {
       this.fly();
    }
 
}