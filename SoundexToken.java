package Default;

public class SoundexToken {

    public static void main(String[] args){


    getSoundex("rad");

    }

    public static void getSoundex(String tr){

        String soundexCode = ""; // init soudexcode
        String formattedTerm = tr.replaceAll("[^a-zA-Z0-9]", ""); // format input term, only letter + number
        formattedTerm.toLowerCase();

        char[] charTerm = formattedTerm.toCharArray();  // string to char array
        char fLetter = charTerm[0];

        for (int i = 1; i < formattedTerm.length(); i++) {

            char letter = charTerm[i];      // get each char

            switch(letter){     // switch case to get token
                case 'a':case 'e':case 'h':case 'i':case 'o':case 'u':case 'w':case 'y':
                    letter = '0';
                    break;
                case 'b':case 'f':case 'p':case 'v':
                    letter = '1';
                    break;
                case 'c':case 'g':case 'j':case 'k':case 'q':case 's':case 'x':case 'z':
                    letter = '2';
                    break;
                case 'd':case 't':
                    letter = '3';
                    break;
                case 'l':
                    letter = '4';
                    break;
                case 'm':case 'n':
                    letter = '5';
                    break;
                case 'r':
                    letter = '6';
                    break;
            }

            charTerm[i] = letter;       // replace old char with code
        }

        String output = "" + fLetter;

        for (int i = 1; i < charTerm.length; i++)
            if (charTerm[i] != charTerm[i - 1] && charTerm[i] != '0')
                output += charTerm[i];

        String term = new String(charTerm);     // char array to string
        System.out.println(term);               // print code for full char array
        System.out.println(output);             // print code with no double, no 0

        output = output + "0000";               // add 4 0s at the end, make it more than 4 digits

        soundexCode = output.substring(0,4);    // turncat to 4 digita

        System.out.println("soundex token: " + soundexCode);        // print code with formating

    }
}
