import java.util.*;
public class Main{
    public static void main(String[] args) {
        int op = 1;
        Scanner sc = new Scanner(System.in);
        do{
            try{
            System.out.println("\n**MENÚ DE OPCIONES**");
            System.out.println("1) Registrar técnico\n2) Listar técnicos\n3) Eliminar técnico\n4) Registrar servicio\n5)Listar servicios de un técnico\n6) Buscar servicio por descripción\n7) Ordenar servicios por costo\n8)Salir");
            System.out.print("Ingrese opción: ");
            op = sc.nextInt();
            int id_tecnico;
            switch (op) {
                case 1:
                    System.out.println("\n**REGISTAR TÉCNICO**");
                    String nombre, especialidad, telefono;
                    System.out.print("- Ingrese id del técnico: ");
                    id_tecnico = sc.nextInt();
                    sc.nextLine();
                    System.out.print("- Ingrese nombre del técnico: ");
                    nombre = sc.nextLine();
                    System.out.print("- Ingrese especialidad del técnico: ");
                    especialidad = sc.nextLine();
                    System.out.print("- Ingrese teléfono del técnico: ");
                    telefono = sc.nextLine();
                    Tecnico tecnico = new Tecnico(id_tecnico, nombre, especialidad, telefono, 1);
                    Crud.crearTecnico(tecnico);
                    break;
                
                case 2:
                    List<Tecnico> lista = Crud.leerTecnicos();
                    System.out.println("\n**LISTA DE TÉCNICOS**");
                    for(Tecnico tecnico1 : lista){
                        System.out.println("\n"+tecnico1.toString());
                    }
                    break;
                
                case 3:
                    int id_eliminar;
                    System.out.println("\n**ELIMINAR TÉCNICO**");
                    System.out.print("Ingrese el id del técnico que desea eliminar: ");
                    id_eliminar = sc.nextInt();
                    Crud.eliminarTecnico(id_eliminar); 
                    break;
                
                case 4:
                    int id_servicio;
                    String descripcion;
                    double costo;
                    System.out.println("\n**REGISTAR SERVICIO**");
                    System.out.print("Ingrese id del servicio: ");
                    id_servicio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese id del técnico asociado al servicio: ");
                    id_tecnico = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese descripción del servicio: ");
                    descripcion = sc.nextLine();
                    System.out.print("Ingrese costo: ");
                    costo = sc.nextDouble();
                    Servicio servicio = new Servicio(id_servicio, id_tecnico, descripcion, costo, 1);
                    Crud.crearServicio(servicio); 
                    break;
                
                case 5:
                    System.out.println("\n**LISTAR SERVICIOS DE UN TÉCNICO**");
                    System.out.print("Introduzca el id del técnico: ");
                    id_tecnico = sc.nextInt();
                    List<Servicio> lista2 = Crud.listarServiciosTecnico(id_tecnico);
                    for (Servicio s : lista2) {
                        System.out.println("\n"+s.toString());
                    }
                    break;
                case 6:
                    System.out.println("\n**BUSCAR SERVICIO POR PALABRA CLAVE**");
                    System.out.print("Introduzca la palabra clave: ");
                    String p = sc.nextLine();
                    List<Servicio> s1 = Crud.buscarServicioPalabra(p);
                    for (Servicio s  : s1) {
                        System.out.println("\n"+s.toString());
                    }
                    break;

                case 7:
                    System.out.println("\n**ORDENAR SERVICIOS POR COSTO (MENOR A MAYOR)");
                    List<Servicio> s2 = Crud.ordenarMenorMayor();
                    for(Servicio s3 : s2){
                        System.out.println("\n"+s3.toString());
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                }        
            }catch(Exception e){
                System.out.println("\nError: "+e.getMessage());
            }
        } while(op!=8);
    }
}