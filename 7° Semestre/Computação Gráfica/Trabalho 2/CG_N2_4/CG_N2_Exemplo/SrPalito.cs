using CG_Biblioteca;
using OpenTK.Graphics.OpenGL4;

namespace gcgcg
{
    internal class SrPalito : Objeto
    {
        double raio = 0.5;
        double angulo = 45;
        double posicaoX = 0;
        double posicaoY = 0;
        Ponto ponto;
        Retangulo retangulo;

        public SrPalito(Objeto _paiRef, char _rotulo) : base(_paiRef, ref _rotulo)
        {
            PrimitivaTipo = PrimitiveType.Lines;
            PrimitivaTamanho = 2;

            AtualizarFrames();

            Ponto4D pontoA = PontosId(0);
            Ponto4D pontoB = PontosId(1);

            double meioX = (pontoA.X + pontoB.X) / 2;
            double meioY = (pontoA.Y + pontoB.Y) / 2;

            ponto = new Ponto(_paiRef, ref _rotulo, new Ponto4D(meioX, meioY))
            {
                PrimitivaTipo = PrimitiveType.Points,
                PrimitivaTamanho = 5
            };

            retangulo = new Retangulo(_paiRef, ref _rotulo, pontoA, pontoB)
            {
                PrimitivaTipo = PrimitiveType.LineLoop
            };

        }

        public void AtualizarFrames()
        {
            pontosLista.Clear();

            Ponto4D pontoInicial = Matematica.GerarPtosCirculo(angulo, raio);
            pontoInicial.X += posicaoX;
            pontoInicial.Y += posicaoY;

            PontosAdicionar(pontoInicial);
            PontosAdicionar(new Ponto4D(posicaoX, posicaoY));

            base.ObjetoAtualizar();
        }

        public void diminuirPosicaoX() 
        {
            posicaoX -= 0.1;
            AtualizarFrames();
            AtualizarPonto();
            AtualizarRetangulo();
        }

        public void aumentarPosicaoX()
        {
            posicaoX += 0.1;
            AtualizarFrames();
            AtualizarPonto();
            AtualizarRetangulo();
        }

        public void diminuirRaio()
        {
            raio -= 0.1;
            AtualizarFrames();
            AtualizarPonto();
            AtualizarRetangulo();
        }

        public void aumentarRaio()
        {
            raio += 0.1;
            AtualizarFrames();
            AtualizarPonto();
            AtualizarRetangulo();
        }

        public void diminuirAngulo()
        {
            angulo -= 1;
            AtualizarFrames();
            AtualizarPonto();
            AtualizarRetangulo();
        }

        public void aumentarAngulo()
        {
            angulo += 1;
            AtualizarFrames();
            AtualizarPonto();
            AtualizarRetangulo();
        }

        public double GetPosicaoX()
        {
            return posicaoX;
        }

        public double GetPosicaoY()
        {
            return posicaoY;
        }

        private void AtualizarPonto()
        {
            Ponto4D pontoInicial = PontosId(0);
            double meioX = (pontoInicial.X + GetPosicaoX()) / 2;
            double meioY = (pontoInicial.Y + GetPosicaoY()) / 2;
            ponto.PontosApagar();
            ponto.PontosAdicionar(new Ponto4D(meioX, meioY));
            ponto.Atualizar(); 
        }

        private void AtualizarRetangulo()
        {
            Ponto4D pontoA = PontosId(0);
            double pontoBx = GetPosicaoX();
            double pontoBy = GetPosicaoY();
            retangulo.PontosApagar();
            retangulo.PontosAdicionar(pontoA);
            retangulo.PontosAdicionar(new Ponto4D(pontoA.X, pontoBy));
            retangulo.PontosAdicionar(new Ponto4D(pontoBx, pontoBy));
            retangulo.PontosAdicionar(new Ponto4D(pontoBx, pontoA.Y));
            retangulo.ObjetoAtualizar();
        }
    }    
}