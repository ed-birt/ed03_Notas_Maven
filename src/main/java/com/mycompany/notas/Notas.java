/*
 * Clase que trabaja con las notas de una asignatura
 */
package com.mycompany.notas;

import java.util.Arrays;

/**
 *
 * @author ulhi
 */
public class Notas {
    private int[] arNotas;
    private int notaMax;

    // Constructor de la clase
    // Recibe un array de enteros y lo copia en el atributo arNotas
    // Los arrays se pasan por referencia y si no se hace una copia,
    // estamos el mismo array y se podrá modificar desde fuera del objeto
    // Precondición: Si el array recibido no es válido genera una excepción
    public Notas(int[] valores, int max) { 
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("Este array no tiene elementos");
        }
        this.arNotas = Arrays.copyOf(valores, valores.length);
        this.notaMax = max;
    }
    
    // Getters
    public int getNotaMax() {
        return notaMax;
    }
    
    // Debemos devolver una copia
    // Se ha comentado para testear el constructor
    public int[] getArNotas() {
        return arNotas;
        //return Arrays.copyOf(arNotas, arNotas.length);
    }
    
    // Formatemos el contenido de la clase
    @Override
    public String toString() {
        String formato= "";
        formato += Arrays.toString(arNotas) + " max: " + notaMax;
        return formato;
    }

    // Método que recorre el array de notas, suma todos sus valores y calcula la media
    // Return: double con el valor de la media   
    public double calcularMedia() {
        int suma = 0;
        for (int i = 0; i < arNotas.length; i++) {
            suma += arNotas[i];
        }

        return (double) suma / arNotas.length;
    }

    // Método que recorre el array de notas y obtiene su valor mayor
    // Return: int con el valor mayor      
    public int calcularMax() {
        int max = arNotas[0];
        for (int i = 1; i < arNotas.length; i++) {
            // max = Math.max(max, values[i]);
            if (arNotas[i] > max) {
                max = arNotas[i];
            }
        }
        return max;
    }

   // Método que recorre el array de notas y cuenta cuantas veces se repite cada valor entre 0 y el máximo
   // Return: array de int con las veces que se repite cada número     
   public int[] cuentaNotas() {
      // Si la nota máxima es 10, crea un array para contar valores del 0 al 10
      int[] conts = new int[notaMax + 1];
      
      // Si la nota es un 1, lo cuenta en el elemento de indice 1 del array conts
      for (int i = 0; i < arNotas.length; i++) {
         int valor = arNotas[i];
         conts[valor]++;
      }
      return conts;
   }
   
   // Método que recorre el array de notas y comprueba si todas las notas son mayores o iguales que 5
   // Return: devuelve true si la condición se cumple   
   public boolean todosAprobados() {
      for (int nota:arNotas) {
        // Si encuentra un suspenso, la condición ya no se cumple y devuelve false
        double notaPonderada = (double) nota * 10 / notaMax;
        if (notaPonderada < 5) {
            return false;
        }
      }
      
      // Si recorre todo el array y todas las notas son aprobadas, devuelve true
      return true;
   }
}
