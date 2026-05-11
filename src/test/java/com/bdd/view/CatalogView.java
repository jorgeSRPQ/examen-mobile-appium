package com.bdd.view;

import com.mobile.MobileBase;
import com.mobile.MobileDriverManager;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class CatalogView extends MobileBase {

    private boolean existeElemento(By locator, int segundos) {
        for (int i = 0; i < segundos; i++) {
            List<MobileElement> elementos = MobileDriverManager.getDriver().findElements(locator);

            if (!elementos.isEmpty() && elementos.get(0).isDisplayed()) {
                return true;
            }

            esperarUnSegundo();
        }
        return false;
    }

    private MobileElement obtenerElemento(By locator, int segundos) {
        for (int i = 0; i < segundos; i++) {
            List<MobileElement> elementos = MobileDriverManager.getDriver().findElements(locator);

            if (!elementos.isEmpty() && elementos.get(0).isDisplayed()) {
                return elementos.get(0);
            }

            esperarUnSegundo();
        }

        throw new RuntimeException("No se encontro el elemento: " + locator);
    }

    private void esperarUnSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean validarPantalla(String sTitulo) {
        return existeElemento(By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']"), 15);
    }

    public void seleccionarProducto(String producto) {
        By productoLocator = By.xpath("//android.widget.TextView[@text='" + producto + "']");
        obtenerElemento(productoLocator, 15).click();
    }

    public void agregarCantidad(int unidades) {
        By btnMasCantidad = By.id("com.saucelabs.mydemoapp.android:id/plusIV");

        for (int i = 1; i < unidades; i++) {
            obtenerElemento(btnMasCantidad, 10).click();
        }
    }

    public void agregarProductoCarrito() {
        By btnAgregarCarrito = By.id("com.saucelabs.mydemoapp.android:id/cartBt");
        obtenerElemento(btnAgregarCarrito, 15).click();
    }

    public void ingresarCarrito() {
        By btnCarrito = By.id("com.saucelabs.mydemoapp.android:id/cartRL");
        obtenerElemento(btnCarrito, 10).click();
    }

    public boolean validarProductoCarrito(String producto) {
        By productoCarrito = By.xpath("//android.widget.TextView[@text='" + producto + "']");
        return existeElemento(productoCarrito, 15);
    }
}