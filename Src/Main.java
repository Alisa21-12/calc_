import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        System.out.print("Ввод: ");
        String string = in.nextLine();
        in.close();
        try {
            string=calc(string);
            System.out.println("Ответ: "+string);
        } catch (IOException e) {
            System.out.println("Throws exception");

}

      //  System.out.println(string);
    }

    public static String calc(String string) throws IOException {

        String[] arabNums={"1","2","3","4","5","6","7","8","9","10"};
        char[] charOfNumbers={'0','1','2','3','4','5','6','7','8','9'};
        String[] romanNums={"I", "II","III","IV","V","VI","VII","VIII", "IX","X"};
        String[] actions={"+","-","*","/"};
        int a=0, b=0; int[] ar={a,b};// Сюда буду записывать введенные числа
        int result=0;
        int j=0; int roman=0; int actCounts=0;
        int action=-1;// С его помощью определяю, какое действие надо выполнить


        if(j==0) {
            int charCount;
            int i = 0;
            while (i < string.length()) {
                charCount = 0;
                while ((i < string.length())) {
                    char charOfNumber = string.charAt(i);
                    int k ;
                    for (k = 0; k < charOfNumbers.length; k++) {
                        if (charOfNumber == charOfNumbers[k]) {
                            charCount++;
                            i++;
                            break;
                        }
                    }
                    if (k == charOfNumbers.length) {
                        i++;
                        break;
                    }
                }
                if(charCount>0){

                        for (int t=0;t<arabNums.length;t++){

                            if(charCount==arabNums[t].length()){
                                int p=string.indexOf(arabNums[t]);

                                if(p==0||p==1){
                                    if (j<ar.length){
                                        ar[j]=t+1;

                                        if(p==0){
                                            string=string.substring(p+charCount);
                                        }
                                        else {
                                            if(p+charCount==string.length()){
                                                string=string.substring(0,p);
                                            }
                                            else {
                                                string=string.substring(0,p)+string.substring(p+charCount);
                                            }
                                        }
                                        j++;
                                        i=0;
                                        charCount=0;
                                        t= arabNums.length;
                                    }
                                }
                            }
                        }
                    }

                }


            }
        if(j==0){
            int charCount;//считает количество знаков в числе
            int i=0;
            roman=1;
            while(i<string.length()){
             charCount=0;
                while ( i<string.length()){
                char charOfNumber=string.charAt(i);
                     if(charOfNumber=='I'||charOfNumber=='V'||charOfNumber=='X'){
                    charCount++;
                    i++;
                    }
                    else{
                        i++;
                        break;
                    }
                }
                    if (charCount>0){
                        for (int k=0;k<romanNums.length;k++){

                            if(charCount==romanNums[k].length()){
                                int p=string.indexOf(romanNums[k]);

                                if(p==0||p==1){
                                    if (j<ar.length){
                                        ar[j]=k+1;

                                        if(p==0){
                                            string=string.substring(p+charCount);
                                        }
                                        else {
                                            if(p+charCount==string.length()){
                                                string=string.substring(0,p);
                                            }
                                            else {
                                                string=string.substring(0,p)+string.substring(p+charCount);
                                            }
                                        }
                                        j++;
                                        i=0;
                                        charCount=0;
                                        k= romanNums.length;
                                    }
                                }
                            }
                        }
                    }
            }
        }


        a=ar[0];
        b=ar[1];
        if(a==0||b==0||string.length()!=1){

            throw new IOException();


        }
        for(int i=0;i<actions.length;i++){
            int p=string.indexOf(actions[i]);
            if(p!=-1){
                actCounts++;//если actCounts не будет равен 1, то будем вызывать исключение
                action=i;// по action будем определять из какой ячейки брать действие
            }
        }
        if (actCounts==0){
            //Выбрасываем исключение
            throw new IOException();
        }
        switch (action) {
            case 0 -> result = a + b;
            case 1 -> result = a - b;
            case 2 -> result = a * b;
            case 3 -> result = a / b;
        }
string="";


        if(roman==1){
            if(result<1){
                //throws exception
                throw new IOException();
            }
int unit;


unit=result/100;
result=result%100;
if(unit == 1){
    string=string+"C";
}
unit=result/10;
switch (unit){
    case 0:
        break;
    case 1:
        string=string+"X";
        break;
    case 2:
        string=string+"XX";
        break;
    case 3:
        string=string+"XXX";
        break;
    case 4:
        string=string+"XL";
        break;
    case 5:
        string=string+"L";
        break;
    case 6:
        string=string+"LX";
        break;
    case 7:
        string=string+"LXX";
        break;
    case 8:
        string=string+"LXXX";
        break;
    case 9:
        string=string+"XC";
        break;
}

result=result%10;

unit=result;
            switch (unit){
                case 0:
                    break;
                case 1:
                    string=string+"I";
                    break;
                case 2:
                    string=string+"II";
                    break;
                case 3:
                    string=string+"III";
                    break;
                case 4:
                    string=string+"IV";
                    break;
                case 5:
                    string=string+"V";
                    break;
                case 6:
                    string=string+"VI";
                    break;
                case 7:
                    string=string+"VII";
                    break;
                case 8:
                    string=string+"VIII";
                    break;
                case 9:
                    string=string+"IX";
                    break;
            }

        }
        else{
            string=Integer.toString(result);
        }






        return string;
    }




}
