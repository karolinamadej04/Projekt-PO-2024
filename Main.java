public class Main {
    public static void main(String[] args){
        Data MojaData = new Data(31,12,2018);
        System.out.println(MojaData.getIndeks(MojaData));
        System.out.println(MojaData.getIndeksLast(MojaData));
        System.out.println(MojaData.przesunDate(MojaData,734));
    }
}
