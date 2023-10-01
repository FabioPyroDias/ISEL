using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Semana11_Teorica_CapsulePlayer : MonoBehaviour
{
    [SerializeField] private float hp;
    [SerializeField] private float maxHp;
    [SerializeField] private float hurtValue;
    [SerializeField] private float healValue;

    [SerializeField] private Semana11_Teorica_UIManager uiManager;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKeyDown(KeyCode.Space))
        {
            TakeDamage();
        }

        if(Input.GetKeyDown(KeyCode.H))
        {
            HealDamage();
        }
    }

    private void ChangeHealth(float ammount)
    {
        hp = Mathf.Clamp(hp + ammount, 0, maxHp);

        Semana11_Teorica_UI.SetHp(hp, maxHp);
    }

    public void TakeDamage()
    {
        ChangeHealth(hurtValue);
    }

    public void HealDamage()
    {
        ChangeHealth(healValue);
    }
}