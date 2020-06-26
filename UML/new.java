class Rachunek {
    public Date data;
    public Set<UdzialWPlatnosci> wplaty;
    public Set<PozycjaRachunku> pozycje;
    public Set<UdzialWPlatnosci> obliczNaleznosci() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
     public Set<Osoba> osobyNaRachunku() {
        Set<Osoba> osoby = new HashSet<Osoba>();
        for(PozycjaRachunku p : this.pozycje)
            for(UdzialWPozycjiRachunku u : p.udzial)
               osoby.add(u.konsument);
        return osoby;
    }
}

class PozycjaRachunku {
    PozycjaRachunku(String nowaNazwa, double nowaCena) {
        this.nazwa=nowaNazwa;
        this.cena=nowaCena;
    }
    public String nazwa;
    public double cena;
    public Set<UdzialWPozycjiRachunku> udzial;
}

class UdzialWPozycjiRachunku {
    UdzialWPozycjiRachunku(double nowaNaleznosc, Osoba nowyKonsument) {
        this.naleznosc = nowaNaleznosc;
        this.konsument = nowyKonsument;
    }
    public double naleznosc;
    public Osoba konsument;
}

class UdzialWPlatnosci {
    UdzialWPlatnosci(double nowaKwota, Osoba nowyPlacacy) {
        this.kwota=nowaKwota;
        this.placacy=nowyPlacacy;
    }
    public double kwota;
    public Osoba placacy;
}

class Osoba {
    Osoba(String noweImie, String noweNazwisko) {
        this.imie=noweImie;
        this.nazwisko=noweNazwisko;
    }
    public String imie;
    public String nazwisko;
    public boolean equals(Object o) {
        return (o instanceof Osoba) &&
                (this.imie.equals(((Osoba)o).imie)) &&
                (this.nazwisko.equals(((Osoba)o).nazwisko));
    }
    public int hashCode() {
        return (this.imie.length() << 4) | this.nazwisko.length();
    }
    public String toString() {
        return '[' + this.imie + ',' + this.nazwisko + ']';
    }
}