package utilities;

public class MovEntreVentanas {
    private static MovEntreVentanas instancia;
    private String ventanaPrincipal;
    private String ventanaTMP;

    public static MovEntreVentanas get() {
        if (instancia == null) {
            instancia = new MovEntreVentanas();
        }
        return instancia;
    }
    public String getVentanaPrincipal() {
        return ventanaPrincipal;
    }
    public void setVentanaPrincipal(String ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    public String getVentanaTemporal() {
        return ventanaTMP;
    }
    public void setVentanaTemporal(String ventanaTMP) {
        this.ventanaTMP = ventanaTMP;
    }
}

