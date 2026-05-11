package com.bdd.step;

import com.bdd.view.CatalogView;
import net.thucydides.core.annotations.Step;

public class CatalogStep {

    private CatalogView catalogSauceView() {
        return new CatalogView();
    }

    @Step
    public boolean validarPantalla(String sTitulo) {
        return catalogSauceView().validarPantalla(sTitulo);
    }

    @Step
    public void seleccionarProducto(String producto) {
        catalogSauceView().seleccionarProducto(producto);
    }

    @Step
    public void agregarCantidad(int unidades) {
        catalogSauceView().agregarCantidad(unidades);
    }

    @Step
    public void agregarProductoCarrito() {
        catalogSauceView().agregarProductoCarrito();
    }

    @Step
    public void ingresarCarrito() {
        catalogSauceView().ingresarCarrito();
    }

    @Step
    public boolean validarProductoCarrito(String producto) {
        return catalogSauceView().validarProductoCarrito(producto);
    }
}