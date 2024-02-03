public class Main {
    public static void main(String[] args){
        Data MojaData = new Data(31,12,2018);
        Data Mojadata2= new Data(31,12,2019);
        System.out.println(MojaData.getIndeks(MojaData));
        System.out.println(MojaData.getIndeksLast(MojaData));
        System.out.println(MojaData.przesunDate(MojaData,2).ddmmyyyy());
        System.out.println(MojaData.przesunDate(MojaData,2).ddmmyyyyLong());
        System.out.println(MojaData.przesunDate(MojaData,2).mmddyyyy());
        System.out.println(MojaData.przesunDate(MojaData,2).mmddyyyyLong());
        System.out.println(MojaData.dodajMiesiace(MojaData,13).ddmmyyyyLong());
        System.out.println((MojaData.roznicaDat(MojaData,Mojadata2)));
        DataGUI dataGUI=new DataGUI();
        dataGUI.setVisible(true);
    }
}