import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        MinHeap minHeap = new MinHeap();
        int opcion;

        do {
            System.out.println("\n===== MENÚ MIN-HEAP =====");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar mínimo");
            System.out.println("3. Ver mínimo (peek)");
            System.out.println("4. Mostrar heap");
            System.out.println("5. Heapify desde una lista");
            System.out.println("6. Ver tamaño");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    int valor = scanner.nextInt();
                    minHeap.insertar(valor);
                    System.out.println("Elemento insertado correctamente.");
                    break;

                case 2:
                    Integer min = minHeap.eliminarMin();
                    if (min == null) {
                        System.out.println("El heap está vacío.");
                    } else {
                        System.out.println("Elemento mínimo eliminado: " + min);
                    }
                    break;

                case 3:
                    Integer raiz = minHeap.peek();
                    if (raiz == null) {
                        System.out.println("El heap está vacío.");
                    } else {
                        System.out.println("El elemento mínimo es: " + raiz);
                    }
                    break;

                case 4:
                    minHeap.mostrarHeap();
                    break;

                case 5:
                    System.out.print("¿Cuántos elementos desea ingresar? ");
                    int n = scanner.nextInt();

                    ArrayList<Integer> datos = new ArrayList<>();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Ingrese el elemento #" + (i + 1) + ": ");
                        datos.add(scanner.nextInt());
                    }

                    minHeap.heapify(datos);
                    System.out.println("Heap construido correctamente a partir de la lista.");
                    break;

                case 6:
                    System.out.println("Tamaño del heap: " + minHeap.tamanio());
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void main(String[] args) {
        menu();
    }
}
