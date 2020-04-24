package subasta.tp3;

import java.io.Serializable;

public class InformacionOferta implements Serializable {

    String comprador;
    String producto;
    float monto;

    public InformacionOferta(String c, String p, float m) {

        comprador = c;
        producto = p;
        monto = m;
    }
}
