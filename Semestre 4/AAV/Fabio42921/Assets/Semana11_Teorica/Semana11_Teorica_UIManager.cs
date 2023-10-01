using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Semana11_Teorica_UIManager : MonoBehaviour, Semana11_Teorica_UI.Interface
{
    [SerializeField] private RectTransform hpBar;

    private float originalWidth;

    // Start is called before the first frame update
    void Start()
    {
        Semana11_Teorica_UI.SetInstance(this);

        originalWidth = hpBar.sizeDelta.x;
    }

    // Update is called once per frame
    void Update()
    {

    }

    public void SetHp(float hp, float maxHp)
    {
        Vector2 sizeDelta = hpBar.sizeDelta;
        sizeDelta.x = (hp / maxHp) * originalWidth;

        hpBar.sizeDelta = sizeDelta;
    }
}
