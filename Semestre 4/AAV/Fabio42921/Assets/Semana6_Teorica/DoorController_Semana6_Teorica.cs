using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DoorController_Semana6_Teorica : MonoBehaviour
{
    private Animator animator;
    // Start is called before the first frame update
    void Start()
    {
        animator = GetComponent<Animator>();

        animator.SetTrigger("open");
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
