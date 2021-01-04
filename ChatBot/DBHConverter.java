public class DBHConverter extends ChatBot{
    private int dec, bi, hex, hexCount;
    public DBHConverter(String str, int d, int b, int h) {
      super(str);
      dec = d;
      bi = b;
      hex = h;
    }
    //Decimal to Binary
    public int getBinaryFromDecimal(int input){
      String convertString = "";
      int binOne, add = 0;
      while(input>0){
        binOne = input % 2;
        if(binOne == 1){
          add++;
        }
        input /= 2;
        convertString = binOne + convertString;
      }
      bi = Integer.parseInt(convertString);
      return bi;
    }
    public int setBinaryFromDecimal() {
      getBinaryFromDecimal(dec);
      return bi;
    }
    //Binary to Decimal
    public int getDecimalFromBinary(int input){
      int power =0;
      while(input>0){
        dec+=((input%10)*Math.pow(2,power));
        input/=10;
        power++;
      }
      return dec;
    }
    //Decimal to Hex
    public String getHexFromDecimal(int input){
      String hexStr = "0123456789ABCDEF";
      String hex = "";
      int temp = 0;
      while(input>0){
        temp = input%16;
        input/=16;
        char hexA = hexStr.charAt(temp);
        hex = hexA + hex;
      }
      return hex;
    }
    //Binary to Hex
    public String getBinaryFromHex(int input){
      return getHexFromDecimal(dec);
    }
    public int replaceHexChar(char c){
      int num = 0;
      if(Character.isLetter(c)){
        if(c == 'a' || c == 'A'){
          return num+=10;
        }
        if(c == 'b' || c == 'B'){
          return num+=11;
        }
        if(c == 'c' || c == 'C'){
          return num+=12;
        }
        if(c == 'd' || c == 'D'){
          return num+=13;
        }
        if(c == 'e' || c == 'E'){
          return num+=14;
        }
        if(c == 'f' || c == 'F'){
          return num+=15;
        }
      }
      if(Character.isDigit(c)){
        return num+=Character.getNumericValue(c);
      }
      return num;
    }
    //Hex Conversion
    public int getDecimalFromHex(String str){
      int power = 0, dec = 0, i=str.length()-1;
      while(i>-1){
        char ch = str.charAt(i);
        dec += replaceHexChar(ch)*Math.pow(16,power);
        power++;
        i--;
      }
      return dec;
    }
    
  }