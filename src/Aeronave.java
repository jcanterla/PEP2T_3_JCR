import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

abstract public class Aeronave implements Propulsor{
    protected String codigo_del_aparato;
    protected LocalDate fecha_de_entrega;
    protected String linea_de_montaje;
    protected Integer horas_de_trabajo_previstas;
    protected Integer horas_de_trabajo_ya_empleadas;
    protected Integer capacidad_pasajeros;
    protected Double coste;
    protected Double precio_venta;

    public Aeronave(String codigo_del_aparato, LocalDate fecha_de_entrega, String linea_de_montaje,
                    Integer horas_de_trabajo_previstas, Integer horas_de_trabajo_ya_empleadas,
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

    public String fechaEntrega(Integer numero_uno){
        if (numero_uno == 0) {
            String cadena = "Esta fábrica construyó su primera aeronave, un  " + getClass().getSimpleName() + " el " + formadate().format(fecha_de_entrega) +
                    " para " + capacidad_pasajeros + " pasajeros.";
            return cadena;
        } else {
            String cadena = "Después construyó un " + getClass().getSimpleName() + " el " + formadate().format(fecha_de_entrega) +
                    " para " + capacidad_pasajeros + " pasajeros.";
            return cadena;
        }

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
        String cadena = "La facturación total de la compañia a día de hoy: " + simbolo.format(facturacion_total);
        return cadena;
    }

    public static void main(String[] args) {
        LocalDate f1 = LocalDate.parse("12-31-2004", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f2 = LocalDate.parse("07-05-2005", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f3 = LocalDate.parse("04-30-2002", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f4 = LocalDate.parse("10-21-2003", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f5 = LocalDate.parse("01-01-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f6 = LocalDate.parse("09-23-2023", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f7 = LocalDate.parse("02-29-2024", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f8 = LocalDate.parse("05-12-2008", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f9 = LocalDate.parse("06-09-2001", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f10 = LocalDate.parse("03-13-2001", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f11 = LocalDate.parse("08-27-2020", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate f12 = LocalDate.parse("11-22-2019", DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        Aeronave[] tabla = {
            new AvComGran("ES2004", f1, "L2GA", 220, 250, 300, 1200000.50, 2000000.00),
            new AvComGran("ES2005", f2, "L2GB", 220, 250, 300, 1200000.50, 2000000.00),

            new AvComMed("ES2002", f3, "L3GA", 550, 540, 150, 1530000.50, 2500000.20),
            new AvComMed("ES2003", f4, "L3GB", 550, 540, 150, 1530000.50, 2500000.20),

            new Avioneta("ES2010", f5, "L4GA", 375, 420, 4, 900000.25, 1500000.75),
            new Avioneta("ES2023", f6, "L4GB", 375, 420, 4, 900000.25, 1500000.75),

            new Cohete("ES2024", f7, "L5GA", 1250, 1575, 6, 5000000.00, 10000000.00),
            new Cohete("ES20008", f8, "L5GB", 1250, 1575, 6, 5000000.00, 10000000.00),

            new Dron("ES2001", f9, "L5GA", 30, 28, 0, 500.99, 1000.00),
            new Dron("ES2001", f10, "L5GB", 30, 28, 0, 500.99, 1000.00),

            new Jet("ES2020", f11, "L6GA", 700, 702, 0, 1800000.10, 2000000.99),
            new Jet("ES2019", f12, "L6GB", 700, 702, 0, 1800000.10, 2000000.99)

        };

        Arrays.sort(tabla, Comparator.comparing(a -> a.fecha_de_entrega));

        System.out.println("\t\t\t\t\033[1m\033[4mPROGRAMA AERONAVES\033[0m");
        System.out.println();
        int numero_uno = 0;
        for(Aeronave e: tabla) {
            System.out.println(e.fechaEntrega(numero_uno));
            System.out.println("\t"+e.horasBenef());
            System.out.println("\t\t"+e.propul());
            System.out.println();
            numero_uno++;
        }
        System.out.println(tabla[7].totalHoras(tabla));
        System.out.println(tabla[1].facturacion(tabla));

    }
}
