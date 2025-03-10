import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeContactos {
    private ArrayList<Contacto> listaContacto = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu(){
        int opcion = 1;
        do{
            var menu =
                    """
                    -----------------------------------------------------------
                    Elija una opcion:
                    1- Agregar contacto
                    2- Listar contacto
                    3- Editar contacto
                    4- Eliminar contacto
                    0- Salir
                    """;

            System.out.println(menu);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    listarContacto();
                    break;
                case 3:
                    editarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;


                case 0:
                    System.out.println("""             
                            CERRANDO APP....................
                            """);
                    break;
            }
        }while (opcion != 0);
    }

    public void  agregarContacto (){
        System.out.println("Ingrese Id del contacto");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el nombre del contacto");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el telefono del contacto");
        String telefono = sc.nextLine();


        System.out.println("Ingrese el correo del contacto");
        String correo = sc.nextLine();

       Contacto nuevoContacto = new Contacto(id, nombre,  telefono, correo);
       listaContacto.add(nuevoContacto);

        System.out.println("Contacto Agregado correctamente ");
        System.out.println(nuevoContacto);
    }

    public void listarContacto(){
        if(listaContacto.isEmpty()){
            System.out.println("No hay contactos registrados");
        }else{
            System.out.println("Tareas registradas: ");
            for (Contacto contacto : listaContacto){
                System.out.println("Id: " + contacto.getId()+
                        " | Nombre: " + contacto.getNombre() +
                        " | Telefono: " + contacto.getTelefono() +
                        " | Correo: " + contacto.getCorreo());
                System.out.println("______________________________________________");
            }
        }
    }

    public void editarContacto(){
        //pedimos al usuario que ingrese el contacto que desea editar
        System.out.println("Ingrese el ID del contacto que desea editar");
        int actualizar = sc.nextInt();
        sc.nextLine();


        for(int i = 0; i < listaContacto.size();i++){
            if(listaContacto.get(i).getId() == actualizar){
                Contacto contacto = listaContacto.get(i);
                System.out.println("Contacto encontrado");
                System.out.println(contacto);


                System.out.println("Ingrese nuevo nombre");
                String nuevoNombre = sc.nextLine();
                contacto.setNombre(nuevoNombre);

                System.out.println("Ingrese nuevo telefono");
                String nuevoTelefono = sc.nextLine();
                contacto.setTelefono(nuevoTelefono);


                System.out.println("Ingrese el nuevo correo");
                String nuevoCorreo = sc.nextLine();
                contacto.setCorreo(nuevoCorreo);

                System.out.println("Contacto actualizado correctamente");
                System.out.println(contacto);

            }
        }
    }

    public void eliminarContacto(){
        //pedimos al usuario que ingrese el contacto que desea eliminar
        System.out.println("Ingrese el ID del contacto que desea eliminar");
        int contactoAEliminar = sc.nextInt();
        sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < listaContacto.size(); i++) {
            if (listaContacto.get(i).getId() == contactoAEliminar) {
                System.out.println("Contacto encontrado:");
                System.out.println(listaContacto.get(i));
                listaContacto.remove(i);
                System.out.println("Contacto eliminado con éxito.");
                encontrado = true;
                break; // Salimos del bucle después de eliminar
            }
        }
        if(!encontrado){
            System.out.println("Contacto no encontrado");
        }
    }
}
