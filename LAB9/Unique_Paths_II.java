/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB9;

/**
 * autor: Chavez Caceres Samir 
 * ejercicio: Unique paths ii
 * proposito: Resuelve el enunciado de Unique paths ii, de un robot
 *          que queire llegar a la esquina opuesta solo moviendose
 *          abajo o derecha, se debe devolver la cantidad de maneras de ir
 *          de una esquina origen a la opuesta.
 */
public class Unique_Paths_II {
    public static void main(String[] args) {
        int[][] g = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniqPath(g));
    }
    public static int uniqPath(int[][] grid){
        //Recordando un problema de colegio se llena el array con los
        ///posibles caminos a el espacio actual, esto se logra
        //sumando los anteriores resultados, los de i-1,j y i,j-1
        //su es un obstaculo se pone 0 ya que no hay maneras de llegar a
        //ese cuadrado
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j<grid[0].length ; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                } else {
                    if(j - 1 < 0){
                        if(i - 1 < 0){
                           grid[i][j] = 1; 
                        } else {
                           grid[i][j] = 0 + grid[i-1][j];
                        }
                    } else {
                        if(i - 1 < 0){
                           grid[i][j] = 0 + grid[i][j - 1];
                        } else {
                           grid[i][j] = grid[i][j-1] + grid[i-1][j];
                        }
                    }
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
