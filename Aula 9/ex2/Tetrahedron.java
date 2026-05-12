public class Tetrahedron extends ThreeDimensionalShape {
    private double aresta;

    public Tetrahedron(int aresta) {
        this.aresta = (double) aresta;
    }

    public Tetrahedron(double aresta) {
        this.aresta = aresta;
    }

    @Override
    public double getSurfaceArea() {
        // Área total = a² * √3
        return Math.pow(aresta, 2) * Math.sqrt(3);
    }

    @Override
    public double getVolume() {
        // Volume = (a³ * √2) / 12
        return (Math.pow(aresta, 3) * Math.sqrt(2)) / 12;
    }

}