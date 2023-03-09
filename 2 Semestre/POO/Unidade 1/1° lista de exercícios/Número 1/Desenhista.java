
/**
 * Escreva uma descrição da classe Desenhista aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Desenhista
{
    public void desenharFigura(){
        Circle rosto = new Circle();
        rosto.makeVisible();
        rosto.moveRight();
        rosto.moveRight();
        rosto.changeSize(140);
        
        Circle lefteye = new Circle();
        lefteye.makeVisible();
        lefteye.moveRight();
        lefteye.moveRight();
        lefteye.moveRight();
        lefteye.changeColor("green");
        lefteye.moveDown();
        
        Circle righteye = new Circle();
        righteye.makeVisible();
        righteye.moveRight();
        righteye.moveRight();
        righteye.moveRight();
        righteye.moveRight();
        righteye.moveRight();
        righteye.moveRight();
        righteye.moveRight();
        righteye.changeColor("green");
        righteye.moveDown();
        righteye.moveHorizontal(-10);
        
        Square boca = new Square();
        boca.makeVisible();
        boca.moveRight();
        boca.moveRight();
        boca.moveRight();
        boca.moveDown();
        boca.moveDown();
        boca.moveDown();
        boca.moveDown();
        boca.moveDown();
        boca.moveHorizontal(-5);
        
        Triangle nariz = new Triangle();
        nariz.makeVisible();
        nariz.changeColor("black");
        nariz.moveRight();
        nariz.moveRight();
        nariz.moveRight();
        nariz.moveRight();
        nariz.moveDown();
        nariz.moveDown();
        nariz.moveDown();
        nariz.moveDown();
        nariz.moveDown();
    }
    
}


