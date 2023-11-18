# -*- coding: latin1 -*-
#necessita de ter instalado a toolbox PyAudio
#consultar:
#http://people.csail.mit.edu/hubert/pyaudio/
#Entradas:
#x: numpy array 
#Fs: frequência de amostragem (int16)
import pyaudio 
import numpy as  np

def soundPlay(x,Fs):
    Fs=np.int16(Fs)
    #escalar para +-1
    #converter para float
    x=np.array(x,'float32')
    x=x-x.mean()
    #normalizar
    x=x/np.abs(x).max()
    #converter para inteiros 16bits
    x=np.int16(np.round(x*(2**15-1)))
    
    #converter x para binary string
    xI=x.tostring()
        
        
    #instanciar audio
    auPort=pyaudio.PyAudio()
    #stream
    auStream=auPort.open(format=8,channels=1,rate=Fs,output=True)

    #play x
    auStream.write(xI)

    # stop stream 
    auStream.stop_stream()

    # close PyAudio 
    auPort.terminate()

   