public class Servicio {

    private int id_servicio;
    private int id_tecnico;
    private String descripcion;
    private double costo;
    private int activo;

    public Servicio(int id_servicio, int id_tecnico, String descripcion, double costo, int activo) {
        this.id_servicio = id_servicio;
        this.id_tecnico = id_tecnico;
        this.descripcion = descripcion;
        this.costo = costo;
        this.activo = activo;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id_servicio + "," + id_tecnico + "," + descripcion + "," + costo + "," + activo;
    }
}