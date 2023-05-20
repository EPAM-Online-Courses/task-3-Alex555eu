package efs.task.oop;

public abstract class Monster implements Fighter {

    protected int health;
    protected int damage;
    //protected boolean healthStatus;

    public Monster(int health, int damage){
        this.health = health;
        this.damage = damage;
        //this.healthStatus = true;
    };

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    //public boolean isAlive() {
    //    return healthStatus;
    //}
}
