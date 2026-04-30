public class TesteClasses {
    public static void main(String[] args) {
        Animal animal = new Animal(0, "Genérico");
        Cachorro cachorro = new Cachorro("Rex");
        Gato gato = new Gato("Mia");
        Ave ave = new Ave("Tico", 4, 21);
        Reptil reptil = new Reptil("Kaa", 10, 60);
        Ornitorrinco ornitorrinco = new Ornitorrinco("Perry", 3, 10);

        System.out.println("Animal: " + animal.getNome() + ", Patas: " + animal.getPatas());
        System.out.println("Cachorro: " + cachorro.getNome() + ", Patas: " + cachorro.getPatas()
                + ", Lactante: " + ((Lactante) cachorro).produzirLeite());
        System.out.println("Gato: " + gato.getNome() + ", Patas: " + gato.getPatas()
                + ", Lactante: " + ((Lactante) gato).produzirLeite());
        System.out.println("Ave: " + ave.getNome() + ", Patas: " + ave.getPatas()
                + ", Ovos por postura: " + ave.getNumeroOvosPorPostura()
                + ", Incubação: " + ave.getTempoIncubacaoDias() + " dias");
        System.out.println("Reptil: " + reptil.getNome() + ", Patas: " + reptil.getPatas()
                + ", Ovos por postura: " + reptil.getNumeroOvosPorPostura()
                + ", Incubação: " + reptil.getTempoIncubacaoDias() + " dias");
        System.out.println("Ornitorrinco: " + ornitorrinco.getNome() + ", Patas: " + ornitorrinco.getPatas()
                + ", Ovos por postura: " + ornitorrinco.getNumeroOvosPorPostura()
                + ", Incubação: " + ornitorrinco.getTempoIncubacaoDias() + " dias"
                + ", Lactante: " + ornitorrinco.produzirLeite());
    }
}
