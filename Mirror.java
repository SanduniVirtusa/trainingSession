import java.util.*;
public class Mirror {
    String input;
    int index = 0;
    int indexMax = 0;
    int index2 = 0;
    int indexMax2 = 0;
    ArrayList al = new ArrayList();
    ArrayList al2 = new ArrayList();
    int count=0;
    ArrayList mirrors = new ArrayList();

    public void checkMirror() {
        if (this.al.get(0) == this.al2.get(2) && this.al.get(1) == this.al2.get(1) && this.al.get(2) == this.al2.get(0)) {
	ArrayList mirror= new ArrayList();
	mirror.addAll(this.al);
	mirror.addAll(this.al2);
	String mir="";
	for(int i=0;i<mirror.size();i++){
		mir=mir+mirror.get(i);
	}
	this.mirrors.add(mir);  
         count++;           
        }
    }

    public void changeArrayList(int a,int b) {
        al.remove(0);
        al2.remove(0);
        al.add(this.input.charAt(a));
        al2.add(this.input.charAt(b));
        this.checkMirror();
    }

    public void startToCheck(String input) {
        this.input=input;
        for (int i = 0; i < this.input.length(); i++) {
            if(i<3){
                char value = input.charAt(i);
                this.al.add(value);
            }
            else if(i<6){
                char value = input.charAt(i);
                this.al2.add(value);
                if(al.size()==3&& al2.size()==3){
                    this.checkMirror();
                }
            }
            else if(indexMax2!=this.input.length()){
                int value=i-3; 
                this.changeArrayList(value,i);
            }
        }
    }

    public static void main(String[] args) {
        Mirror mr = new Mirror();
	Scanner s= new Scanner(System.in);
	System.out.println("Enter a string");
        mr.input=s.nextLine();
	mr.startToCheck(mr.input);
        System.out.println("Count of Mirrors = "+mr.count);
	System.out.println("Mirror List= "+mr.mirrors);
    }
}
