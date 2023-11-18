# -*- coding: latin-1 -*-
# nota de violino estimada com x[n]=\sum_i wix[n-i] com i=1,...,10
import numpy as np
import scipy.signal as sg
import matplotlib.pyplot as plt
import scipy.io.wavfile as wav
from soundPlay import soundPlay
plt.close('all');np.random.seed(1)

#ler ficheiro wav
wavFile='Violin.arco.ff.sulG.Gb4.mono.wav'
fs,x=wav.read(wavFile)
#normalizar amplitude de x [-1,+1]
x=x.astype('float') #converter para float
x=x/2.0**15 #normalizar amplitude
############################################################
#contruir matrix X: 1ªlinha x[n-1], 2ª  x[n-2], 3ª x[n-3]...
#X=np.vstack((x[9:-1],x[8:-2],x[7:-3],x[6:-4],x[5:-5],\
#x[4:-6],x[3:-7],x[2:-8],x[1:-9],x[0:-10]))
pF=25 #ordem do filtro
X=x[0:-pF]
for i in np.arange(pF-1,0,-1):
    X=np.vstack((x[pF-i:-i],X))
    
#"Matriz" (1xN) dos ys
Y=x[pF:]#para ficar um array de (1x nº amostras)
Y=Y[np.newaxis,:]
#N=X.shape[1] #nº amostras
############################################################
#Estimar vector dos w=[w1,w2,...,w10].T
Rx=np.dot(X,X.T);rxy=np.dot(X,Y.T)
w=np.dot(np.linalg.pinv(Rx),rxy)
############################################################
#Ver o erro de estimação
#1. calcular y^
Y2=np.dot(w.T,X)
#2. Erro instantaneo Er[n]
Er=Y-Y2
#3. Erro total SUM(Er[n]^2)
ErTot=sum(Er**2)
#fazer plot
plt.figure(figsize=(6,3.5))
t=np.linspace(0,1.0*Er.shape[1]/fs,Er.shape[1])
plt.plot(t,Y[0,:],'-',lw=1,color=[.7,.7,.7])
plt.plot(t,Er[0,:],'-',lw=1,color=[.8,.3,.3])
plt.axis([0,1.8,-1,1])
plt.grid(True)
plt.xlabel('segundos')
plt.xticks(np.arange(0,1.8,.5));plt.yticks(np.arange(-1,1.1,.5))
plt.pause(.1)
############################################################
#Ver regressão como um filtro IIR só com pólos (e os 0s todos na origem)
#y[n]=w1y[n-1]+w2y[n-2]+...+x[n]
#(neste caso y[n] é o audio, e x[n] é o sinal de erro)
#coeficientes do filtro IIR =[1,-w1,-w2,...,-w10]
a=np.vstack((np.array([1.0]),-w))

#desenhar o diagrama de pólos e zeros
#1. desenhar circulo
cirTmp=np.exp(-1j*np.linspace(0,2*np.pi,1000))
#calcular pólos
r=np.roots(a[:,0])
plt.figure(figsize=(5.5,5))
plt.plot(np.real(cirTmp),np.imag(cirTmp),'-',lw=1,color=[.7,.7,.7])
plt.plot(np.real(r),np.imag(r),'*',ms=10,color=[.8,.3,.3])
plt.plot(0,0,'o',ms=10,color=[.25,.25,.5])
plt.axis('scaled')
plt.axis([-1.25,1.25,-1.25,1.25])
plt.grid(True)
plt.title(u'Diagrama de Pólos e Zeros',fontsize=14)
plt.xticks(np.arange(-1,1.1,.5))
plt.yticks(np.arange(-1,1.1,.5))
plt.pause(.1)

############################################################
#Ver a resposta em frequência
#1. FFT do sinal (só a magnitude)
#tirar parte do meio de x
Yf=np.abs(np.fft.fft(x[int(fs/3):fs]))
#normalizar amplitude para ser a mesma de H(z)
Yf=Yf*2.0/np.sqrt(Yf.shape[0]);
#ver só metade da resposta em amplitude
Yf=Yf[0:int(Yf.shape[0]/2)]
fhz1=np.linspace(0,int(fs/2.0),Yf.shape[0])/1000.
#ver a resposta em frequência do filtro
frads,H=np.abs(sg.freqz(1.0,a))
fhz2=frads/np.pi*fs/2./1000.
##outra maneira
#rads=np.linspace(0,np.pi,1000)
#H2=np.ones(1000)
#for i in np.arange(1,11):
#    H2=H2+a[i]*np.exp(-1j*rads*i)
#H2=np.abs(1.0/H2)

plt.figure(figsize=(6.,3.5))
plt.plot(fhz1,Yf,'-',color=[.8,.4,.4],lw=1)
plt.plot(fhz2,H,'-k',lw=2)#color=[1.,.3,.3],lw=1)
plt.grid(True)
plt.xlabel('kHz')
plt.ylabel('Amplitude')
plt.axis([0,11.025,0,60])
plt.pause(.1)

#em dBs
plt.figure(figsize=(6.,3.5))
plt.plot(fhz1,20.*np.log10(Yf),'-',color=[.8,.4,.4],lw=1)
plt.plot(fhz2,20.*np.log10(H),'-k',lw=2)
plt.axis([0,11.025,-80,40])
plt.grid(True)
plt.xlabel('kHz')
plt.ylabel('Amplitude dBs')
plt.pause(.1)

############################################################
#Sintetizar sinal com o filtro estimado
#visualizar autocorrelação do erro
#tirar só 5000 amostras do sinal (se não é demasiado pesado)
erTmp=Er[0,fs:fs+5000]
erAutoCorr=sg.convolve(erTmp,erTmp[np.arange(erTmp.shape[0]-1,0,-1)])
#erAutoCorr2=np.correlate(erTmp,erTmp,mode='full')

plt.figure(figsize=(6.,3.5))
plt.plot(np.arange(-5000+1,5000-1),erAutoCorr,'-k',lw=1)
plt.plot(np.arange(-500+1,500-1),erAutoCorr[5000-499:5000+499],'-',lw=1,color=[.4,.4,.4])
plt.fill([-500,-500,500,500,-500],[-4,10,10,-4,-4],color=[.8,.8,.8],alpha=.7)
plt.axis([-5000,5000,-2,8])
plt.grid(True)
plt.xlabel('amostras')
plt.ylabel(u'Autocorrelação do erro')


plt.figure(figsize=(6.,3.5))
plt.plot(np.arange(-500+1,500-1),erAutoCorr[5000-499:5000+499],'-k',lw=1)
plt.axis([-500,500,-2,8])
plt.grid(True)
plt.xlabel('amostras')
plt.ylabel(u'Autocorrelação do erro')
plt.pause(.1)

#gerar um trem de diracs e filtrar 
trDirac=np.zeros(x.shape[0])#produzir sinal do tamanho do original
#dirac cada 59 amostras (obtido visualizando autocorrelação do erro)
trDirac[np.arange(0,x.shape[0],59)]=1.0
xSint=sg.lfilter(np.array([1.0]),a[:,0],trDirac)
#sinal original
soundPlay(x,fs)
#sinal original
soundPlay(xSint,fs)
