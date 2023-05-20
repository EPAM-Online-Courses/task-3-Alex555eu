package efs.task.oop;

public class Monsters {

    static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            if(getHealth() - damage <= 0) {
                monstersHealth -= getHealth();
                setHealth(0);
                //healthStatus = false;
            }
            monstersHealth -= damage;
            setHealth(getHealth() - damage);
        }
    };

    static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            if(getHealth() - damage <= 0) {
                monstersHealth -= getHealth();
                setHealth(0);
                //healthStatus = false;
            }
            monstersHealth -= (damage + 5);
            setHealth(getHealth() - (damage + 5));
        }
    };

    private static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    public static int getMonstersHealth() {
        return monstersHealth;
    }

}
