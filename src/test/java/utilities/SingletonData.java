package utilities;

public class SingletonData {
    private static SingletonData instancia;
    private String ventanaPrincipal;
    private String ventanaTemporal;

    public static SingletonData get() {
        if (instancia == null) {
            instancia = new SingletonData();
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
        return ventanaTemporal;
    }
    public void setVentanaTemporal(String ventanaTemporal) {
        this.ventanaTemporal = ventanaTemporal;
    }
}

