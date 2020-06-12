import java.util.ArrayList;
import java.util.List;

class Angle {
    int degrees;
    int minutes;
    int seconds;

    public Angle(int degrees, int minutes, int seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public static List<Integer> function(List<Angle> angleList) {
        List<Integer> result = new ArrayList<>();  // 1

        for (int i = 0; i < angleList.size(); i++) { //2
            int deg = angleList.get(i).getDegrees();  //3
            int min = angleList.get(i).getMinutes();
            int sec = angleList.get(i).getSeconds();
            if (deg >= 0 && deg < 360) {   //4
                if (min < 0 || min > 59)   //5
                    throw new RuntimeException("The minutes of the angle are not valid!");  //6
                else {   //7
                    if (sec < 0 || sec > 59)    //8
                        throw new RuntimeException("The seconds of the angle are not valid");   //9
                    else  //10
                        result.add(deg * 3600 + min * 60 + sec);  //11
                }
            } else if (deg == 360) {  //12
                if (min == 0 && sec == 0) //13
                    result.add(deg * 3600 + min * 60 + sec); //14
                else  //15
                    throw new RuntimeException("The angle is greater then the maximum"); //16
            } else {  //17
                throw new RuntimeException("The angle is smaller or greater then the minimum"); //18
            }
        }
        return result; //19

    } //20
}