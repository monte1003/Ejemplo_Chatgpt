import java.io.*;
import java.util.*;

public class Crud {

    public static List<Tecnico> leerTecnicos() throws IOException {
        List<Tecnico> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("tecnicos.csv"));

        while (sc.hasNextLine()) {
            String[] datos = sc.nextLine().split(",");

            lista.add(new Tecnico(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    datos[2],
                    datos[3],
                    Integer.parseInt(datos[4])
            ));
        }

        sc.close();
        return lista;
    }

    public static void crearTecnico(Tecnico tecnico) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("tecnicos.csv", true));
        bw.write(tecnico.toString());
        bw.newLine();
        bw.close();
    }

    public static void eliminarTecnico(int id) throws IOException {
        int i= 1;
        List<Tecnico> lista = leerTecnicos();
        BufferedWriter bw = new BufferedWriter(new FileWriter("tecnicos.csv"));
        for (Tecnico t : lista) {   

            if (t.getId_tecnico() == id) {
                i = 2;
                t.setActivo(0);
            }
            bw.write(t.toString());
            bw.newLine();
        }
        bw.close();
        if(i == 1){
            System.out.println("El id del técnico que desea eliminar no existe");
        }
    }

    public static Tecnico buscarTecnico(int id) throws IOException {

        List<Tecnico> lista = leerTecnicos();

        for (Tecnico t : lista) {

            if (t.getId_tecnico() == id && t.getActivo() == 1) {
                return t;
            }

        }

        return null;
    }

    public static List<Tecnico> listarTecnicos() throws IOException {

        List<Tecnico> lista = leerTecnicos();
        List<Tecnico> activos = new ArrayList<>();
        
        for (Tecnico t : lista) {

            if (t.getActivo() == 1) {
                activos.add(t);
            }

        }

        return activos;
    }

    public static List<Servicio> leerServicios() throws IOException {

        List<Servicio> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("servicios.csv"));

        while (sc.hasNextLine()) {

            String[] datos = sc.nextLine().split(",");

            lista.add(new Servicio(
                    Integer.parseInt(datos[0]),
                    Integer.parseInt(datos[1]),
                    datos[2],
                    Double.parseDouble(datos[3]),
                    Integer.parseInt(datos[4])
            ));
        }

        sc.close();
        return lista;
    }

    public static void crearServicio(Servicio servicio) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("servicios.csv", true));
        bw.write(servicio.toString());
        bw.newLine();
        bw.close();


    }

    public static List<Servicio> listarServiciosTecnico(int idTecnico) throws IOException {

        List<Servicio> lista = leerServicios();
        List<Servicio> resultado = new ArrayList<>();

        for (Servicio s : lista) {

            if (s.getId_tecnico() == idTecnico && s.getActivo() == 1) {
                resultado.add(s);
            }

        }

        return resultado;
    }

    public static void eliminarServicio(int id) throws IOException {

        List<Servicio> lista = leerServicios();
        BufferedWriter bw = new BufferedWriter(new FileWriter("servicios.csv"));

        for (Servicio s : lista) {

            if (s.getId_servicio() == id) {
                s.setActivo(0);
            }

            bw.write(s.toString());
            bw.newLine();
        }

        bw.close();
    }

    public static List<Servicio> buscarServicioPalabra(String palabra) throws IOException{
        List<Servicio> lista = leerServicios();
        List<Servicio> lista2 = new ArrayList<>();
        for (Servicio s  : lista) {
            if(s.getDescripcion().contains(palabra)){
                lista2.add(s);
            }
        }
        return lista2;
    }

    public static List<Servicio> ordenarMenorMayor() throws IOException{
        List<Servicio> lista = leerServicios();
        Servicio aux;
        for (int i = 0; i < lista.size()-1; i++) {
            for (int j = 0; j < lista.size()-i-1; j++) {
                if(lista.get(j).getCosto() > lista.get(j+1).getCosto()){
                    aux = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, aux);
                }
            }
        }
        return lista;
    }
}