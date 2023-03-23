/*
 * Pruebas unitarias para la clase Notas
 */
package com.mycompany.notas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author ulhi
 */
// Para poder ordenar los test
@TestMethodOrder(OrderAnnotation.class)
public class NotasTest {
    
    static Notas objetoNotas;
    
    public NotasTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    
    }
    
    @AfterAll
    public static void tearDownClass() {

    }
    
    @BeforeEach
    public void setUp() {
        
        // Instanciamos un objeto
        int[] datos = {0, 1, 2, 3, 4, 5};
        int max = 5;
        objetoNotas = new Notas(datos, max);
    }
    
    @AfterEach
    public void tearDown() {
    }

    // Testeamos el constructor
    @Test
    public void constructorTest(){
        System.out.println("Constructor");
        
        // Comprobamos si hemos creado un objeto de la clase Notas
        assertTrue(objetoNotas instanceof Notas);
        
        // Ejecutamos el método toString y comprobamos que el resultado coincide
        String expResult = "[0, 1, 2, 3, 4, 5] max: 5";
        String result = objetoNotas.toString();
        assertEquals(expResult, result);
        
        // Ejecutamos el método getArNotas y ejecutamos los test
        int expNumElem = 6;
        int[] datos = {0, 1, 2, 3, 4, 5};
        int[] notas = objetoNotas.getArNotas();
        int numElem = notas.length;
        
        // Comprobamos que la longitud del array es correcta
        assertEquals(expNumElem, numElem);
        
        // comprobamos que los valores del array son correctos
        assertArrayEquals(datos, notas);
        
        // Comprobamos que son diferentes arrays
        assertNotSame(datos, notas);       
    }
    
    // Comprobamos que si le pasamos valores no válidos al contructor
    // genera una excpción del tipo IllegalArgumentException
    @Test
    public void testExpectedException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Creamos un array no válido
            int[] datos = null;
            int max = 5;
        
            // Instanciamos un objeto
            Notas objetoNotas = new Notas(datos, max);
            
            // Creamos un array no válido
            datos = new int[0];
        
            // Instanciamos un objeto
            objetoNotas = new Notas(datos, max);
        });
    }
    
    /**
     * Test of calcularMedia method, of class Notas.
     */
    @Test
    @Order(1)
    public void testCalcularMedia() {
        System.out.println("calcularMedia");
        
        // Ejecutamos el método y ejecutamos el test
        double expResult = 2.5;
        double result = objetoNotas.calcularMedia();
        
        assertEquals(expResult, result, 0.0);
        
        // Instanciamos un objeto
        int[] datos = {0, 2, 4, 2};
        int max = 5;
        objetoNotas = new Notas(datos, max);
        // Ejecutamos el método y ejecutamos el test
        expResult = 2;
        result = objetoNotas.calcularMedia();
        
        assertEquals(expResult, result, 0.0);
    }
    
/**
     * Test parametrizado del método round1 de la clas MainIMC.
     * Nos permite ejecutar el mismo test con diferentes valores
     * Con @CsvSource definimos los valores para las pruebas
     * Entre comillas se identifican todos los valores de un test
     * Se separan con comas
     * También se separan con comas los valores de los diferentes tests
     */
    @ParameterizedTest
    @CsvSource({
        "0 1 2 3 4 5, 5, 2.5",
        "2 4 0, 5, 2",
        "2 4 2 0, 5, 2"
    })
    
    // Se le pasan como parámetros los valores definidos con @ParameterizedTest
    // Los valores se asignan según su orden en CsvSource
    // Solo podemos pasar valores simples, no arrays
    // El array lo pasamos como una cadena de carateres
    // con números separados por espacios
    public void ParameterizedTestCalcularMedia(String cadena, int max, double expResult) {
        System.out.println("calcularMedia");
        
        // Recibimos un String y lo convertimos en un array de enteros
        String[] valores = cadena.split(" ");
        
        int datos[] = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            datos[i] = Integer.parseInt(valores[i]);
        }
        
        // Instanciamos un objeto
        Notas objetoNotas = new Notas(datos, max);
        
        // Ejecutamos el método y ejecutamos el test
        double result = objetoNotas.calcularMedia();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularMax method, of class Notas.
     */
    @Test
    public void testCalcularMax() {
        System.out.println("calcularMax");
        
        
        // Ejecutamos el método y ejecutamos el test
        int expResult = 5;
        int result = objetoNotas.calcularMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of cuentaNotas method, of class Notas.
     */
    @Test

    public void testCuentaNotas() {
        System.out.println("cuentaNotas");
        
        // Preparamos los datos para las pruebas
        int[] datos = {2, 4, 4, 0};
        int max = 5;
        
        // Instanciamos un objeto
        Notas objetoNotas = new Notas(datos, max);
        
        // Ejecutamos el método y ejecutamos el test
        int[] expResult = {1, 0, 1, 0, 2, 0};
        int[] result = objetoNotas.cuentaNotas();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of todosAprobados method, of class Notas.
     */
    @Test
    public void testTodosAprobados() {
        System.out.println("todosAprobados");
        
        // Datos para realizar la prueba
        int[] datos = {2, 4, 5};
        int max = 5;
        
        // Instanciamos un objeto
        Notas objetoNotas = new Notas(datos, max);
        
        // Ejecutamos el método y ejecutamos el test
        boolean result = objetoNotas.todosAprobados();
        // assertFalse(result);
        assertFalse(result);
    }
    
}
