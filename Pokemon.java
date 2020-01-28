import java.util.Scanner;
import java.util.Random;

class Monster {
	private String name;
	private int damage;
	private int health;
	
	public Monster(String name, int damage, int health) {
		this.name = name;
		this.damage = damage;
		this.health = health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public String getName() {
		return this.name;
	}
	public int getDamage() {
		return this.damage;
	}
	public int getHealth() {
		return this.health;
	}
}

class Pokemon {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		Monster enemy = new Monster("Mewtwo", 0, 100);
		Monster hero = new Monster("Raichu", 0, 100);
			
		while(enemy.getHealth() > 0 && hero.getHealth() > 0) {
			System.out.println("-------------------");
			System.out.println(hero.getName() + "'s Health " + hero.getHealth());
			System.out.println(enemy.getName() + "'s Health " + enemy.getHealth());
			System.out.println("Choose a Skill: ");
			System.out.println("A. Thunderbolt");
			System.out.println("B. Tail Swing");
			System.out.println("C. Head Hammer");
			System.out.println("^^^^^^^^^^^^^^^^^^^");
			System.out.print("Choice: ");
			char option = scan.nextLine().charAt(0);
			
			switch(option){
				case 'a': case 'A': hero.setDamage(30); break;
				case 'b': case 'B': hero.setDamage(20); break;
				case 'c': case 'C': hero.setDamage(40); break;
				default:
			}
			enemy.setHealth(enemy.getHealth()- hero.getDamage());
			System.out.println("--------------------");
			System.out.println(enemy.getName() + " received " + hero.getDamage() + " damage.");
				
			enemy.setDamage((random.nextInt(2) +1) * 10);
			if(enemy.getHealth() < 300) {
				enemy.setDamage(enemy.getDamage() * 2);
			}
			hero.setHealth(hero.getHealth() - enemy.getDamage());
			System.out.println(hero.getName() + " received " + enemy.getDamage() + " damage.");
		}
		String faint = hero.getHealth() > enemy.getHealth() ? enemy.getName() : hero.getName();
		System.out.println(faint+ " fainted.");
	}
}