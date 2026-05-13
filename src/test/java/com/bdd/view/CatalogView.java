package com.bdd.view;

import com.mobile.MobileBase;
import com.mobile.MobileDriverManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class CatalogView extends MobileBase {

    private void esperarUnSegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

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

    private void scrollHastaAddToCart() {
        MobileDriverManager.getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add to cart\"))"
                )
        );
        esperarUnSegundo();
    }

    public boolean validarPantalla(String sTitulo) {
        return existeElemento(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV' and @text='Products']"), 30);
    }

    public void seleccionarProducto(String producto) {
        By productoLocator = By.xpath("//android.widget.ImageView[@content-desc='" + producto + "']");
        obtenerElemento(productoLocator, 30).click();
        esperarUnSegundo();
    }

    public void agregarCantidad(int unidades) {
        if (unidades <= 1) {
            return;
        }

        scrollHastaAddToCart();
        esperarUnSegundo();

        By btnMasCantidad = By.id("com.saucelabs.mydemoapp.android:id/plusIV");

        for (int i = 1; i < unidades; i++) {
            MobileElement botonMas = obtenerElemento(btnMasCantidad, 30);
            esperarUnSegundo();
            botonMas.click();
            esperarUnSegundo();
        }
    }

    public void agregarProductoCarrito() {
        scrollHastaAddToCart();

        By btnAgregarCarrito = By.id("com.saucelabs.mydemoapp.android:id/cartBt");
        obtenerElemento(btnAgregarCarrito, 30).click();

        esperarUnSegundo();
    }

    public void ingresarCarrito() {
        By btnCarrito = By.id("com.saucelabs.mydemoapp.android:id/cartIV");
        obtenerElemento(btnCarrito, 30).click();
        esperarUnSegundo();
    }

    public boolean validarProductoCarrito(String producto) {
        By productoCarrito = By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV' and @text='" + producto + "']");
        return existeElemento(productoCarrito, 30);
    }
}