import tkinter as tk
from tkinter import ttk
import matplotlib.pyplot as plt
import subprocess
import threading
import time
import pynvml
from tkinter import messagebox
# Inicializa a NVML para monitoramento da GPU
pynvml.nvmlInit()
gpu_handle = pynvml.nvmlDeviceGetHandleByIndex(0)  # Usa a primeira GPU
# Função para monitorar o uso da GPU
def update_gpu_metrics(label):
    while True:
        gpu_util = pynvml.nvmlDeviceGetUtilizationRates(gpu_handle).gpu
        label.config(text=f"Uso da GPU: {gpu_util}%")
        time.sleep(1)
# Função para plotar gráficos de uso da GPU
def plot_gpu_usage(duration=10):
    plt.ion()
    fig, ax = plt.subplots()
    usage_data = []
    start_time = time.time()
    while time.time() - start_time < duration:
        gpu_util = pynvml.nvmlDeviceGetUtilizationRates(gpu_handle).gpu
        usage_data.append(gpu_util)
        ax.clear()
        ax.plot(usage_data, label="Uso da GPU (%)")
        ax.set_ylim(0, 150)
        ax.set_title("Monitoramento do Uso da GPU")
        ax.set_xlabel("Tempo (s)")
        ax.set_ylabel("Uso (%)")
        ax.legend()
        plt.pause(0.5)
    plt.ioff()
    plt.show()
# Função para executar código CUDA
def run_cuda(test_type):
    try:
        # Compila o código CUDA com nvcc
        subprocess.run(["nvcc", "gpu_extressor.cu", "-o", "gpu_extressor"], check=True)
        # Executa o programa compilado
        subprocess.run(["./gpu_extressor", str(test_type)], check=True)
        messagebox.showinfo("Execução", "Programa CUDA executado com sucesso!")
    except subprocess.CalledProcessError as e:
        messagebox.showerror("Erro", f"Falha ao executar o código CUDA: {e}")
# Função para executar CUDA em thread separada
def run_cuda_in_thread(type):
    threading.Thread(target=run_cuda, args=(type,), daemon=True).start()
# Interface gráfica usando tkinter
def create_interface():
    root = tk.Tk()
    root.title("Monitor de GPU e Executor CUDA")
    root.geometry("1280x720")
    # Frame para gráficos e métricas
    frame_metrics = ttk.Frame(root)
    frame_metrics.pack(side=tk.TOP, fill=tk.BOTH, expand=True)
    label_usage = ttk.Label(frame_metrics, text="Uso da GPU: --%", font=("Helvetica", 14))
    label_usage.pack(pady=10)
    # Inicia a atualização das métricas da GPU em uma thread separada
    threading.Thread(target=update_gpu_metrics, args=(label_usage,), daemon=True).start()
    # Botão para mostrar gráficos de uso da GPU
    btn_plot = ttk.Button(frame_metrics, text="Mostrar Gráficos de Uso da GPU", command=lambda: plot_gpu_usage(duration=60))
    btn_plot.pack(pady=10)
    # Campo de entrada para o tipo de teste
    frame_input = ttk.Frame(root)
    frame_input.pack(side=tk.TOP, fill=tk.X, pady=10)
    label_input = ttk.Label(frame_input, text="Digite o tipo de teste (ex: 1, 2):")
    label_input.pack(side=tk.LEFT, padx=5)
    entry_test_type = ttk.Entry(frame_input)
    entry_test_type.pack(side=tk.LEFT, padx=5)
    # Botão para executar código CUDA
    btn_run = ttk.Button(frame_input, text="Executar Código CUDA", command=lambda: run_cuda_in_thread(entry_test_type.get()))
    btn_run.pack(side=tk.LEFT, padx=5)
    # Área de saída de texto para resultados
    global output_text
    output_text = tk.Text(root, height=10)
    output_text.pack(fill=tk.BOTH, expand=True)
    root.mainloop()
# Executa a interface gráfica
create_interface()