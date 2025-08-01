package utilities;

public class SingletonData {
    private static SingletonData instancia;
    private String ventanaPrincipal;
    private String ventanaTemporal;
    private String CorreoSin;
    private String PasswordSin;
    private SingletonData() {

    }
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

    public String getCorreoSin() {
        return CorreoSin;
    }
    public void setCorreoSin(String CorreoSin) {
        this.CorreoSin = CorreoSin;
    }

    public String getPasswordSin() {
        return PasswordSin;
    }
    public void setPasswordSin(String PasswordSin) {this.PasswordSin = PasswordSin;}

    public String getVentanaTemporal() {
        return ventanaTemporal;
    }
    public void setVentanaTemporal(String ventanaTemporal) {
        this.ventanaTemporal = ventanaTemporal;
    }
}

