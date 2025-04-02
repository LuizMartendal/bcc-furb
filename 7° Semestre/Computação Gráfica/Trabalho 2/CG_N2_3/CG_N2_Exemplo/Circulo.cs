using System.Collections.Generic;
using CG_Biblioteca;
using OpenTK.Graphics.OpenGL4;

namespace gcgcg
{
  internal class Circulo : Objeto
  {
    public Circulo(Objeto _paiRef, ref char _rotulo, Objeto objeto = null) : base(_paiRef, ref _rotulo, objeto)
    {
      PrimitivaTipo = PrimitiveType.Points;
      PrimitivaTamanho = 5;

      List<Ponto4D> pontos = CalcularPontos();
      foreach (Ponto4D ponto in pontos)
      {
        PontosAdicionar(ponto);
      }
      Atualizar();
    }

    private void Atualizar()
    {
      base.ObjetoAtualizar();
    }

    private List<Ponto4D> CalcularPontos()
    {
      List<Ponto4D> pontos = [];
      int numPontos = 72;
      double raio = 0.5;

      for (int i = 0; i < numPontos; i++)
      {
        double angulo = 360 / numPontos * i;
        Ponto4D ponto = Matematica.GerarPtosCirculo(angulo, raio);
        pontos.Add(ponto);
      }

      return pontos;
    }
  }
}