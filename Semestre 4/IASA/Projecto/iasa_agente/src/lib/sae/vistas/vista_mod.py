"""
Visualizador de modelo
@author: Luís Morgado
"""

from vista_amb import VistaAmb
from ambiente import AGENTE, ALVO, OBSTACULO, VAZIO

#_____________________________________________________________

class VistaMod(VistaAmb):
	def __init__(self, dim_x, dim_y, escala, corfundo):
		"""
		Iniciar visualizador
		@param svis: superfície de visualização
		@param escala: dimensão de cada elemento
		@param corfundo: cor de fundo
		"""
		super().__init__(dim_x, dim_y, escala, corfundo)
			
	def mostrar_elemento(self, posicao, elemento):
		"""
		Visualizar elemento numa posição
		@param vis: visualizador
		"""
		if elemento == AGENTE:
			self.agente(posicao)
		elif elemento == ALVO:
			self.alvo(posicao)
		elif elemento == OBSTACULO:
			self.obstaculo(posicao)
		elif elemento == VAZIO:
			self.vazio(posicao)  
 				
	def mostrar_elementos(self, elementos):
		"""
		Visualizar elementos do ambiente
		@param vis: visualizador
		"""
		for posicao, elemento in elementos.items():
			self.mostrar_elemento(posicao, elemento) 
			
	def mostrar_valor(self, valor, escala=None):
		"""
		Visualizar função valor
		@param valor: dicionário com associações posição:valor
		@param escala: (mínimo, máximo)
		"""
		if escala:
			vmin, vmax = escala
		else:
			vmax = max(valor.values())
			vmin = min(valor.values())
		# Mostrar valores em código de cores
		for pos, val in valor.items():
			self.valor_posicao(pos, val, vmin, vmax)
			
	def mostrar_valor_posicao(self, pos, val, vmin, vmax):
		"""
		Mostrar posição com cor correspondente ao valor
		@param pos: posição
		@param val: valor
		"""
		# Definir cor (R,G,B) com normalização de valor
		if   val > 0: cor = (0, (val / vmax) * 255, 0)
		elif val < 0: cor = ((val / vmin) * 255, 0, 0)
		else:		  cor = (0, 0, 0)
		# Mostrar posição com cor respectiva
		self.rect(pos, 0, cor, 0)
				
	def mostrar_politica(self, pol):
		"""
		Visualizar política
		@param pol: dicionário com associações posição:ângulo
		"""
		for pos, ang in pol.items():
			self.vector(pos, 1, ang)			   


		
