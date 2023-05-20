package efs.task.oop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // mozliwy problem z kolejnoscia ??
        Villager akaraRegular = new Villager("Akara", 40);
        Villager deckardCainRegular = new Villager("Deckard Cain", 85);
        Villager kashya = new Villager("Kashya", 30);
        Villager gheed = new Villager("Gheed", 50);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        akaraRegular.sayHello();
        deckardCainRegular.sayHello();
        kashya.sayHello();
        gheed.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);

        deckardCain.sayHello();
        akara.sayHello();

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;

        List<Villager> villagers = new ArrayList<>();
        villagers.add(akara);
        villagers.add(deckardCain);
        villagers.add(kashya);
        villagers.add(gheed);
        villagers.add(warriv);
        villagers.add(flawia);

        Monsters monsters = new Monsters();
        Monster fightingMonster;
        int currentlyFightingVillager = 0;

        while(monsters.getMonstersHealth() > 0 && currentlyFightingVillager < villagers.size()) { // mozliwy bug, gdy bijemy jednego potwora, suma damage'u moze nie rowno sie rozlozyc
            //if(!villagers.get(currentlyFightingVillager).isAlive()) {                               // skutek - jeden z potworow nadal zywy, choc getMonsterHealth wskazuje inaczej
            if(!(villagers.get(currentlyFightingVillager).getHealth() > 0)) {
                currentlyFightingVillager++;
                continue;
            }

            //if(monsters.andariel.isAlive()) {
            if(monsters.andariel.getHealth() > 0) {
                fightingMonster = monsters.andariel;
            }
            else {
                fightingMonster = monsters.blacksmith;
            }

            fightStatus(villagers.get(currentlyFightingVillager), monsters);

            villagers.get(currentlyFightingVillager).attack(fightingMonster);
            fightingMonster.attack(villagers.get(currentlyFightingVillager));


        }

        System.out.println("Obozowisko ocalone!");

        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;


    }

    public static void fightStatus(Villager villager, Monsters monsters) {
        System.out.println("Potwory posiadaja jeszcze " + monsters.getMonstersHealth() + " punkty zycia" + System.lineSeparator() + "Aktualnie walczacy osadnik to " + villager.getName());
    }

}
