
public class ChatBotResponse extends ChatBot{
  String[][] array = {
    {"Hello","Hola","Greetings","What's up","Herro","yo","hey","hey ya","I am not a llama","Good Day"}, //Greetings
    {"it wasn't lame-a!","one day I saw a llama","my friends were alpacas","we dropped mercury","I'm failing my AP CS class"}, //School
    {"trained dinosaurs","fought trains","slept on a rock","took AP CS last year","played board games"}, //Sibling
    {"a huge balloon over the skyscrapers","a troll on the bridge","a flying dog","my red pupilpath grade"}, //Borough
  };
  public ChatBotResponse(String str){
    super(str);
  }
  public String getGreetings(){
    return array[0][(int)(Math.random()*array[0].length)]; //Greeting array in the 2d array with a random index
  }
  public String getSchool(){
    return "I went to alpaca school and "+array[1][(int)(Math.random()*array[1].length)]; //School array in the 2d array with a random index
  }
  public String getSibling(){
    return "My alpaca "+ str+" "+array[2][(int)(Math.random()*array[2].length)]; //Sibling array in the 2d array with a random index
  }
  public String getBorough(){
    return "I live in "+str+" ! I saw "+array[3][(int)(Math.random()*array[3].length)]; //Borough array in the 2d array with a random index
  }
}