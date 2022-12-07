package ClassExamples;

public class Oceanographer {

    public void checkSound(LivesInOcean objectToStudy){
        objectToStudy.makeSound();
    }

    public static void main(String[] args){
        Oceanographer student = new Oceanographer();

        student.checkSound(new Dolphin());
        student.checkSound(new Whale());
    }
}
