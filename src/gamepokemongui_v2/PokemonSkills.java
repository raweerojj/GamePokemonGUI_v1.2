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
public class PokemonSkills{
	private String name;
	private int damage;

	public PokemonSkills(String name, int damage){
		this.name = name;
		this.damage = damage;
	}

	public String getName(){
		return this.name;
	}

	public float getDamage(){
		return this.damage;
	}

	public static PokemonSkills getPokemonSkills(String name){
		PokemonSkills skill = null;
		switch(name.toLowerCase()){
			case "Sky Attack":
				skill = new PokemonSkills("Sky Attack", 40);
				break;
			case "Dragon Tail":
				skill = new PokemonSkills("Dragon Tail", 90);
				break;
			case "Mud Shot":
				skill = new PokemonSkills("Mud Shot", 10);
				break;
			case "Fire Blast":
				skill = new PokemonSkills("Fire Blast", 100);
				break;
		}
		return skill;
	}
}
