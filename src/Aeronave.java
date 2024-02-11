import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract public class Aeronave implements  Propulsor{
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

    public LocalDate getFecha_de_entrega(){
        return  fecha_de_entrega;
    }

    public Double horasBenef(){
        return null;
    }

    public String propul(){
        return null;
    }

    public DateTimeFormatter formadate(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yy");
        return f;
    }

    public Double totalHoras(){
        return null;
    }

    public Double facturacion(){
        return null;
    }
}
