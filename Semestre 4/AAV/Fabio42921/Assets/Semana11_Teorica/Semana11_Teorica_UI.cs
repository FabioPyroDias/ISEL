using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Semana11_Teorica_UI
{
    private static Interface instance;

    public static void SetInstance(Interface newInstance)
    {
        if(instance == null)
        {
            instance = newInstance;
        }
    }

    public static void SetHp(float hp, float maxHp)
    {
        if(instance != null)
        {
            instance.SetHp(hp, maxHp);
        }
    }

    public interface Interface
    {
        void SetHp(float hp, float maxHp);
    }
}
