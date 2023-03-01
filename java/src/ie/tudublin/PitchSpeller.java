package ie.tudublin;

public class PitchSpeller {
    float[] frequencies = {
        //4
        293.66f, //d4
        329.63f, //e4
        369.99f, //f4#
        392.00f, //g4
        440.00f, //a4
        493.88f, //b4
        //5
        554.37f, //c5#
        587.33f, //d5
        659.25f, //e5
        739.99f, //f5#
        783.99f, //g5
        880.00f, //a5
        987.77f, //b5
        //6
        1108.73f, //c6#
        1174.66f, //d6
        1318.5f, //e
        1480.0f, //f
        1568.0f, //g
        1760.0f, //a
        1975.5f, //b
        //7
        2217.5f, //c
        2349.3f, //d
        2637.0f, //e
        2960.0f, //f
        3136.9f, //g
        3520.0f, //a
        3951.1f, //b
        //8
        4434.9f, //c8
        4698.6f //d8
    };
    String[] spellings = {
        "D,", 
        "E,", 
        "F,", 
        "G,", 
        "A,", 
        "B,", 
        //5
        "C", 
        "D", 
        "E", 
        "F", 
        "G", 
        "A", 
        "B",
        //6
        "c", 
        "d", 
        "e", 
        "f", 
        "g", 
        "a", 
        "b", 
        //7
        "c'", 
        "d'",
        "e'", 
        "f'", 
        "g'", 
        "a'", 
        "b'", 
        //8
        "c''", 
        "d''"};
   
    public String spell(float frequency) {
        return "";
    }
}
