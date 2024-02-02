public class Data {
    private int dzien;
    private int miesiac;
    private int rok;

    public Data(int dzien, int miesiac, int rok){
        this.dzien=dzien;
        this.miesiac=miesiac;
        this.rok=rok;
    }
    public int getIndeks(Data MojaData){
        int[] tab = {31,28,31,30,31,30,31,31,30,31,30,31};
        int indeks=0;
        for(int i=1; i<MojaData.miesiac; i++){
            indeks=indeks+tab[i-1];
        }
        indeks=indeks+ MojaData.dzien;
        if(leapYearCheck(MojaData.rok)==true && indeks>59) indeks++;    // rok przystępny
        return indeks;
    }
    public int getIndeksLast(Data MojaData){
        int indeks;
        if(leapYearCheck(MojaData.rok)==true) indeks=366-getIndeks(MojaData)+1;
        else indeks=365-getIndeks(MojaData)+1;
        return indeks;
    }
    private Data indeksNaDate(int indeks, int yearLoc){
        int monthLoc=1;                //miesiac lokalny w funkcji
        int dayLoc;                    //dzien lokalny w funkcji
        int[] tabNorm = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] tabPrzys = {31,29,31,30,31,30,31,31,30,31,30,31};
        int[] tab;
        if(leapYearCheck(yearLoc)) tab=tabPrzys;
        else tab=tabNorm;
        for(int i=0;i<12;i++){
            if(indeks-tab[i]>0){
                indeks=indeks-tab[i];
                monthLoc++;
            }
        }
        dayLoc=indeks;
        Data nowaData=new Data(dayLoc,monthLoc,yearLoc);
        return nowaData;
    }
    public boolean leapYearCheck(int year){
        if(year%4==0) return true;
        else return false;
    }
    public String przesunDate(Data dataPoczatkowa, int liczbaDni){
        if(liczbaDni<getIndeksLast(dataPoczatkowa)){
            return przesunTenSamRok(liczbaDni,dataPoczatkowa).toString();
        }
        else if ((liczbaDni<getIndeksLast(dataPoczatkowa) +365 && leapYearCheck(dataPoczatkowa.rok+1)==false) || (liczbaDni<getIndeksLast(dataPoczatkowa) +366 && leapYearCheck(dataPoczatkowa.rok+1)==true)){
            return przesunNastepnyRok(liczbaDni,dataPoczatkowa).toString();
        }
        else return przesunKilkaLat(liczbaDni,dataPoczatkowa).toString();
    }

    private Data przesunTenSamRok(int iloscDni, Data dataPoczatkowa){
        int indeksKoncowy=getIndeks(dataPoczatkowa)+iloscDni;
        Data dataKoncowa=indeksNaDate(indeksKoncowy,dataPoczatkowa.rok);
        //System.out.println("Ten sam rok");
        return dataKoncowa;
    }

    private Data przesunNastepnyRok(int iloscDni, Data dataPoczatkowa){
        iloscDni=iloscDni-getIndeksLast(dataPoczatkowa)+1;
        Data dataKoncowa=indeksNaDate(iloscDni, dataPoczatkowa.rok+1);
        //System.out.println("Nastepny rok");
        return dataKoncowa;
    }
    private Data przesunKilkaLat(int iloscDni, Data dataPoczatkowa){
        int rokKoncowy= dataPoczatkowa.rok;
        Data dataKoncowa;
        iloscDni=iloscDni-getIndeksLast(dataPoczatkowa)+1;
        rokKoncowy++;
        boolean kontynuuj=true;
        while (kontynuuj){
            if(leapYearCheck(rokKoncowy) && iloscDni>366){
                iloscDni=iloscDni-366;
                rokKoncowy++;
                //System.out.println("Skok przystepny, zostalo "+iloscDni);
            }
            else if(!leapYearCheck(rokKoncowy) && iloscDni>365){
                iloscDni=iloscDni-365;
                rokKoncowy++;
                //System.out.println("Skok zwykly, zostalo "+iloscDni);
            }
            else{
                if (leapYearCheck(rokKoncowy) && iloscDni<=366)
                {kontynuuj=false;}
                else if (!leapYearCheck(rokKoncowy) && iloscDni<=365)
                {kontynuuj=false;}
            }
        }

        dataKoncowa= indeksNaDate(iloscDni,rokKoncowy);
        return dataKoncowa;
    }
    public String toString(){
        String locDzien;
        String locMiesiac;
        if(dzien<10) locDzien="0"+dzien;
        else locDzien=""+dzien;
        if(miesiac<10) locMiesiac="0"+miesiac;
        else locMiesiac=""+miesiac;
        return locDzien+"/"+locMiesiac+"/"+rok;
    }
}
