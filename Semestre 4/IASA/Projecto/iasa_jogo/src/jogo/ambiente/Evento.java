/**
 * Este enumerado servirá para determinar o estado em que o Ambiente se encontra.
 * Desta forma, o agente pode determinar qual o próximo passo.
 */
public enum Evento
{
    SILENCIO,
    RUIDO,
    ANIMAL,
    FUGA,
    FOTOGRAFIA,
    TERMINAR
}