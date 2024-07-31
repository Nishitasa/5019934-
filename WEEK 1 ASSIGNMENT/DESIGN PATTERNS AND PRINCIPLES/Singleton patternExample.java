// SINGLETON PATTERN
public class logger{
    private static logger instance;
    private logger(){}
    
    public static synchronized logger getinstance(){
        if(instance==null){
            instance=new logger();
        }
        return instance;
    }
    public static void msg(){
       System.out.println("Hello logger");
    }
    public static void main(String[] args){
       logger logger1=new logger();
       logger logger2=new logger();
        
        logger1.msg();
        logger2.msg();
    }
    
}