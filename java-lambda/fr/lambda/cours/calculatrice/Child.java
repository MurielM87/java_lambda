package fr.lambda.cours.calculatrice;

public class Child {
    private String prenom;
    private int age;
    private boolean turbulent;

    public Child(String prenom, int age, boolean turbulent) {
        this.prenom = prenom;
        this.age = age;
        this.turbulent = turbulent;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTurbulent() {
        return turbulent;
    }

    public void setTurbulent(boolean turbulent) {
        this.turbulent = turbulent;
    }
}
