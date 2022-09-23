public class fibonacci {
    public static void main(String[] args) {
        int sum=0,f=1,c=0,temp=0;
        System.out.print(sum+",");
        System.out.print(f+",");
        for(int a=0;a<10;a++){
            c=sum+f;
            sum=f;
            f=c;
            temp=c;
            System.out.print(temp+",");
        }
    }
}
