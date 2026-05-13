package com.bdd.glue;

import com.bdd.step.CatalogStep;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Cuando;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CatalogGlue {

    @Steps
    private CatalogStep catalogStep;

    @Y("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {

        Assert.assertTrue(
                "No cargo correctamente la galeria",
                catalogStep.validarPantalla("Products"));
    }

    @Cuando("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int unidades, String producto) {

        catalogStep.seleccionarProducto(producto);

        for (int i = 0; i < unidades; i++) {
            catalogStep.agregarProductoCarrito();
        }

        catalogStep.ingresarCarrito();
    }

    @Entonces("valido el carrito de compra actualice correctamente para el producto {string}")
    public void validoElCarritoDeCompraActualiceCorrectamente(String producto) {

        Assert.assertTrue(
                "No se encontro el producto en el carrito",
                catalogStep.validarProductoCarrito(producto));
    }

    @Entonces("deberia mostrarme la pantalla de catalogo de productos {string}")
    public void deberiaMostrarmeLaPantallaDeCatalogoDeProductos(String titulo) {
        Assert.assertTrue(
                "No mostro pantalla: " + titulo,
                catalogStep.validarPantalla(titulo)
        );
    }
}