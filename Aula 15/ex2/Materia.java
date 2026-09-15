public class Materia {
    private String nome;
    private double p1, p2, p3, p4, t1, t2;
    private int faltas;

    public Materia(String nome, double p1, double p2, double p3, double p4,
                   double t1, double t2, int faltas) {
        this.nome = nome;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.t1 = t1;
        this.t2 = t2;
        this.faltas = faltas;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getP1() { return p1; }
    public void setP1(double p1) { this.p1 = p1; }

    public double getP2() { return p2; }
    public void setP2(double p2) { this.p2 = p2; }

    public double getP3() { return p3; }
    public void setP3(double p3) { this.p3 = p3; }

    public double getP4() { return p4; }
    public void setP4(double p4) { this.p4 = p4; }

    public double getT1() { return t1; }
    public void setT1(double t1) { this.t1 = t1; }

    public double getT2() { return t2; }
    public void setT2(double t2) { this.t2 = t2; }

    public int getFaltas() { return faltas; }
    public void setFaltas(int faltas) { this.faltas = faltas; }

    public double calcularMP() {
        return (p1 + p2 + p3 + p4) / 4.0;
    }

    public double calcularMT() {
        return (t1 + t2) / 2.0;
    }

    public double calcularMF() {
        return (calcularMP() + calcularMT()) / 2.0;
    }
}