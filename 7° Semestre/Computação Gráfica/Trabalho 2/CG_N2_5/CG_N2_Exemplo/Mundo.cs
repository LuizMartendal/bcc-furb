/*
 As constantes dos pré-processors estão nos arquivos ".csproj"
 desse projeto e da CG_Biblioteca.
*/

using CG_Biblioteca;
using OpenTK.Graphics.OpenGL4;
using OpenTK.Mathematics;
using OpenTK.Windowing.Common;
using OpenTK.Windowing.Desktop;
using OpenTK.Windowing.GraphicsLibraryFramework;
using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace gcgcg
{
  public class Mundo : GameWindow
  {
    private static Objeto mundo = null;

    private char rotuloAtual = '?';
    private Dictionary<char, Objeto> grafoLista = [];
    private Objeto objetoSelecionado = null;
    private Transformacao4D matrizGrafo = new();
    private int index = 0;
    private PrimitiveType[] primitives = [];
    private SrPalito srPalito;
    private Spline spline;
    private Circulo circuloMaior;
    private Circulo circuloMenor;
    private Retangulo box;
    private Ponto pontoCentral;
    private BBox bbox;

#if CG_Gizmo
    private readonly float[] _sruEixos =
    [
       0.0f,  0.0f,  0.0f, /* X- */      0.5f,  0.0f,  0.0f, /* X+ */
       0.0f,  0.0f,  0.0f, /* Y- */      0.0f,  0.5f,  0.0f, /* Y+ */
       0.0f,  0.0f,  0.0f, /* Z- */      0.0f,  0.0f,  0.5f  /* Z+ */
    ];
    private int _vertexBufferObject_sruEixos;
    private int _vertexArrayObject_sruEixos;

    // FPS
    private int frames = 0;
    private Stopwatch stopwatch = new();
#endif

    private Shader _shaderVermelha;
    private Shader _shaderVerde;
    private Shader _shaderAzul;
    private Shader _shaderCiano;

    public Mundo(GameWindowSettings gameWindowSettings, NativeWindowSettings nativeWindowSettings)
      : base(gameWindowSettings, nativeWindowSettings)
    {
      mundo ??= new Objeto(null, ref rotuloAtual); //padrão Singleton
    }

    protected override void OnLoad()
    {
      base.OnLoad();

      Utilitario.Diretivas();
#if CG_DEBUG      
      Console.WriteLine("Tamanho interno da janela de desenho: " + ClientSize.X + "x" + ClientSize.Y);
#endif

      GL.ClearColor(0.5f, 0.5f, 1.0f, 1.0f);

      #region Cores
      _shaderVermelha = new Shader("Shaders/shader.vert", "Shaders/shaderVermelha.frag");
      _shaderVerde = new Shader("Shaders/shader.vert", "Shaders/shaderVerde.frag");
      _shaderAzul = new Shader("Shaders/shader.vert", "Shaders/shaderAzul.frag");
      _shaderCiano = new Shader("Shaders/shader.vert", "Shaders/shaderCiano.frag");
      #endregion

#if CG_Gizmo
      #region Eixos: SRU  
      _vertexBufferObject_sruEixos = GL.GenBuffer();
      GL.BindBuffer(BufferTarget.ArrayBuffer, _vertexBufferObject_sruEixos);
      GL.BufferData(BufferTarget.ArrayBuffer, _sruEixos.Length * sizeof(float), _sruEixos, BufferUsageHint.StaticDraw);
      _vertexArrayObject_sruEixos = GL.GenVertexArray();
      GL.BindVertexArray(_vertexArrayObject_sruEixos);
      GL.VertexAttribPointer(0, 3, VertexAttribPointerType.Float, false, 3 * sizeof(float), 0);
      GL.EnableVertexAttribArray(0);
      #endregion

      stopwatch.Start();
#endif
      #region Objeto: componentes
      CriarComponentes(mundo, rotuloAtual);
      #endregion
#if CG_Privado
      #region Objeto: circulo - origem
      objetoSelecionado = new Circulo(mundo, ref rotuloAtual, 0.2)
      {
        ShaderObjeto = new Shader("Shaders/shader.vert", "Shaders/shaderAmarela.frag")
      };
      #endregion
      #region Objeto: circulo
      objetoSelecionado = new Circulo(mundo, ref rotuloAtual, 0.1, new Ponto4D(0.0, -0.5))
      {
        ShaderObjeto = new Shader("Shaders/shader.vert", "Shaders/shaderAmarela.frag")
      };
      #endregion
      #region Objeto: SrPalito  
      objetoSelecionado = new SrPalito(mundo, ref rotuloAtual);
      #endregion
      #region Objeto: SplineBezier
      objetoSelecionado = new SplineBezier(mundo, ref rotuloAtual);
      #endregion
      #region Objeto: SplineInter
      objetoSelecionado = new SplineInter(mundo, ref rotuloAtual);
      #endregion
#endif
    }

    protected override void OnRenderFrame(FrameEventArgs e)
    {
      base.OnRenderFrame(e);

      GL.Clear(ClearBufferMask.ColorBufferBit);

      matrizGrafo.AtribuirIdentidade();
      mundo.Desenhar(matrizGrafo, objetoSelecionado);

#if CG_Gizmo
      Gizmo_Sru3D();

      frames++;
      if (stopwatch.ElapsedMilliseconds >= 1000)
      {
        Console.WriteLine($"FPS: {frames}");
        frames = 0; 
        stopwatch.Restart();
      }
#endif
      SwapBuffers();
    }

    protected override void OnUpdateFrame(FrameEventArgs e)
    {
      double positivo = 0.01;
      double negativo = -0.01;
      double padrao = 0.0;

      base.OnUpdateFrame(e);

      #region Teclado
      var input = KeyboardState;
      if (input.IsKeyPressed(Keys.E) || input.IsKeyPressed(Keys.Left)) 
      {
          MoverPrincipal(negativo, padrao);
      }
      if (input.IsKeyPressed(Keys.D) || input.IsKeyPressed(Keys.Right)) 
      {
          MoverPrincipal(positivo, padrao);
      }
      if (input.IsKeyPressed(Keys.C) || input.IsKeyPressed(Keys.Up)) 
      {
          MoverPrincipal(padrao, positivo);
      }
      if (input.IsKeyPressed(Keys.B) || input.IsKeyPressed(Keys.Down)) 
      {
          MoverPrincipal(padrao, negativo);
      }
      #endregion
    }

    private void atualizarSegRetas() {
        spline.segReta1.ObjetoAtualizar();
        spline.segReta2.ObjetoAtualizar();
        spline.segReta3.ObjetoAtualizar();
        spline.pontos[spline.indice].Atualizar();
    }

    protected override void OnResize(ResizeEventArgs e)
    {
      base.OnResize(e);

#if CG_DEBUG      
      Console.WriteLine("Tamanho interno da janela de desenho: " + ClientSize.X + "x" + ClientSize.Y);
#endif
      GL.Viewport(0, 0, ClientSize.X, ClientSize.Y);
    }

    protected override void OnUnload()
    {
      mundo.OnUnload();

      GL.BindBuffer(BufferTarget.ArrayBuffer, 0);
      GL.BindVertexArray(0);
      GL.UseProgram(0);

#if CG_Gizmo
      GL.DeleteBuffer(_vertexBufferObject_sruEixos);
      GL.DeleteVertexArray(_vertexArrayObject_sruEixos);
#endif

      GL.DeleteProgram(_shaderVermelha.Handle);
      GL.DeleteProgram(_shaderVerde.Handle);
      GL.DeleteProgram(_shaderAzul.Handle);
      GL.DeleteProgram(_shaderCiano.Handle);

      base.OnUnload();
    }

    private void Gizmo_Sru3D()
    {
#if CG_Gizmo
#if CG_OpenGL
      var transform = Matrix4.Identity;
      GL.BindVertexArray(_vertexArrayObject_sruEixos);
      // EixoX
      _shaderVermelha.SetMatrix4("transform", transform);
      _shaderVermelha.Use();
      GL.DrawArrays(PrimitiveType.Lines, 0, 2);
      // EixoY
      _shaderVerde.SetMatrix4("transform", transform);
      _shaderVerde.Use();
      GL.DrawArrays(PrimitiveType.Lines, 2, 2);
      // EixoZ
      _shaderAzul.SetMatrix4("transform", transform);
      _shaderAzul.Use();
      GL.DrawArrays(PrimitiveType.Lines, 4, 2);
#endif
#endif
    }

    private void CriarComponentes(Objeto mundo, char rotuloAtual) 
    {
        pontoCentral = new Ponto(mundo, ref rotuloAtual, new Ponto4D(0, 0)) {
            PrimitivaTamanho = 3,
            ShaderObjeto = new Shader("Shaders/shader.vert", "Shaders/shaderCiano.frag")
        };

        circuloMaior = new Circulo(mundo, ref rotuloAtual, 0.5, 0) {
            ShaderObjeto = new Shader("Shaders/shader.vert", "Shaders/shaderAmarela.frag")
        };

        circuloMenor = new Circulo(mundo, ref rotuloAtual, 0.25, 0) {
            ShaderObjeto = new Shader("Shaders/shader.vert", "Shaders/shaderBranca.frag")
        };

        box = new Retangulo(mundo, ref rotuloAtual, circuloMaior.PontosId(9), circuloMaior.PontosId(45)) {
            PrimitivaTipo = PrimitiveType.LineLoop,
            ShaderObjeto = new Shader("Shaders/shader.vert", "Shaders/shaderAzul.frag")
        };

        List<Ponto4D> listaBBox = new List<Ponto4D> {circuloMaior.PontosId(9), circuloMaior.PontosId(45)};
        bbox = new BBox();
        bbox.Atualizar(new Transformacao4D(), listaBBox);
    }

    private void MoverPrincipal(double deslocX, double deslocY) 
    {    
        Ponto4D aux = new Ponto4D(pontoCentral.PontosId(0).X + deslocX,  pontoCentral.PontosId(0).Y + deslocY);     

        if (circuloMaior.Bbox().Dentro(aux) && Matematica.DistanciaQuadrado(aux, new Ponto4D(0, 0)) < 0.25)
        {
            pontoCentral.PontosId(0).X += deslocX;
            pontoCentral.PontosId(0).Y += deslocY;
            pontoCentral.Atualizar();

            circuloMenor.deslocarCirculo(deslocX, deslocY);

            box.PrimitivaTipo = bbox.Dentro(pontoCentral.PontosId(0)) ?  PrimitiveType.LineLoop : PrimitiveType.Points;      
        }
    }

  }
}
