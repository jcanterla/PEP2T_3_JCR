import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

abstract public class Aeronave implements Propulsor{
    private String codigo_del_aparato;
    private LocalDate fecha_de_entrega;
    private String linea_de_montaje;
    private Double horas_de_trabajo_previstas;
    private Double horas_de_trabajo_ya_empleadas;
    private Integer capacidad_pasajeros;
    private Double coste;
    private Double precio_venta;

    public Aeronave(String codigo_del_aparato, LocalDate fecha_de_entrega, String linea_de_montaje,
                    Double horas_de_trabajo_previstas, Double horas_de_trabajo_ya_empleadas,
                    Integer capacidad_pasajeros, Double coste, Double precio_venta) {
        this.codigo_del_aparato = codigo_del_aparato;
        this.fecha_de_entrega = fecha_de_entrega;
        this.linea_de_montaje = linea_de_montaje;
        this.horas_de_trabajo_previstas = horas_de_trabajo_previstas;
        this.horas_de_trabajo_ya_empleadas = horas_de_trabajo_ya_empleadas;
        this.capacidad_pasajeros = capacidad_pasajeros;
        this.coste = coste;
        this.precio_venta = precio_venta;
    }

    public String fechaEntrega(){
        String cadena = "Después construyó un " + getClass().getSimpleName() + " el " + formadate().format(fecha_de_entrega) +
                " para " + capacidad_pasajeros + " pasajeros.";
        return cadena;
    }

    public String horasBenef(){
        Locale euro = new Locale("es", "ES");
        NumberFormat simbolo = NumberFormat.getCurrencyInstance(euro);
        String cadena = "Esto supuso " + horas_de_trabajo_ya_empleadas + " horas de trabajo generando un beneficio de " +
                simbolo.format(precio_venta - coste);
        return cadena;
    }

    public String propul(){
        String cadena = "Esta aeronave utiliza queroxeno.";
        return cadena;
    }

    public DateTimeFormatter formadate(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yy");
        return f;
    }

    public String totalHoras(Aeronave[] tabla){
        int total_horas = 0;
        for (Aeronave e: tabla){
            if(e instanceof Avioneta){
                total_horas += e.horas_de_trabajo_ya_empleadas;
            }
        }
        String cadena = "El total de horas de trabajo empleadas en el tipo " + getClass().getSimpleName() + " fueron: " +
            total_horas;
        return cadena;
    }

    public String facturacion(Aeronave[] tabla){
        Locale euro = new Locale("es", "ES");
        NumberFormat simbolo = NumberFormat.getCurrencyInstance(euro);
        int facturacion_total = 0;
        for (Aeronave e: tabla){
            facturacion_total += e.precio_venta;
        }
        String cadena = "La facturación total de la compañia a día de hoy: " + facturacion_total + simbolo.format(facturacion_total);
        return cadena;
    }

    public static void main(String[] args) {
        LocalDate f1 = LocalDate.parse("12/31/01", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f2 = LocalDate.parse("07/05/05", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f3 = LocalDate.parse("04/30/01", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f4 = LocalDate.parse("10/21/01", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f5 = LocalDate.parse("01/01/10", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f6 = LocalDate.parse("09/23/23", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f7 = LocalDate.parse("02/29/24", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f8 = LocalDate.parse("05/12/08", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f9 = LocalDate.parse("06/09/09", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f10 = LocalDate.parse("03/13/15", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f11 = LocalDate.parse("08/27/20", DateTimeFormatter.ofPattern("MM/dd/yy"));
        LocalDate f12 = LocalDate.parse("11/22/19", DateTimeFormatter.ofPattern("MM/dd/yy"));

        Aeronave[] tabla = {
            new AvComGran("ES2324", f1, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),
            new AvComGran("ES2324", f2, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),

            new AvComMed("ES2324", f3, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),
            new AvComMed("ES2324", f4, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),

            new Avioneta("ES2324", f5, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),
            new Avioneta("ES2324", f6, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),

            new Cohete("ES2324", f7, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),
            new Cohete("ES2324", f8, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),

            new Dron("ES2324", f9, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),
            new Dron("ES2324", f10, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),

            new Jet("ES2324", f11, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20),
            new Jet("ES2324", f12, "L2GA", 120.5, 100.2, 300, 1200000.50, 250000.20)

        };

        Arrays.sort(tabla, Comparator.comparing(a -> a.fecha_de_entrega));

        for(Aeronave e: tabla) {
            System.out.println(e.fechaEntrega());
            System.out.println(e.horasBenef());
            System.out.println(e.propul());
            System.out.println();
        }
        System.out.println(tabla[6].totalHoras(tabla));
        System.out.println(tabla[1].facturacion(tabla));

    }
}
