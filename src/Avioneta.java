import java.time.LocalDate;

public class Avioneta extends Aeronave implements Propulsor{
    public Avioneta(String codigo_del_aparato, LocalDate fecha_de_entrega, String linea_de_montaje, Integer horas_de_trabajo_previstas, Integer horas_de_trabajo_ya_empleadas, Integer capacidad_pasajeros, Double coste, Double precio_venta) {
        super(codigo_del_aparato, fecha_de_entrega, linea_de_montaje, horas_de_trabajo_previstas, horas_de_trabajo_ya_empleadas, capacidad_pasajeros, coste, precio_venta);
    }

    public String fechaEntrega(Integer numero_uno){
        if (numero_uno == 0) {
            String cadena = "Esta fábrica construyó su primera aeronave, una  " + getClass().getSimpleName() + " el " + formadate().format(fecha_de_entrega) +
                    " para " + capacidad_pasajeros + " pasajeros.";
            return cadena;
        } else {
            String cadena = "Después construyó una " + getClass().getSimpleName() + " el " + formadate().format(fecha_de_entrega) +
                    " para " + capacidad_pasajeros + " pasajeros.";
            return cadena;
        }

    }

    public String propul(){
        String cadena = "Esta aeronave utiliza diesel.";
        return cadena;
    }
}
