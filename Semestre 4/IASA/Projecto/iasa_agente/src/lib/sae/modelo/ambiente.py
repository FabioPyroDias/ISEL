"""
Simulação de ambiente
@author: Luís Morgado
"""

import math
from enum import Enum

#__________________________________________________

# Elementos do ambiente
class Elemento(Enum):
	AGENTE 	  = '@'
	ALVO 	  = 'A'
	OBSTACULO = 'O'
	VAZIO 	  = '.'

# Direcções de movimento
class Direccao(Enum):
	NORTE = math.pi / 2
	SUL   = -math.pi / 2
	ESTE  = 0
	OESTE = math.pi

# Deslocações de movimento
DMOV = {
	Direccao.NORTE: (0, -1),
	Direccao.SUL  : (0, +1),
	Direccao.ESTE : (+1, 0),
	Direccao.OESTE: (-1, 0)
}

# Distância de movimento
# Não existem movimentos nas diagonais
DIST_MOV = 1

#__________________________________________________

class Ambiente:
	""" Gestão do ambiente """
	
	def __init__(self, def_amb, simulador):
		"""
		Criar ambiente
		@param def_amb: definição do ambiente
		"""
		self._def_amb = def_amb
		self._simulador = simulador
		self._elementos = None
		self._posicao_agente = None
		self._dim_x = None
		self._dim_y = None
		self._colisao = False
		self._recolha = False
		self.iniciar()
		
	@property
	def elementos(self):
		"""
		Obter dicionário <pos, elem> com todos os 
		elementos do ambiente
		"""
		return self._elementos
		
	@property
	def posicao_agente(self):
		"""
		Obter posição do agente
		"""
		return self._posicao_agente
		
	@property
	def colisao(self):
		"""
		Obter informação de colisão
		após último movimento
		"""
		return self._colisao
		
	@property
	def recolha(self):
		"""
		Obter informação de recolha de alvo
		após último movimento
		"""
		return self._recolha
		
	@property
	def dim_x(self):
		"""
		Obter dimensão X ambiente
		"""
		return self._dim_x
		
	@property
	def dim_y(self):
		"""
		Obter dimensão Y ambiente
		"""
		return self._dim_y

	def iniciar(self):
		"""
		Iniciar elementos do ambiente
		"""
		self._elementos = {}
		y = 0
		for linha in self._def_amb:
			x = 0
			for elem in linha:
				posicao = (x, y)
				self._elementos[posicao] = elem
				if elem == Elemento.AGENTE:
					self._posicao_agente = posicao
				x += 1
			y += 1
		# Definir dimensões do ambiente
		self._dim_x = len(self._def_amb[0])
		self._dim_y = y + 1
			   
	def posicoes(self, tipo=None):
		"""
		Obter posições dos elementos do ambiente
		@param tipo: tipo dos elementos a obter posição
		"""
		return [elem.posicao
				for elem in self._elementos
				if tipo is None or elem == tipo]
			   
	def elemento(self, posicao):
		"""
		Obter elemento de uma posição
		Qualquer posição não definida é considerada como obstáculo
		@param posicao: posição a observar
		"""
		return self._elementos.get(posicao, Elemento.OBSTACULO)
			
	def mover(self, direccao):
		"""
		Mover agente com notificação do simulador		
		@param direccao: direccão do movimento
		"""
		self.mover_agente(direccao)
			
	def mover_agente(self, direccao):
		"""
		Mover elemento do ambiente com detecção de colisão
		e recolha automática de alvo		
		@param direccao: direccão do movimento
		"""
		(x, y) = self._posicao_agente
		dx, dy = DMOV[direccao]
		nova_posicao = (x + dx, y + dy) 
		self._colisao = self.verificar_colisao(nova_posicao)
		if not self._colisao:
			self._recolha = self.verificar_recolha(nova_posicao)
			self._elementos[self._posicao_agente] = Elemento.VAZIO
			self._elementos[nova_posicao] = Elemento.AGENTE
			self._posicao_agente = nova_posicao
		else:
			self._recolha = False
							   
	def verificar_colisao(self, posicao):
		"""
		Verificar colisão com obstáculo
		@param posicao: posição a testar
		"""
		return self.elemento(posicao) == Elemento.OBSTACULO
							   
	def verificar_recolha(self, posicao):
		"""
		Verificar recolha de alvo
		@param posicao: posição a testar
		"""
		return self.elemento(posicao) == Elemento.ALVO
					
	def detectar(self, direccao):
		"""
		Detectar elemento numa direcção de movimento
		a partir da posição do agente
		@param direccao: direccão da detecção
		@return: elemento, distância
		"""
		posicao = self._posicao_agente
		distancia = 0
		while True:
			self.mover_agente(direccao)			 
			distancia += DIST_MOV
			elemento = self.elemento(posicao)
			if elemento:
				return elemento, distancia

						
	def detectar_dir(self):
		"""
		Detectar elementos nas várias direcções
		a partir da posição do agente
		@return: associações direcção: (elemento, distância)
			     para as várias direcções
		"""
		return {
			direccao: self.detectar_dir(direccao)
			for direccao in Direccao
		}

	
