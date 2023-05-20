package efs.task.oop;

public class ExtraordinaryVillager extends Villager {

    protected Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old. " + skill.getSkillDesc());
    }

    @Override
    public void attack(Fighter victim) {
        victim.takeHit(0);
    }

    @Override
    public void takeHit(int damage) {
        this.health = 0;
        //this.healthStatus = false;
    }

    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        protected String skillDesc;

        Skill(String skillDesc) {
            this.skillDesc = skillDesc;
        }

        public String getSkillDesc() {
            return skillDesc;
        }

    }

}
