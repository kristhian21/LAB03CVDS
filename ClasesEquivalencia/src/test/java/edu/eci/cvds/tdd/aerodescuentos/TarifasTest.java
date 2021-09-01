package edu.eci.cvds.tdd.aerodescuentos;
import org.junit.jupiter.api.Test;
//import static org.junit.Assert.assertTrue;
import junit.framework.Assert;


public class TarifasTest {

    @Test
    public void validateEdadNegativaTest() {
        try{
            CalculadorDescuentos.calculoTarifa(1000.4, 21, -1);
        }
        catch(Exception ex){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateTarifaNegativaTest() {

        try {
            CalculadorDescuentos.calculoTarifa(-1100, 21, 15);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void validateAplicaDescuentoMayorEdad1() {
        double result = CalculadorDescuentos.calculoTarifa(20000, 15, 75);
        double respuestaEsperada = 18400;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateNoAplicaDescuentoEdad() {
        double result = CalculadorDescuentos.calculoTarifa(20000, 15, 22);
        double respuestaEsperada = 20000;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateAplicaNoAplicaMenorEdad() {
        double result = CalculadorDescuentos.calculoTarifa(40000, 7, 18);
        double respuestaEsperada = 40000;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateAplicaDescuentoMenorEdad() {
        double result = CalculadorDescuentos.calculoTarifa(40000, 4, 16);
        double respuestaEsperada = 38000;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateAplicaDescuentoMayorEdad2() {
        double result = CalculadorDescuentos.calculoTarifa(80000, 4, 66);
        double respuestaEsperada = 73600;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateNoAplicaDescuentoMayorEdad() {
        double result = CalculadorDescuentos.calculoTarifa(90000, 1, 65);
        double respuestaEsperada = 90000;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateAplicaDiasAntelacion() {
        double result = CalculadorDescuentos.calculoTarifa(55000, 21, 22);
        double respuestaEsperada = 46750;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateNoAplicaDiasAntelacion() {
        double result = CalculadorDescuentos.calculoTarifa(55000, 6, 22);
        double respuestaEsperada = 55000;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateAplicanDosDescuentos() {
        double result = CalculadorDescuentos.calculoTarifa(63000, 25, 16);
        double respuestaEsperada = 50400;

        Assert.assertEquals(result, respuestaEsperada);
    }

    @Test
    public void validateTarifaCero() {
        double result = CalculadorDescuentos.calculoTarifa(0, 21, 22);
        double respuestaEsperada = 0;

        Assert.assertEquals(result, respuestaEsperada);
    }
    
}
