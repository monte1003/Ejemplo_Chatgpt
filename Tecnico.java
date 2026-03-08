public class Tecnico {

    private int id_tecnico;
    private String nombre;
    private String especialidad;
    private String telefono;
    private int activo;

    public Tecnico(int id_tecnico, String nombre, String especialidad, String telefono, int activo) {
        this.id_tecnico = id_tecnico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return id_tecnico + "," + nombre + "," + especialidad + "," + telefono + "," + activo;
    }
}