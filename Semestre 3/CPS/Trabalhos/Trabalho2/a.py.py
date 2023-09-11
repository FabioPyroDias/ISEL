#!/usr/bin/env python
# coding: utf-8

# In[2]:


import numpy as np
import matplotlib.pyplot as plt


# # Emissor

# #### Descrição
# 
# Cria o Quantificador
# 
# 
# #### Parametros
# 
# R - Número de Bits
# 
# Vmax - Voltagem máxima para Quantificação do Sinal
# 
# Qtype - Tipo de Codifacação (midrise ou midtread)
# 
# 
# #### Return
# Vq - Valores de Quantificação
# 
# Iq - Intervalos de Decisão

# In[11]:


def Quantific(R,Vmax,Qtype):
    
    if Qtype != "midrise" and Qtype != "midtread":

        print("Tipo de Quantificador inserido não válido")

        return
    
    delta = (2*Vmax) / 2**R
    
    if Qtype == "midrise":
        
        Iq = np.arange(-Vmax + delta, Vmax + delta, delta)

        Vq = np.arange(-Vmax + (delta/2), Vmax + (delta/2), delta)
    
    else:
        
        Iq = np.arange(-Vmax + (delta/2), Vmax, delta)
        
        Vq = np.arange(-Vmax + delta, Vmax + delta, delta)

    return Vq, Iq


# #### Descrição
# 
# Quantifica o Sinal Analógico
# 
# 
# #### Parametros
# 
# Rx - Sinal Analógico
# 
# Vq - Valores de Quantificação
# 
# Iq - Intervalos de Decisão
# 
# 
# #### Return
# 
# xq - Sinal Quantificado
# 
# iq - Indices de Quantificação

# In[5]:


def Quantificador(Rx, Vq, Iq):
    
    xq = np.zeros(len(Rx))
    iq = np.zeros(len(Rx), dtype="int")

    indexQuantificado = 0
    
    for valorDoSinal in Rx:
    
        indexIntervalos = 0
        
        for intervaloDecisao in Iq:

            if valorDoSinal <= intervaloDecisao:
                xq[indexQuantificado] = Vq[indexIntervalos]
                iq[indexQuantificado] = indexIntervalos
                indexQuantificado += 1
                break
                
            if indexIntervalos >= len(Iq) - 1:
                xq[indexQuantificado] = Vq[indexIntervalos]
                iq[indexQuantificado] = indexIntervalos
                indexQuantificado += 1
                break
            
            indexIntervalos += 1
                
    return xq, iq


# # Receptor

# #### Descrição
# 
# Retorna o Sinal Quantificado
# 
# 
# #### Parametros
# 
# Vq - Valores de Quantificação
# 
# iq - Indices de Quantificação
# 
# 
# #### Return
# 
# xq - Sinal Quantificado

# In[12]:


def Desquantificador(Vq, iq):
    xq = np.zeros(len(iq))
    
    for valor in range(len(iq)):
        xq[valor] = Vq[iq[valor]]
        
    return xq


# # Utilidades

# #### Descrição
# 
# SNR Prático
# 
# 
# #### Parametros
# 
# x - Sinal 1
# 
# y - Sinal 2
# 
# 
# #### Return
# 
# SNRp - Valor do SNR Prático

# In[9]:


def Measure_SNRp(x,y):
    
    erro = x - y
    
    potenciaSinal = np.sum(x**2.0)/len(x)
    potenciaErro = np.sum(erro**2.0)/len(erro)
    
    SNRp = 10*np.log10(potenciaSinal / potenciaErro)
    
    # resposta
    return SNRp


# #### Descrição
# 
# SNR Teórico
# 
# 
# #### Parametros
# 
# R - Número de Bits
# 
# Vmax - Voltagem Máxima de Quantificação do Sinal
# 
# P - Potência do Sinal
# 
# 
# #### Return
# 
# SNRt - SNR Teórico

# In[10]:


def Measure_SNRt(R,Vmax,P):
    
    SNRt = 6.02*R + 10*np.log10((3*P)/Vmax**2.0)
    
    #resposta
    return SNRt


# In[ ]:


get_ipython().system('jupyter nbconvert --to script EmissorEReceptor.ipynb')

