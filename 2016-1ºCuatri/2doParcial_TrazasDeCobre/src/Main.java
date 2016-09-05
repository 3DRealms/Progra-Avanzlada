import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Main {

    public Map<Integer, Integer> solve(String in) {
        if (in == null || in.trim().isEmpty()) {
            return new HashMap<Integer, Integer>();
        }

        // Cargo la cola con implementación de lista circular
        Node queue = new Node();
        Node first = null;
        int i = 1;
        for (char component : in.toCharArray()) {
            Node node = new Node(component, i, queue);
            if (i == 1) {
                first = node;
            }
            queue = node;
            i++;
        }
        first.setNext(queue);

        // Numero de componentes analizados. Una vez que llego al máximo dejo de probar conexiones.
        int laps = 0;
        Map<Integer, Integer> connections = new HashMap<Integer, Integer>();
        while (laps < in.length()) {
            // Ir al primer control encontrado de atras hacia adelante
            Node check = queue;
            while (queue.isLed()) {
                queue = queue.next();
                if (queue.equals(check)) {
                    return new HashMap<Integer, Integer>(); // No hay controles
                }
            }
            Node match = null;
            Node aux = queue.next();
            // Mientras haya siguiente (el componente no sea él mismo)...
            while (!queue.equals(aux)) {
                // ...si es led
                if (aux.isLed()) {
                    // ...es una posible conexión
                    match = aux;
                }
                aux = aux.next();
            }
            // Si ninguno de los dos componentes fue utilizado previamente...
            if (queue.isNotUsed() && match != null && match.isNotUsed()) {
                connections.put(queue.getIndex(), match.getIndex());
                queue.use();
                match.use();
            }
            laps++;
            queue = queue.next();
        }

        return connections;
    }

    @Test
    public void loteUno() {
        // Given
        String in = "LLLLCCCLC";

        // When
        Map<Integer, Integer> connections = solve(in);

        // Then
        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    public void loteVacio() {
        // Given
        String in = "";

        // When
        Map<Integer, Integer> connections = solve(in);

        // Then
        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    public void loteSinLeds() {
        // Given
        String in = "CCCC";

        // When
        Map<Integer, Integer> connections = solve(in);

        // Then
        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    public void loteSinControles() {
        // Given
        String in = "LLLL";

        // When
        Map<Integer, Integer> connections = solve(in);

        // Then
        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    public void unicoPar() {
        // Given
        String in = "CL";

        // When
        Map<Integer, Integer> connections = solve(in);

        // Then
        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    public void unicoParInvertido() {
        // Given
        String in = "LC";

        // When
        Map<Integer, Integer> connections = solve(in);

        // Then
        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
