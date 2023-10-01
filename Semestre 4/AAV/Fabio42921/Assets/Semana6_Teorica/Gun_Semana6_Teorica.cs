using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Gun_Semana6_Teorica : MonoBehaviour
{
    public float shootForce = 50;

    private Camera cam;
    private Animator animator;

    // Start is called before the first frame update
    void Start()
    {
        cam = Camera.main;
        animator = GetComponentInChildren<Animator>();
    }

    void Update()
    {
        animator.SetBool("isShooting", Input.GetButton("Fire1"));
    }

    public void Fire()
    {
        Ray ray = cam.ScreenPointToRay(Input.mousePosition);
        RaycastHit hit;

        if(Physics.Raycast(ray, out hit))
        {
            if(hit.rigidbody != null)
            {
                hit.rigidbody.AddForceAtPosition(ray.direction * shootForce, hit.point, ForceMode.VelocityChange);
            }
        }
    }
}
