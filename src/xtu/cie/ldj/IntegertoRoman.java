package xtu.cie.ldj;

public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        String[][] array = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
        		{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        		{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}};
        for(int i = num / 1000;i > 0; i--){
        	str.append("M");
        }
        str.append(array[2][(num % 1000)/100]);
        str.append(array[1][(num % 100)/10]);
        str.append(array[0][num % 10]);
        
        return str.toString();
    }
}
