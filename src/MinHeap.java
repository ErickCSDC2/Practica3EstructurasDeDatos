import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public ArrayList<Integer> getHeap() {
        return heap;
    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }

    public int tamanio() {
        return heap.size();
    }

    private int obtenerPadre(int i) {
        return (i - 1) / 2;
    }

    private int obtenerHijoIzquierdo(int i) {
        return 2 * i + 1;
    }

    private int obtenerHijoDerecho(int i) {
        return 2 * i + 2;
    }

    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insertar(int valor) {
        heap.add(valor);
        upHeapify(heap.size() - 1);
    }

    private void upHeapify(int indice) {
        while (indice > 0) {
            int padre = obtenerPadre(indice);

            if (heap.get(indice) < heap.get(padre)) {
                intercambiar(indice, padre);
                indice = padre;
            } else {
                break;
            }
        }
    }

    public Integer peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    public Integer eliminarMin() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int minimo = heap.get(0);
        int ultimo = heap.remove(heap.size() - 1);
        heap.set(0, ultimo);

        downHeapify(0);

        return minimo;
    }

    private void downHeapify(int indice) {
        while (true) {
            int hijoIzquierdo = obtenerHijoIzquierdo(indice);
            int hijoDerecho = obtenerHijoDerecho(indice);
            int menor = indice;

            if (hijoIzquierdo < heap.size() && heap.get(hijoIzquierdo) < heap.get(menor)) {
                menor = hijoIzquierdo;
            }

            if (hijoDerecho < heap.size() && heap.get(hijoDerecho) < heap.get(menor)) {
                menor = hijoDerecho;
            }

            if (menor != indice) {
                intercambiar(indice, menor);
                indice = menor;
            } else {
                break;
            }
        }
    }

    public void heapify(ArrayList<Integer> datos) {
        heap = new ArrayList<>(datos);

        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    public void mostrarHeap() {
        if (heap.isEmpty()) {
            System.out.println("El montículo está vacío.");
        } else {
            System.out.println("Contenido del heap: " + heap);
        }
    }
}