import java.time.LocalDate;

public class Avioneta extends Aeronave implements Propulsor{
    public Avioneta(String codigo_del_aparato, LocalDate fecha_de_entrega, String linea_de_montaje, Double horas_de_trabajo_previstas, Double horas_de_trabajo_ya_empleadas, Integer capacidad_pasajeros, Double coste, Double precio_venta) {
        super(codigo_del_aparato, fecha_de_entrega, linea_de_montaje, horas_de_trabajo_previstas, horas_de_trabajo_ya_empleadas, capacidad_pasajeros, coste, precio_venta);
    }
}
