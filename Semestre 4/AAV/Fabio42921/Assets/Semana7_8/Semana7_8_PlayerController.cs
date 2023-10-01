using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Semana7_8_PlayerController : MonoBehaviour
{
    [SerializeField] private Light lightLeftHand;
    [SerializeField] private Light lightRightHand;

    private Animator animator;

    // Start is called before the first frame update
    void Start()
    {
        animator = GetComponent<Animator>();
    }

    void Update()
    {
        animator.SetFloat("horizontal", Input.GetAxis("Horizontal"));
        animator.SetFloat("vertical", Input.GetAxis("Vertical"));
        animator.SetBool("wave", Input.GetMouseButton(0));

        float lightIntensity = animator.GetFloat("dancing");
        lightLeftHand.intensity = lightIntensity;
        lightRightHand.intensity = lightIntensity;
    }
}
