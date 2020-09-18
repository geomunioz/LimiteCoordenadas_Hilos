/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconcurrente;

import java.util.Random;
import javax.swing.*;

public class Ball extends Thread{
    private PanelBall panel;
    private MiX x;
    private MiY y;
    
    private int direccion; //direccion de movimiento
    
    Ball(PanelBall panel, MiX x, MiY y){
        this.panel = panel;
        this.x = x;
        this.y = y;
        direccion = 4;
    }
    
    public void run(){
        while(true){
            try{
                if(y.getY() <= 0){
                    int i = (int) (Math.random()*3)+1; //Se obtiene un numero entre 1-3 para definir la direccion del movimiento
                    direccion = i == 1 ? 6 : i == 2 ? 0 : 4; //se asiga la direccion del movimiento a seguir
                    movimiento();// dentro de la funcion dependiendo el movimiento se realizara la suma o resta corespondiente.
                }else if(x.getX() <= 0){
                    int i = (int) (Math.random()*3)+1;
                    direccion = i == 1 ? 7 : i == 2 ? 2 : 4;
                    movimiento();
                }else if(y.getY() >= 500-20){//panel.getHeight()
                    int i = (int) (Math.random()*3)+1;
                    direccion = i == 1 ? 5 : i == 2 ? 1 : 7;
                    movimiento();
                }else if(x.getX() >= 700-20){ //panel.getX()
                    int i = (int) (Math.random()*3)+1;
                    direccion = i == 1 ? 6 : i == 2 ? 3 : 5;
                    movimiento();
                }else{
                    movimiento();
                }
                
                panel.repaint();                
                Thread.sleep(10);    
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void movimiento(){
        switch(direccion){
            case 0:
                y.setY(y.getY()+10); // en direccion a las hacia abajo
                break;
            case 1:
                y.setY(y.getY()-10); //en direccion hacia arriba
                break;
            case 2:
                x.setX(x.getX()+10); //en direccion a la derecha
                break;
            case 3:
                x.setX(x.getX()-10); //en direccion a la izquierda
                break;
            case 4:
                x.setX(x.getX()+10); //en diagonal de la esquina superior izquierda a la esquina inferior derecha 
                y.setY(y.getY()+10);
                break;
            case 5:
                x.setX(x.getX()-10);//en diagonal de la esquina inferior derecha a la esquina superior izquierda 
                y.setY(y.getY()-10);
                break;
            case 6:
                x.setX(x.getX()-10); //en diagonal de la esquina superior derecha a la esquina inferior izquierda
                y.setY(y.getY()+10);
                break;
            case 7:
                x.setX(x.getX()+10); //en diagonal de la esquina inferior izquierda a la esquina superior derecha 
                y.setY(y.getY()-10);
                break;
            default:
                System.out.println("Error");
                break;
                
        }
    }
}
