using System.Collections.Generic;
using CG_Biblioteca;
using OpenTK.Graphics.OpenGL4;

namespace gcgcg
{
  internal class Circulo : Objeto
    {
        private double raio;
        private List<Ponto4D> pontosCirculo;

        public Circulo(Objeto _paiRef, ref char _rotulo, double raio, double deslocamento) : base(_paiRef, ref _rotulo)
        {
            configInicial(raio, deslocamento);
        }

        public void configInicial(double raio, double deslocamento)
        {
            PrimitivaTipo = PrimitiveType.LineLoop;
            PrimitivaTamanho = 2;
            this.raio = raio;
            pontosCirculo = new List<Ponto4D>();

            atualizarCalculoPontos(deslocamento);
        }

        public  void CalcularPontosCirculo(double deslocamento)
        {
            pontosCirculo.Clear();
            
            int numPontos = 72;
            
            double angulo = 360 / numPontos;
            double add = angulo;

            for (int i = 0; i < numPontos; i++)
            {
                Ponto4D ponto = new(Matematica.GerarPtosCirculo(angulo, raio).X + deslocamento, 
                Matematica.GerarPtosCirculo(angulo, raio).Y + deslocamento);
                pontosCirculo.Add(ponto);
                angulo += add;
            }
        }

        public void atualizarCalculoPontos(double deslocamento) 
        {
            CalcularPontosCirculo(deslocamento);
            pontosLista.Clear();        
            foreach (Ponto4D ponto in pontosCirculo) {
                PontosAdicionar(ponto);
            }
        }

        public void deslocarCirculo(double x, double y)
        {
            int i = 0;

            foreach (Ponto4D pto in pontosCirculo)
            {
                pto.X += x;
                pto.Y += y;

                PontosAlterar(pto, i);    
                i ++;    
            }
        }
    } 
}