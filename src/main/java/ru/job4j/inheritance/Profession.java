package ru.job4j.inheritance;

public class Profession {
    private boolean degree;

    public Profession(boolean degree) {
        this.degree = degree;
    }

    public class Engineer extends Profession {
        private int experience;

        public Engineer(int experience, boolean degree) {
            super(degree);
            this.experience = experience;
        }
    }

    public class Programmer extends Engineer {

        private String programLang;

        public Programmer(String programLang, int experience, boolean degree) {
            super(experience, degree);
            this.programLang = programLang;
        }
    }
}
